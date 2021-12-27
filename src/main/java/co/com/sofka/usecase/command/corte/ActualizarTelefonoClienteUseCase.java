package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarTelefonoClienteCommand;

public class ActualizarTelefonoClienteUseCase extends UseCase<RequestCommand<ActualizarTelefonoClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarTelefonoCliente(command.getTelefono());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
