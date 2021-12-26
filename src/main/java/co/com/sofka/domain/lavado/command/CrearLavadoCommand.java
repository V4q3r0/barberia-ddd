package co.com.sofka.domain.lavado.command;

import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.lavado.Asistente;
import co.com.sofka.domain.lavado.value.LavadoId;

import java.util.Objects;

public class CrearLavadoCommand extends Command {
    private final LavadoId lavadoId;
    private final Asistente asistente;
    private final Cliente cliente;
    private final Duracion duracion;

    public CrearLavadoCommand(LavadoId lavadoId, Asistente asistente, Cliente cliente, Duracion duracion){
        this.lavadoId = Objects.requireNonNull(lavadoId);
        this.asistente = Objects.requireNonNull(asistente);
        this.cliente = Objects.requireNonNull(cliente);
        this.duracion = Objects.requireNonNull(duracion);
    }

    public LavadoId getLavadoId() {
        return lavadoId;
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
