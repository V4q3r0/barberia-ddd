package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarEstadoSecadoraCommand;

public class ActualizarEstadoSecadoraUseCase extends UseCase<RequestCommand<ActualizarEstadoSecadoraCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstadoSecadoraCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarEstadoSecadora(command.getEstado());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
