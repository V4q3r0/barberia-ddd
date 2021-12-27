package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.BusinessException;
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

        var edadBarbero = command.getEdad();
        if(edadBarbero.value() < 18){
            throw new BusinessException(command.getCorteId().value(), "Barbero debe tener más de 18 años");
        }

        corte.actualizarEdadBarbero(command.getEdad());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
