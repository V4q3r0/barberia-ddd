package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Estado;

public class EstadoSillaLavadoActualizada extends DomainEvent {
    private final Estado estado;

    public EstadoSillaLavadoActualizada(Estado estado){
        super("sofka.lavado.estadosillalavadoactualizada");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
