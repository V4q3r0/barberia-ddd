package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.lavado.value.AsistenteId;

public class AsistenteCambiado extends DomainEvent {
    private final AsistenteId asistenteId;
    private final DatosPersonales datosPersonales;

    public AsistenteCambiado(AsistenteId asistenteId, DatosPersonales datosPersonales){
        super("sofka.lavado.asistentecambiado");
        this.asistenteId = asistenteId;
        this.datosPersonales = datosPersonales;
    }

    public AsistenteId getAsistenteId() {
        return asistenteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
