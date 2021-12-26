package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.corte.value.ImplementoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;

public class CaracteristicasImplementoActualizado extends DomainEvent {
    private final ImplementoId implementoId;
    private final NombreC nombre;
    private final Precio precio;

    public CaracteristicasImplementoActualizado(ImplementoId implementoId, NombreC nombre, Precio precio){
        super("sofka.corte.caracteristicasimplementoactualizado");
        this.implementoId = implementoId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public NombreC getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
