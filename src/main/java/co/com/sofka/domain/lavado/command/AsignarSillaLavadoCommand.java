package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.lavado.value.LavadoId;
import co.com.sofka.domain.lavado.value.SillaLavadoId;
import co.com.sofka.domain.lavado.value.Tamanio;

import java.util.Objects;

public class AsignarSillaLavadoCommand extends Command {
    private final LavadoId lavadoId;
    private final SillaLavadoId sillaLavadoId;
    private final Marca marca;
    private final Caracteristicas caracteristicas;
    private final Estado estado;
    private final Tamanio tamanio;

    public AsignarSillaLavadoCommand(LavadoId lavadoId, SillaLavadoId sillaLavadoId, Marca marca, Caracteristicas caracteristicas, Estado estado, Tamanio tamanio){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.sillaLavadoId = Objects.requireNonNull(sillaLavadoId);
        this.marca = Objects.requireNonNull(marca);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
        this.estado = Objects.requireNonNull(estado);
        this.tamanio = Objects.requireNonNull(tamanio);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
    }

    public SillaLavadoId getSillaLavadoId() {
        return sillaLavadoId;
    }

    public Marca getMarca() {
        return marca;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public Estado getEstado() {
        return estado;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }
}
