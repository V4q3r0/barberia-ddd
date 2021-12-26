package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.corte.value.ImplementoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Estado;

import java.util.Objects;

public class ActualizarEstadoImplementoCommand extends Command {
    private final CorteId corteId;
    private final ImplementoId implementoId;
    private final Estado estado;

    public ActualizarEstadoImplementoCommand(CorteId corteId, ImplementoId implementoId, Estado estado){
        this.corteId = Objects.requireNonNull(corteId);
        this.implementoId = Objects.requireNonNull(implementoId);
        this.estado = Objects.requireNonNull(estado);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public Estado getEstado() {
        return estado;
    }
}
