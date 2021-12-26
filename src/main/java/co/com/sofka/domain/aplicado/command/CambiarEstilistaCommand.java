package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.EstilistaId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.DatosPersonales;

import java.util.Objects;

public class CambiarEstilistaCommand extends Command {
    private final AplicadoId aplicadoId;
    private final EstilistaId estilistaId;
    private final DatosPersonales datosPersonales;

    public CambiarEstilistaCommand(AplicadoId aplicadoId, EstilistaId estilistaId, DatosPersonales datosPersonales) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.estilistaId = Objects.requireNonNull(estilistaId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public EstilistaId getEstilistaId() {
        return estilistaId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
