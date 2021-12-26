package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.generic.values.ClienteId;

public class EdadClienteActualizada extends DomainEvent {
    private final Edad edad;

    public EdadClienteActualizada(Edad edad){
        super("sofka.corte.edadclienteactualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
