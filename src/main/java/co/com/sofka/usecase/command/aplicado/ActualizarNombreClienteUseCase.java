package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarNombreClienteCommand;

public class ActualizarNombreClienteUseCase extends UseCase<RequestCommand<ActualizarNombreClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.actualizarNombreCliente(command.getNombre());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
