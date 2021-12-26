package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Duracion;

public class DuracionLavadoActualizada extends DomainEvent {
    private final Duracion duracion;

    public DuracionLavadoActualizada(Duracion duracion){
        super("sofka.lavado.duracionlavadoactualizada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
