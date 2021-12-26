package co.com.sofka.domain.aplicado;

import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.generic.values.Tipo;

import java.util.Objects;

public class Producto extends Entity<ProductoId> {
    private Marca marca;
    private Tipo tipo;
    private Caracteristicas caracteristicas;
    private Estado estado;

    public Producto(ProductoId productoId, Marca marca, Tipo tipo, Caracteristicas caracteristicas, Estado estado){
        super(productoId);
        this.marca = Objects.requireNonNull(marca);
        this.tipo = Objects.requireNonNull(tipo);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
        this.estado = Objects.requireNonNull(estado);
    }

    public Marca marca() {
        return marca;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Caracteristicas caracteristicas() {
        return caracteristicas;
    }

    public Estado estado() {
        return estado;
    }

    public void actualizarCaracteristicas(NombreC nombreC, Precio precio){
        Objects.requireNonNull(nombreC);
        Objects.requireNonNull(precio);
        this.caracteristicas = new Caracteristicas(nombreC, precio);
    }

    public void actualizarEstado(Estado estado){
        Objects.requireNonNull(estado);
        this.estado = estado;
    }
}
