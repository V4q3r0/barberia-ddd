package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.CrearCorteCommand;

public class CrearCorteUseCase extends UseCase<RequestCommand<CrearCorteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCorteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var barberoEdad = command.getBarbero().datosPersonales().value().edad();
        var clienteEdad = command.getCliente().datosPersonales().value().edad();
        if(barberoEdad.value() < 18){
            throw new BusinessException(command.getCorteId().value(), "La edad del barbero debe ser mayor a 18");
        }
        if(clienteEdad.value() <= 0){
            throw new BusinessException(command.getCorteId().value(), "La edad del cliente debe ser mayor a 0");
        }

        var corte = new Corte(command.getCorteId(), command.getBarbero(), command.getCliente(), command.getDuracion());
        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
