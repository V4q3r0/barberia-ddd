package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.aplicado.value.EstilistaId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.DatosPersonales;

public class EstilistaCambiado extends DomainEvent {
    private final EstilistaId estilistaId;
    private final DatosPersonales datosPersonales;

    public EstilistaCambiado(EstilistaId estilistaId, DatosPersonales datosPersonales){
        super("sofka.aplicado.estilistacambiado");
        this.estilistaId = estilistaId;
        this.datosPersonales = datosPersonales;
    }

    public EstilistaId getEstilistaId() {
        return estilistaId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
