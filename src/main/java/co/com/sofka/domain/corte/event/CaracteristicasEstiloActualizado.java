package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;

public class CaracteristicasEstiloActualizado extends DomainEvent {
    private final NombreC nombre;
    private final Precio precio;

    public CaracteristicasEstiloActualizado(NombreC nombre, Precio precio){
        super("sofka.corte.caracteristicasestiloactualizado");
        this.nombre = nombre;
        this.precio = precio;
    }

    public NombreC getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
