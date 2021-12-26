package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Nombre;

public class NombreClienteActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreClienteActualizado(Nombre nombre){
        super("sofka.corte.nombreclienteactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
