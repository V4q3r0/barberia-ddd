package co.com.sofka.usecase.command.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarDuracionLavadoCommand;

public class ActualizarDuracionLavadoUseCaso extends UseCase<RequestCommand<ActualizarDuracionLavadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDuracionLavadoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarDuracionLavado(command.getDuracion());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
