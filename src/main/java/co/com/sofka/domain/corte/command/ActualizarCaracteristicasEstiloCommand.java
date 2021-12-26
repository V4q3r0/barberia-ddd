package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;

import java.util.Objects;

public class ActualizarCaracteristicasEstiloCommand extends Command {
    private final CorteId corteId;
    private final NombreC nombreC;
    private final Precio precio;

    public ActualizarCaracteristicasEstiloCommand(CorteId corteId, NombreC nombre, Precio precio){
        this.corteId = Objects.requireNonNull(corteId);
        this.nombreC = Objects.requireNonNull(nombre);
        this.precio = Objects.requireNonNull(precio);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public NombreC getNombreC() {
        return nombreC;
    }

    public Precio getPrecio() {
        return precio;
    }
}
