package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.values.ClienteId;

import java.util.Objects;

public class CambiarClienteCommand extends Command {
    private final CorteId corteId;
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;

    public CambiarClienteCommand(CorteId corteId, ClienteId clienteId, DatosPersonales datosPersonales){
        this.corteId = Objects.requireNonNull(corteId);
        this.clienteId = Objects.requireNonNull(clienteId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
