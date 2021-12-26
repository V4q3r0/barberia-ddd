package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Telefono;

public class TelefonoClienteActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoClienteActualizado(Telefono telefono){
        super("sofka.aplicado.telefonoclienteactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
