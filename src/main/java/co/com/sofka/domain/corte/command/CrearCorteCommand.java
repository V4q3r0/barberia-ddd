package co.com.sofka.domain.corte.command;

import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Duracion;

import java.util.Objects;

public class CrearCorteCommand extends Command {
    private final CorteId corteId;
    private final Barbero barbero;
    private final Cliente cliente;
    private final Duracion duracion;

    public CrearCorteCommand(CorteId corteId, Barbero barbero, Cliente cliente, Duracion duracion){
        this.corteId = Objects.requireNonNull(corteId);
        this.barbero = Objects.requireNonNull(barbero);
        this.cliente = Objects.requireNonNull(cliente);
        this.duracion = Objects.requireNonNull(duracion);
    }

    public CorteId getCorteId() {
        return corteId;
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
