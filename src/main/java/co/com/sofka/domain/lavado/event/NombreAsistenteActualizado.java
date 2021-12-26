package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Nombre;

public class NombreAsistenteActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreAsistenteActualizado(Nombre nombre){
        super("sofka.lavado.nombreasisttenteactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
