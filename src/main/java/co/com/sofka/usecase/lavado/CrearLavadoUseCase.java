package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.CrearLavadoCommand;

public class CrearLavadoUseCase extends UseCase<RequestCommand<CrearLavadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearLavadoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = new Lavado(command.getLavadoId(), command.getAsistente(), command.getCliente(), command.getDuracion());

        var edadAsistente = command.getAsistente().datosPersonales().value().edad();
        var edadCliente = command.getCliente().datosPersonales().value().edad();
        if(edadAsistente.value() < 18){
            throw new BusinessException(command.getLavadoId().value(), "La edad del asistente debe ser mayor a 18");
        }
        if(edadCliente.value() <= 0){
            throw new BusinessException(command.getLavadoId().value(), "La edad del cliente debe ser mayor a 0");
        }

        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
