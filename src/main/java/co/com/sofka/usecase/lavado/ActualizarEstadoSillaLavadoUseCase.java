package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarEstadoSillaLavadoCommand;

public class ActualizarEstadoSillaLavadoUseCase extends UseCase<RequestCommand<ActualizarEstadoSillaLavadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstadoSillaLavadoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarEstadoSillaLavado(command.getEstado());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
