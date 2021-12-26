package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.CambiarBarberoCommand;

public class CambiarBarberoUseCase extends UseCase<RequestCommand<CambiarBarberoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarBarberoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.cambiarBarbero(command.getBarberoId(), command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
