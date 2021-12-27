package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarTelefonoEstilistaCommand;

public class ActualizarTelefonoEstilistaUseCase extends UseCase<RequestCommand<ActualizarTelefonoEstilistaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoEstilistaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.actualizarTelefonoEstilista(command.getTelefono());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
