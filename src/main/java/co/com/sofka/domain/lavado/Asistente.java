package co.com.sofka.domain.lavado;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.lavado.value.AsistenteId;

import java.util.Objects;

public class Asistente extends Entity<AsistenteId> {
    private DatosPersonales datosPersonales;

    public Asistente(AsistenteId asistenteId, DatosPersonales datosPersonales){
        super(asistenteId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public void actualizarDatosPersonales(DatosPersonales datosPersonales){
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public DatosPersonales datosPersonales() {
        return datosPersonales;
    }
}
