package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.DatosPersonales;

public class BarberoCambiado extends DomainEvent {
    private final BarberoId barberoId;
    private final DatosPersonales datosPersonales;

    public BarberoCambiado(BarberoId barberoId, DatosPersonales datosPersonales){
        super("sotfka.corte.barberoasignado");
        this.barberoId = barberoId;
        this.datosPersonales = datosPersonales;
    }

    public BarberoId getBarberoId() {
        return barberoId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
