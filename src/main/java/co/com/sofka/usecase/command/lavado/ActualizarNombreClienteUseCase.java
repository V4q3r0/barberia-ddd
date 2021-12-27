package co.com.sofka.usecase.command.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarNombreClienteCommand;

public class ActualizarNombreClienteUseCase extends UseCase<RequestCommand<ActualizarNombreClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarNombreCliente(command.getNombre());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
