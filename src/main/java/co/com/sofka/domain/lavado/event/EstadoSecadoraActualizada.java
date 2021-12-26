package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Estado;

public class EstadoSecadoraActualizada extends DomainEvent {

    private final Estado estado;

    public EstadoSecadoraActualizada(Estado estado){
        super("sofka.lavado.estadosecadoraactualizada");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
