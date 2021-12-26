package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.corte.value.ImplementoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.generic.values.Tipo;

public class ImplementoAgregado extends DomainEvent {
    private final ImplementoId implementoId;
    private final Caracteristicas caracteristicas;
    private final Estado estado;
    private final Tipo tipo;
    private final Marca marca;

    public ImplementoAgregado(ImplementoId implementoId, Caracteristicas caracteristicas, Estado estado, Tipo tipo, Marca marca){
        super("sofka.corte.implementosasignado");
        this.implementoId = implementoId;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
        this.tipo = tipo;
        this.marca = marca;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public Estado getEstado() {
        return estado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Marca getMarca() {
        return marca;
    }
}
