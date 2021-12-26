package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Duracion;

public class DuracionAplicadoActualizada extends DomainEvent {

    private final Duracion duracion;

    public DuracionAplicadoActualizada(Duracion duracion){
        super("sofka.aplicado.duracionaplicadoactualizada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
