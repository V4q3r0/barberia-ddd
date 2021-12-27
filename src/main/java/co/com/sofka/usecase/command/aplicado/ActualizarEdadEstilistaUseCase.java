package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarEdadEstilistaCommand;

public class ActualizarEdadEstilistaUseCase extends UseCase<RequestCommand<ActualizarEdadEstilistaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEdadEstilistaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        var edadEstilista = command.getEdad();
        if(edadEstilista.value() < 18){
            throw new BusinessException(command.getAplicadoId().value(), "Estilista debe tener más de 18 años");
        }

        aplicado.actualizarEdadEstilista(command.getEdad());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
