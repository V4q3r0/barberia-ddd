package co.com.sofka.domain.lavado;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.caracteristicas.*;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.lavado.value.SecadoraId;
import co.com.sofka.domain.lavado.value.Tamanio;

import java.util.Objects;

public class Secadora extends Entity<SecadoraId> {
    private Marca marca;
    private Caracteristicas caracteristicas;
    private Estado estado;
    private Tamanio tamanio;

    public Secadora(SecadoraId secadoraId, Marca marca, Caracteristicas caracteristicas, Estado estado, Tamanio tamanio){
        super(secadoraId);
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
