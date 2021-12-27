package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarEdadClienteCommand;

public class ActualizarEdadClienteUseCase extends UseCase<RequestCommand<ActualizarEdadClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEdadClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.actualizarEdadCliente(command.getEdad());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
