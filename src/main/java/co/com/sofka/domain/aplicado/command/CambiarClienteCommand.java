package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.values.ClienteId;

import java.util.Objects;

public class CambiarClienteCommand extends Command {
    private final AplicadoId aplicadoId;
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;

    public CambiarClienteCommand(AplicadoId aplicadoId, ClienteId clienteId, DatosPersonales datosPersonales) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.clienteId = Objects.requireNonNull(clienteId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
