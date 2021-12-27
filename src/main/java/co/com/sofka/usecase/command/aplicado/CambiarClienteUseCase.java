package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.CambiarClienteCommand;

public class CambiarClienteUseCase extends UseCase<RequestCommand<CambiarClienteCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.cambiarCliente(command.getClienteId(), command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
