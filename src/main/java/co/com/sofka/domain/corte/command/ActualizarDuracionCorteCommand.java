package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Duracion;

import java.util.Objects;

public class ActualizarDuracionCorteCommand extends Command {
    private final CorteId corteId;
    private final Duracion duracion;

    public ActualizarDuracionCorteCommand(CorteId corteId, Duracion duracion){
        this.corteId = Objects.requireNonNull(corteId);
        this.duracion = Objects.requireNonNull(duracion);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
