package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarNombreBarberoCommand;

public class ActualizarNombreBarberoUseCase extends UseCase<RequestCommand<ActualizarNombreBarberoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreBarberoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarNombreBarbero(command.getNombre());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
