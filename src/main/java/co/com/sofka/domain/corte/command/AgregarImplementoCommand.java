package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.corte.value.ImplementoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.generic.values.Tipo;

import java.util.Objects;

public class AgregarImplementoCommand extends Command {

    private final CorteId corteId;
    private final ImplementoId implementoId;
    private final Caracteristicas caracteristicas;
    private final Estado estado;
    private final Tipo tipo;
    private final Marca marca;

    public AgregarImplementoCommand(CorteId corteId, ImplementoId implementoId, Caracteristicas caracteristicas, Estado estado, Tipo tipo, Marca marca){
        this.corteId = Objects.requireNonNull(corteId);
        this.implementoId = Objects.requireNonNull(implementoId);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
        this.estado = Objects.requireNonNull(estado);
        this.tipo = Objects.requireNonNull(tipo);
        this.marca = Objects.requireNonNull(marca);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public Estado getEstado() {
        return estado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Marca getMarca() {
        return marca;
    }
}
