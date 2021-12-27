package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarNombreClienteCommand;

public class ActualizarNombreClienteUseCase extends UseCase<RequestCommand<ActualizarNombreClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarNombreCliente(command.getNombre());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
