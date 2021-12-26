package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarDuracionCorteCommand;

public class ActualizarDuracionCorteUseCase extends UseCase<RequestCommand<ActualizarDuracionCorteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDuracionCorteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.actualizarDuracionCorte(command.getDuracion());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
