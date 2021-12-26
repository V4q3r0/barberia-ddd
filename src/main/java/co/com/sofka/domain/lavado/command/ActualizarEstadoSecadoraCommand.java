package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class ActualizarEstadoSecadoraCommand extends Command {
    private final LavadoId lavadoId;
    private final Estado estado;

    public ActualizarEstadoSecadoraCommand(LavadoId lavadoId, Estado estado){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.estado = Objects.requireNonNull(estado);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public Estado getEstado() {
        return estado;
    }
}
