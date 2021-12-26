package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.Nombre;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class ActualizarNombreAsistenteCommand extends Command {
    private final LavadoId lavadoId;
    private final Nombre nombre;

    public ActualizarNombreAsistenteCommand(LavadoId lavadoId, Nombre nombre){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
