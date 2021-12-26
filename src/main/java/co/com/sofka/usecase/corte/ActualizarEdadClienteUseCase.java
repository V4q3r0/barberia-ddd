package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarEdadClienteCommand;

public class ActualizarEdadClienteUseCase extends UseCase<RequestCommand<ActualizarEdadClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEdadClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarEdadCliente(command.getEdad());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
