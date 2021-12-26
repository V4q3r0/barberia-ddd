package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Edad;

import java.util.Objects;

public class ActualizarEdadBarberoCommand extends Command {
    private final CorteId corteId;
    private final Edad edad;

    public ActualizarEdadBarberoCommand(CorteId corteId, Edad edad){
        this.corteId = Objects.requireNonNull(corteId);
        this.edad = Objects.requireNonNull(edad);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public Edad getEdad() {
        return edad;
    }
}
