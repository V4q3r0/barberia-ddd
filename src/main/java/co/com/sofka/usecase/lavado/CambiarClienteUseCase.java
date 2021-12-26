package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.CambiarClienteCommand;

public class CambiarClienteUseCase extends UseCase<RequestCommand<CambiarClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.cambiarCliente(command.getClienteId(), command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
