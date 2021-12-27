package co.com.sofka.usecase.events.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.event.AplicadoCreado;
import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.generic.values.Estado;

public class AplicadoCreadoUseCase extends UseCase<TriggeredEvent<AplicadoCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AplicadoCreado> aplicadoCreadoTriggeredEvent) {
        var event = aplicadoCreadoTriggeredEvent.getDomainEvent();
        var aplicado = Aplicado.from(AplicadoId.of(event.aggregateRootId()), retrieveEvents());

        aplicado.cambiarEstado(new Estado("Iniciado"));
        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
