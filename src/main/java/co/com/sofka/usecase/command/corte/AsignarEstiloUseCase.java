package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.AsignarEstiloCommand;

public class AsignarEstiloUseCase extends UseCase<RequestCommand<AsignarEstiloCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarEstiloCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.asignarEstilo(command.getEstiloId(), command.getCaracteristicas());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
