package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.DatosPersonales;

import java.util.Objects;

public class CambiarBarberoCommand extends Command {
    private final CorteId corteId;
    private final BarberoId barberoId;
    private final DatosPersonales datosPersonales;

    public CambiarBarberoCommand(CorteId corteId, BarberoId barberoId, DatosPersonales datosPersonales){
        this.corteId = Objects.requireNonNull(corteId);
        this.barberoId = Objects.requireNonNull(barberoId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public CorteId getCorteId() {
        return corteId;
    }

    public BarberoId getBarberoId() {
        return barberoId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
