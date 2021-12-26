package co.com.sofka.domain.lavado;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.caracteristicas.*;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.lavado.value.SillaLavadoId;
import co.com.sofka.domain.lavado.value.Tamanio;

import java.util.Objects;

public class SillaLavado extends Entity<SillaLavadoId> {
    private Marca marca;
    private Caracteristicas caracteristicas;
    private Estado estado;
    private Tamanio tamanio;

    public SillaLavado(SillaLavadoId sillaLavadoId, Marca marca, Caracteristicas caracteristicas, Estado estado, Tamanio tamanio){
        super(sillaLavadoId);
        this.marca = Objects.requireNonNull(marca);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
        this.estado = Objects.requireNonNull(estado);
        this.tamanio = Objects.requireNonNull(tamanio);
    }

    public void actualizarCaracteristicas(NombreC nombreC, Precio precio){
        Objects.requireNonNull(nombreC);
        Objects.requireNonNull(precio);
        this.caracteristicas = new Caracteristicas(nombreC, precio);
    }

    public void actualizarEstado(Estado estado){
        Objects.requireNonNull(estado);
        this.estado = estado;
    }

    public Marca marca() {
        return marca;
    }

    public Caracteristicas caracteristicas() {
        return caracteristicas;
    }

    public Estado estado() {
        return estado;
    }

    public Tamanio tamanio() {
        return tamanio;
    }
}
