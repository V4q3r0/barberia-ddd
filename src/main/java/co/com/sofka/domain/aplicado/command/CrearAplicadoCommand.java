package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.Estilista;
import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Duracion;

import java.util.Objects;

public class CrearAplicadoCommand extends Command {
    private final AplicadoId aplicadoId;
    private final Estilista estilista;
    private final Cliente cliente;
    private final Duracion duracion;

    public CrearAplicadoCommand(AplicadoId aplicadoId, Estilista estilista, Cliente cliente, Duracion duracion){
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.estilista = Objects.requireNonNull(estilista);
        this.cliente = Objects.requireNonNull(cliente);
        this.duracion = Objects.requireNonNull(duracion);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
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
