package co.com.sofka.usecase.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarCaracteristicasProductoCommand;

public class ActualizarCaracteristicasProductoUseCase extends UseCase<RequestCommand<ActualizarCaracteristicasProductoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCaracteristicasProductoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.actualizarCaracteristicasProducto(
                command.getProductoId(),
                command.getNombreC(),
                command.getPrecio()
        );
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
