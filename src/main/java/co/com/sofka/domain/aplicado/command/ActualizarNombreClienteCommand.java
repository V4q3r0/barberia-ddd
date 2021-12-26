package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Nombre;

import java.util.Objects;

public class ActualizarNombreClienteCommand extends Command {
    private final AplicadoId aplicadoId;
    private final Nombre nombre;

    public ActualizarNombreClienteCommand(AplicadoId aplicadoId, Nombre nombre) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
