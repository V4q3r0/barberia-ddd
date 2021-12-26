package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class ActualizarEdadAsistenteCommand extends Command {
    private final LavadoId lavadoId;
    private final Edad edad;

    public ActualizarEdadAsistenteCommand(LavadoId lavadoId, Edad edad){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.edad = Objects.requireNonNull(edad);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public Edad getEdad() {
        return edad;
    }
}
