package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Telefono;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class ActualizarTelefonoClienteCommand extends Command {
    private final LavadoId lavadoId;
    private final Telefono telefono;

    public ActualizarTelefonoClienteCommand(LavadoId lavadoId, Telefono telefono){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.telefono = Objects.requireNonNull(telefono);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
