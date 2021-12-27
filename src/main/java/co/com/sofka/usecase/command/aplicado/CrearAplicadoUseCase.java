package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.CrearAplicadoCommand;

public class CrearAplicadoUseCase extends UseCase<RequestCommand<CrearAplicadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAplicadoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var edadEstilista = command.getEstilista().datosPersonales().value().edad();
        if(edadEstilista.value() < 18){
            throw new BusinessException(command.getAplicadoId().value(), "Estilista debe tener más de 18 años");
        }
        var aplicado = new Aplicado(command.getAplicadoId(), command.getEstilista(), command.getCliente(), command.getDuracion());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
