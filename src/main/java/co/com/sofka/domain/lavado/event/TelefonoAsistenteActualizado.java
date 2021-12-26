package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Telefono;

public class TelefonoAsistenteActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoAsistenteActualizado(Telefono telefono){
        super("sofka.lavado.telefonoasistenteactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
