package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.CambiarClienteCommand;

public class CambiarClienteUseCase extends UseCase<RequestCommand<CambiarClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.cambiarCliente(command.getClienteId(), command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
