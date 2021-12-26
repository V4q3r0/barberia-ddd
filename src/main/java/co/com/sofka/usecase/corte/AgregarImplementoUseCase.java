package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.AgregarImplementoCommand;

public class AgregarImplementoUseCase extends UseCase<RequestCommand<AgregarImplementoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarImplementoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var corte = Corte.from(command.getCorteId(), retrieveEvents());

        corte.agregarImplemento(
                command.getImplementoId(),
                command.getCaracteristicas(),
                command.getEstado(),
                command.getTipo(),
                command.getMarca()
        );
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
