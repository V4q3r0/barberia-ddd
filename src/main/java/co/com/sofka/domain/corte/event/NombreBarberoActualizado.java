package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Nombre;

public class NombreBarberoActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreBarberoActualizado(Nombre nombre){
        super("sofka.corte.nombrebarberoactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
