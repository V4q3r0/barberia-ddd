package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Telefono;

public class TelefonoEstilistaActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoEstilistaActualizado(Telefono telefono){
        super("sofka.aplicado.telefonoestilistaactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
