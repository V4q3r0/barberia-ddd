package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.AgregarProductoCommand;

public class AgregarProductoUseCase extends UseCase<RequestCommand<AgregarProductoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProductoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.agregarProducto(command.getProductoId(), command.getMarca(), command.getTipo(), command.getCaracteristicas(), command.getEstado());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
