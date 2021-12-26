package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Edad;

public class EdadEstilistaActualizada extends DomainEvent {
    private final Edad edad;

    public EdadEstilistaActualizada(Edad edad){
        super("sofka.aplicado.edadestilistaactualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
