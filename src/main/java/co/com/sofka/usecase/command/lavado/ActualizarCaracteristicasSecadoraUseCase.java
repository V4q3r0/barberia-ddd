package co.com.sofka.usecase.command.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarCaracteristicasSecadoraCommand;

public class ActualizarCaracteristicasSecadoraUseCase extends UseCase<RequestCommand<ActualizarCaracteristicasSecadoraCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCaracteristicasSecadoraCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarCaracteristicasSecadora(command.getNombreC(), command.getPrecio());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
