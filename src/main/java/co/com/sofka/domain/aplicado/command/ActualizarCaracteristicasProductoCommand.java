package co.com.sofka.domain.aplicado.command;

import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;

import java.util.Objects;

public class ActualizarCaracteristicasProductoCommand extends Command {
    private final AplicadoId aplicadoId;
    private final ProductoId productoId;
    private final NombreC nombreC;
    private final Precio precio;

    public ActualizarCaracteristicasProductoCommand(AplicadoId aplicadoId, ProductoId productoId, NombreC nombreC, Precio precio){
        this.aplicadoId = Objects.requireNonNull(aplicadoId);
        this.productoId = Objects.requireNonNull(productoId);
        this.nombreC = Objects.requireNonNull(nombreC);
        this.precio = Objects.requireNonNull(precio);
    }

    public AplicadoId getAplicadoId() {
        return aplicadoId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public NombreC getNombreC() {
        return nombreC;
    }

    public Precio getPrecio() {
        return precio;
    }
}
