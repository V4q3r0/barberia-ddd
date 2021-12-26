package co.com.sofka.domain.corte;

import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Barbero extends Entity<BarberoId> {
    private DatosPersonales datosPersonales;

    public Barbero(BarberoId barberoId, DatosPersonales datosPersonales){
        super(barberoId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public void actualizarDatosPersonales(DatosPersonales datosPersonales){
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales datosPersonales() {
        return datosPersonales;
    }
}
