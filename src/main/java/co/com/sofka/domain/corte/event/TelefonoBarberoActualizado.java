package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.Telefono;

public class TelefonoBarberoActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoBarberoActualizado(Telefono telefono){
        super("sofka.corte.telefonobarberoactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
