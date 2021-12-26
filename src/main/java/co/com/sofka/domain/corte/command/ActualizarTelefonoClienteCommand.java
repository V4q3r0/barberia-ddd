package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Telefono;

import java.util.Objects;

public class ActualizarTelefonoClienteCommand extends Command {
    private final CorteId corteId;
    private final Telefono telefono;

    public ActualizarTelefonoClienteCommand(CorteId corteId, Telefono telefono){
        this.corteId = Objects.requireNonNull(corteId);
        this.telefono = Objects.requireNonNull(telefono);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
