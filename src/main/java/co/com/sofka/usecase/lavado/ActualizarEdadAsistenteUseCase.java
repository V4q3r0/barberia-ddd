package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarEdadAsistenteCommand;

public class ActualizarEdadAsistenteUseCase extends UseCase<RequestCommand<ActualizarEdadAsistenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEdadAsistenteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarEdadAsistente(command.getEdad());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
