package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.generic.values.Tipo;

import java.util.Objects;

public class AgregarProductoCommand extends Command {
    private final AplicadoId aplicadoId;
    private final ProductoId productoId;
    private final Marca marca;
    private final Tipo tipo;
    private final Caracteristicas caracteristicas;
    private final Estado estado;

    public AgregarProductoCommand(AplicadoId aplicadoId, ProductoId productoId, Marca marca, Tipo tipo, Caracteristicas caracteristicas, Estado estado) {
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.productoId = Objects.requireNonNull(productoId);
        this.marca = Objects.requireNonNull(marca);
        this.tipo = Objects.requireNonNull(tipo);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
        this.estado = Objects.requireNonNull(estado);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Marca getMarca() {
        return marca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public Estado getEstado() {
        return estado;
    }
}
