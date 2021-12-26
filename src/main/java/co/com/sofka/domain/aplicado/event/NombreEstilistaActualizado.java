package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Nombre;

public class NombreEstilistaActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreEstilistaActualizado(Nombre nombre){
        super("sofka.aplicado.nombreestilistaactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
