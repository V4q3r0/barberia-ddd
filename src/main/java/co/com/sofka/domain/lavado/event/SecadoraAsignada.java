package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.lavado.value.SecadoraId;
import co.com.sofka.domain.lavado.value.Tamanio;

public class SecadoraAsignada extends DomainEvent {
    private final SecadoraId secadoraId;
    private final Marca marca;
    private final Caracteristicas caracteristicas;
    private final Estado estado;
    private final Tamanio tamanio;

    public SecadoraAsignada(SecadoraId secadoraId, Marca marca, Caracteristicas caracteristicas, Estado estado, Tamanio tamanio){
        super("sofka.lavado.secadoraasignada");
        this.secadoraId = secadoraId;
        this.marca = marca;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
        this.tamanio = tamanio;
    }

    public SecadoraId getSecadoraId() {
        return secadoraId;
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
