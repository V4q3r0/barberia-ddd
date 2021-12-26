package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.aplicado.Estilista;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Duracion;

public class AplicadoCreado extends DomainEvent {
    private final Estilista estilista;
    private final Cliente cliente;
    private final Duracion duracion;

    public AplicadoCreado(Estilista estilista, Cliente cliente, Duracion duracion){
        super("sofka.aplicado.aplicadocreado");
        this.estilista = estilista;
        this.cliente = cliente;
        this.duracion = duracion;
    }

    public Estilista getEstilista() {
        return estilista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
