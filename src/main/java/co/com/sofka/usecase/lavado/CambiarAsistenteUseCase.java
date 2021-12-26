package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.CambiarAsistenteCommand;

public class CambiarAsistenteUseCase extends UseCase<RequestCommand<CambiarAsistenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarAsistenteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.cambiarAsistente(command.getAsistenteId(), command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
