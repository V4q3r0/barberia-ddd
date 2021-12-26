package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class ActualizarDuracionLavadoCommand extends Command {
    private final LavadoId lavadoId;
    private final Duracion duracion;

    public ActualizarDuracionLavadoCommand(LavadoId lavadoId, Duracion duracion){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.duracion = Objects.requireNonNull(duracion);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
