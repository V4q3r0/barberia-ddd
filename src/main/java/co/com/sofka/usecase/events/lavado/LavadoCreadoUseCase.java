package co.com.sofka.usecase.events.lavado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.event.LavadoCreado;
import co.com.sofka.domain.lavado.value.LavadoId;

public class LavadoCreadoUseCase extends UseCase<TriggeredEvent<LavadoCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<LavadoCreado> lavadoCreadoTriggeredEvent) {
        var event = lavadoCreadoTriggeredEvent.getDomainEvent();
        var lavado = new Lavado(LavadoId.of(event.aggregateRootId()), event.getAsistente(), event.getCliente(), event.getDuracion());

        emit().onResponse(new ResponseEvents(lavado.getUncommittedChanges()));
    }
}
