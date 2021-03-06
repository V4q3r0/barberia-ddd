package co.com.sofka.usecase.command.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarTelefonoAsistenteCommand;

public class ActualizarTelefonoAsistenteUseCase extends UseCase<RequestCommand<ActualizarTelefonoAsistenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoAsistenteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarTelefonoAsistente(command.getTelefono());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
