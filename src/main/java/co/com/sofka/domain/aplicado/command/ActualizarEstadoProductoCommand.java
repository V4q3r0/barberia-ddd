package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.values.Estado;

import java.util.Objects;

public class ActualizarEstadoProductoCommand extends Command {
    private final AplicadoId aplicadoId;
    private final ProductoId productoId;
    private final Estado estado;

    public ActualizarEstadoProductoCommand(AplicadoId aplicadoId, ProductoId productoId, Estado estado) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.productoId = Objects.requireNonNull(productoId);
        this.estado = Objects.requireNonNull(estado);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Estado getEstado() {
        return estado;
    }
}
