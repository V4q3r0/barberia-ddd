package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;

public class CaracteristicasProductoActualizado extends DomainEvent {
    private final ProductoId productoId;
    private final NombreC nombreC;
    private final Precio precio;

    public CaracteristicasProductoActualizado(ProductoId productoId, NombreC nombreC, Precio precio){
        super("sofka.aplicado.caracteristicasproductoactualizado");
        this.productoId = productoId;
        this.nombreC = nombreC;
        this.precio = precio;
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
