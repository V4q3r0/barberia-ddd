package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarCaracteristicasSillaLavadoCommand;

public class ActualizarCaracteristicasSillaLavadoUseCase extends UseCase<RequestCommand<ActualizarCaracteristicasSillaLavadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCaracteristicasSillaLavadoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.actualizarCaracteristicasSillaLavado(command.getNombreC(), command.getPrecio());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
