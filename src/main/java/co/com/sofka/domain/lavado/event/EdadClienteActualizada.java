package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Edad;

public class EdadClienteActualizada extends DomainEvent {
    private final Edad edad;

    public EdadClienteActualizada(Edad edad){
        super("sofka.lavado.edadclienteactualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
