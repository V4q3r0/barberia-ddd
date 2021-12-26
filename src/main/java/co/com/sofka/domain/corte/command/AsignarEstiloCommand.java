package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.corte.value.EstiloId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;

import java.util.Objects;

public class AsignarEstiloCommand extends Command {
    private final CorteId corteId;
    private final EstiloId estiloId;
    private final Caracteristicas caracteristicas;

    public AsignarEstiloCommand(CorteId corteId, EstiloId estiloId, Caracteristicas caracteristicas){
        this.corteId = Objects.requireNonNull(corteId);
        this.estiloId = Objects.requireNonNull(estiloId);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public EstiloId getEstiloId() {
        return estiloId;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }
}
