package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Edad;

import java.util.Objects;

public class ActualizarEdadClienteCommand extends Command {
    private final AplicadoId aplicadoId;
    private final Edad edad;

    public ActualizarEdadClienteCommand(AplicadoId aplicadoId, Edad edad) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.edad = Objects.requireNonNull(edad);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public Edad getEdad() {
        return edad;
    }
}
