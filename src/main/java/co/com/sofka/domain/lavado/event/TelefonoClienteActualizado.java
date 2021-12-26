package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Telefono;

public class TelefonoClienteActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoClienteActualizado(Telefono telefono){
        super("sofka.lavado.telefonoClienteactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
