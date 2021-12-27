package co.com.sofka.usecase.events.aplicado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.event.AplicadoCreado;
import co.com.sofka.domain.aplicado.value.AplicadoId;

public class AplicadoCreadoUseCase extends UseCase<TriggeredEvent<AplicadoCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AplicadoCreado> aplicadoCreadoTriggeredEvent) {
        var event = aplicadoCreadoTriggeredEvent.getDomainEvent();
        var aplicado = new Aplicado(AplicadoId.of(event.aggregateRootId()), event.getEstilista(), event.getCliente(), event.getDuracion());

        emit().onResponse(new ResponseEvents(aplicado.getUncommittedChanges()));
    }
}
