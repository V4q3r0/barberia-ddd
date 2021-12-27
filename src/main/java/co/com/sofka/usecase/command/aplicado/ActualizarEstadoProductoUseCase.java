package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarEstadoProductoCommand;

public class ActualizarEstadoProductoUseCase extends UseCase<RequestCommand<ActualizarEstadoProductoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstadoProductoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.actualizarEstadoProducto(command.getProductoId(), command.getEstado());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
