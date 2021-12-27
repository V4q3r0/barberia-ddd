package co.com.sofka.usecase.command.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarNombreAsistenteCommand;

public class ActualizarNombreAsistenteUseCase extends UseCase<RequestCommand<ActualizarNombreAsistenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreAsistenteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarNombreAsistente(command.getNombre());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
