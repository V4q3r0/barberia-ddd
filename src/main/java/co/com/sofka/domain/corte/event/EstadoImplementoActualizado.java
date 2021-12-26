package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.corte.value.ImplementoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Estado;

public class EstadoImplementoActualizado extends DomainEvent {
    private final ImplementoId implementoId;
    private final Estado estado;

    public EstadoImplementoActualizado(ImplementoId implementoId, Estado estado){
        super("sofka.corte.estadoimplementoactualizado");
        this.implementoId = implementoId;
        this.estado = estado;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public Estado getEstado() {
        return estado;
    }
}
