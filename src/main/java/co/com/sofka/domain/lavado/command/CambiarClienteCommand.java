package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class CambiarClienteCommand extends Command {
    private final LavadoId lavadoId;
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;

    public CambiarClienteCommand(LavadoId lavadoId, ClienteId clienteId, DatosPersonales datosPersonales){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.clienteId = Objects.requireNonNull(clienteId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
