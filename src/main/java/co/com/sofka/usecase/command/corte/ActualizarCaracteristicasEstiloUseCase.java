package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarCaracteristicasEstiloCommand;

public class ActualizarCaracteristicasEstiloUseCase extends UseCase<RequestCommand<ActualizarCaracteristicasEstiloCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCaracteristicasEstiloCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarCaracteristicasEstilo(command.getNombreC(), command.getPrecio());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
