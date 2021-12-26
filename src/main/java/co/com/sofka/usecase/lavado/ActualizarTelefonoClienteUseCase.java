package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarTelefonoClienteCommand;

public class ActualizarTelefonoClienteUseCase extends UseCase<RequestCommand<ActualizarTelefonoClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarTelefonoCliente(command.getTelefono());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
