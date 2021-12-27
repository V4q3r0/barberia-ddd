package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.command.CambiarEstilistaCommand;

public class CambiarEstilistaUseCase extends UseCase<RequestCommand<CambiarEstilistaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarEstilistaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var aplicado = Aplicado.from(command.getAplicadoId(), retrieveEvents());

        aplicado.cambiarEstilista(command.getEstilistaId(), command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
