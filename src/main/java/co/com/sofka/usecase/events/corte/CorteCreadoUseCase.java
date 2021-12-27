package co.com.sofka.usecase.events.corte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.event.CorteCreado;
import co.com.sofka.domain.corte.value.CorteId;

public class CorteCreadoUseCase extends UseCase<TriggeredEvent<CorteCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CorteCreado> corteCreadoTriggeredEvent) {
        var event = corteCreadoTriggeredEvent.getDomainEvent();
        var corte = new Corte(CorteId.of(event.aggregateRootId()), event.getBarbero(), event.getCliente(), event.getDuracion());

        emit().onResponse(new ResponseEvents(corte.getUncommittedChanges()));
    }
}
