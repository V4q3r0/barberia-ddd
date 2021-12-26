package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.AsignarSillaLavadoCommand;

public class AsignarSillaLavadoUseCase extends UseCase<RequestCommand<AsignarSillaLavadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarSillaLavadoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.asignarSillaLavado(command.getSillaLavadoId(), command.getMarca(), command.getCaracteristicas(), command.getEstado(), command.getTamanio());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
