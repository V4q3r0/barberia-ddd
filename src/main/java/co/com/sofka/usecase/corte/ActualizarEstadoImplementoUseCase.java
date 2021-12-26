package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarEstadoImplementoCommand;

public class ActualizarEstadoImplementoUseCase extends UseCase<RequestCommand<ActualizarEstadoImplementoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstadoImplementoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarEstadoImplementado(command.getImplementoId(), command.getEstado());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
