package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.lavado.Asistente;

public class LavadoCreado extends DomainEvent {
    private final Asistente asistente;
    private final Cliente cliente;
    private final Duracion duracion;

    public LavadoCreado(Asistente asistente, Cliente cliente, Duracion duracion){
        super("sotka.lavado.lavadocreado");
        this.asistente = asistente;
        this.cliente = cliente;
        this.duracion = duracion;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
