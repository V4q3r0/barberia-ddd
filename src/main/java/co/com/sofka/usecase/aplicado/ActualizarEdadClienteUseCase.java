package co.com.sofka.usecase.aplicado;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarEdadClienteCommand;

public class ActualizarEdadClienteUseCase extends UseCase<RequestCommand<ActualizarEdadClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEdadClienteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        var edadCliente = aplicado.cliente().datosPersonales().value().edad();
        if(edadCliente.value() <= 0){
            throw new BusinessException(command.getAplicadoId().value(), "Ingresa una edad valida para el cliente");
        }

        aplicado.actualizarEdadCliente(command.getEdad());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
