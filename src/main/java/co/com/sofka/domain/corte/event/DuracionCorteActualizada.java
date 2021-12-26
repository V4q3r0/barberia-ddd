package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Duracion;

public class DuracionCorteActualizada extends DomainEvent {
    private final Duracion duracion;

    public DuracionCorteActualizada(Duracion duracion){
        super("sofka.corte.duracioncorteactualizada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
