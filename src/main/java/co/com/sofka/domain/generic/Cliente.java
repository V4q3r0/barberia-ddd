package co.com.sofka.domain.generic;

import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.values.ClienteId;

import java.util.Objects;

public class Cliente extends Entity<ClienteId>{
    private DatosPersonales datosPersonales;

    public Cliente(ClienteId clienteId, DatosPersonales datosPersonales){
        super(clienteId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public void actualizarDatosPersonales(DatosPersonales datosPersonales){
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales datosPersonales() {
        return datosPersonales;
    }
}
