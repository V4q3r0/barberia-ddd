package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.values.Estado;

public class EstadoProductoActualizado extends DomainEvent {
    private final ProductoId productoId;
    private final Estado estado;

    public EstadoProductoActualizado(ProductoId productoId, Estado estado){
        super("sofka.aplicado.estadoproductoactualizado");
        this.productoId = productoId;
        this.estado = estado;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Estado getEstado() {
        return estado;
    }
}
