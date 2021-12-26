package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarEdadBarberoCommand;

public class ActualizarEdadBarberoUseCase extends UseCase<RequestCommand<ActualizarEdadBarberoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEdadBarberoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarEdadBarbero(command.getEdad());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
