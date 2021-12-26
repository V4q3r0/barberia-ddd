package co.com.sofka.domain.aplicado.event;

import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.generic.values.Tipo;

public class ProductoAgregado extends DomainEvent {
    private final ProductoId productoId;
    private final Marca marca;
    private final Tipo tipo;
    private final Caracteristicas caracteristicas;
    private final Estado estado;

    public ProductoAgregado(ProductoId productoId, Marca marca, Tipo tipo, Caracteristicas caracteristicas, Estado estado) {
        super("sofka.aplicado.productoagregado");
        this.productoId = productoId;
        this.marca = marca;
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
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
