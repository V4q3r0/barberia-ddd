package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Telefono;

import java.util.Objects;

public class ActualizarTelefonoClienteCommand extends Command {
    private final AplicadoId aplicadoId;
    private final Telefono telefono;

    public ActualizarTelefonoClienteCommand(AplicadoId aplicadoId, Telefono telefono) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.telefono = Objects.requireNonNull(telefono);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
