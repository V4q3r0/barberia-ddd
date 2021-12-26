package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Duracion;

public class CorteCreado extends DomainEvent {
    private final Barbero barbero;
    private final Cliente cliente;
    private final Duracion duracion;

    public CorteCreado(Barbero barbero, Cliente cliente, Duracion duracion){
        super("sofka.corte.cortecreado");
        this.barbero = barbero;
        this.cliente = cliente;
        this.duracion = duracion;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
