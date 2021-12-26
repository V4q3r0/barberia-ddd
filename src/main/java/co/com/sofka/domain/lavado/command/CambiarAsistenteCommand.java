package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.lavado.value.AsistenteId;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class CambiarAsistenteCommand extends Command {
    private final LavadoId lavadoId;
    private final AsistenteId asistenteId;
    private final DatosPersonales datosPersonales;

    public CambiarAsistenteCommand(LavadoId lavadoId, AsistenteId asistenteId, DatosPersonales datosPersonales){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.asistenteId = Objects.requireNonNull(asistenteId);
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public AsistenteId getAsistenteId() {
        return asistenteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
