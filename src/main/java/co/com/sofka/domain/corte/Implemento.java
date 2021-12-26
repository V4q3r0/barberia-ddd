package co.com.sofka.domain.corte;

import co.com.sofka.domain.corte.value.ImplementoId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.generic.values.Tipo;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;

import java.util.Objects;

public class Implemento extends Entity<ImplementoId> {
    private Caracteristicas caracteristicas;
    private Estado estado;
    private Tipo tipo;
    private Marca marca;

    public Implemento(ImplementoId implementoId, Caracteristicas caracteristicas, Estado estado, Tipo tipo, Marca marca){
        super(implementoId);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
        this.estado = Objects.requireNonNull(estado);
        this.tipo = Objects.requireNonNull(tipo);
        this.marca = Objects.requireNonNull(marca);
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

    public Caracteristicas caracteristicas() {
        return caracteristicas;
    }

    public Estado estado() {
        return estado;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Marca marca() {
        return marca;
    }
}
