package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Nombre;

import java.util.Objects;

public class ActualizarNombreClienteCommand extends Command {
    private final CorteId corteId;
    private final Nombre nombre;

    public ActualizarNombreClienteCommand(CorteId corteId, Nombre nombre){
        this.corteId = Objects.requireNonNull(corteId);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
