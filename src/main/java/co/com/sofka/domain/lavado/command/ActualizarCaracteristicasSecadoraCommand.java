package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class ActualizarCaracteristicasSecadoraCommand extends Command {
    private final LavadoId lavadoId;
    private final NombreC nombreC;
    private final Precio precio;

    public ActualizarCaracteristicasSecadoraCommand(LavadoId lavadoId, NombreC nombreC, Precio precio){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.nombreC = Objects.requireNonNull(nombreC);
        this.precio = Objects.requireNonNull(precio);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public NombreC getNombreC() {
        return nombreC;
    }

    public Precio getPrecio() {
        return precio;
    }
}
