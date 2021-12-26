package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;

public class CaracteristicasSecadoraActualizada extends DomainEvent {
    private final NombreC nombreC;
    private final Precio precio;

    public CaracteristicasSecadoraActualizada(NombreC nombreC, Precio precio){
        super("sofka.lavado.caracteristicassecadoraactualizada");
        this.nombreC = nombreC;
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }

    public NombreC getNombreC() {
        return nombreC;
    }
}
