package co.com.sofka.domain.aplicado;

import co.com.sofka.domain.aplicado.value.EstilistaId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.datos.DatosPersonales;

import java.util.Objects;

public class Estilista extends Entity<EstilistaId> {
    private DatosPersonales datosPersonales;

    public Estilista(EstilistaId estilistaId, DatosPersonales datosPersonales){
        super(estilistaId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public void actualizarDatosPersonales(DatosPersonales datosPersonales){
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales datosPersonales() {
        return datosPersonales;
    }
}
