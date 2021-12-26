package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Duracion;

import java.util.Objects;

public class ActualizarDuracionAplicadoCommand extends Command {
    private final AplicadoId aplicadoId;
    private final Duracion duracion;

    public ActualizarDuracionAplicadoCommand(AplicadoId aplicadoId, Duracion duracion) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.duracion = Objects.requireNonNull(duracion);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
