package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Estado;

public class EstadoCambiado extends DomainEvent {
    private final Estado estado;

    public EstadoCambiado(Estado estado){
        super("sofka.aplicado.estadocambiado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
