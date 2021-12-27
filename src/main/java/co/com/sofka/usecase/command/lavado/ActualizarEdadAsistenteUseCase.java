package co.com.sofka.usecase.command.lavado;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarEdadAsistenteCommand;

public class ActualizarEdadAsistenteUseCase extends UseCase<RequestCommand<ActualizarEdadAsistenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEdadAsistenteCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var lavado = Lavado.from(command.getLavadoId(), retrieveEvents());

        var edadAsistente = command.getEdad();
        if(edadAsistente.value() < 18){
            throw new BusinessException(command.getLavadoId().value(), "Asistente debe tener más de 18 años");
        }

        lavado.actualizarEdadAsistente(command.getEdad());
        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
