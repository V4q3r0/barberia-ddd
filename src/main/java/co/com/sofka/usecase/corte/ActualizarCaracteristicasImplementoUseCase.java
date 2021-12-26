package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarCaracteristicasImplementoCommand;

public class ActualizarCaracteristicasImplementoUseCase extends UseCase<RequestCommand<ActualizarCaracteristicasImplementoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCaracteristicasImplementoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarCaracteristicasImplemento(command.getImplementoId(), command.getNombreC(), command.getPrecio());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
