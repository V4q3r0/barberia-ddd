package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Edad;

public class EdadBarberoActualizada extends DomainEvent {
    private final Edad edad;

    public EdadBarberoActualizada(Edad edad){
        super("sofka.corte.edadbarberoactualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
