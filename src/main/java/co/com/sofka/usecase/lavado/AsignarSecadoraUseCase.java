package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.AsignarSecadoraCommand;

public class AsignarSecadoraUseCase extends UseCase<RequestCommand<AsignarSecadoraCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarSecadoraCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        lavado.asignarSecadora(command.getSecadoraId(), command.getMarca(), command.getCaracteristicas(), command.getEstado(), command.getTamanio());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
