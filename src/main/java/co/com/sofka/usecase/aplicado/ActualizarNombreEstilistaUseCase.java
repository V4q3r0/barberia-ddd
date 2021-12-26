package co.com.sofka.usecase.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.ActualizarNombreEstilistaCommand;

public class ActualizarNombreEstilistaUseCase extends UseCase<RequestCommand<ActualizarNombreEstilistaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreEstilistaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.actualizarNombreEstilista(command.getNombre());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
