package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Edad;

public class EdadClienteActualizada extends DomainEvent {
    private final Edad edad;

    public EdadClienteActualizada(Edad edad){
        super("sofka.aplicado.edadclienteactualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
