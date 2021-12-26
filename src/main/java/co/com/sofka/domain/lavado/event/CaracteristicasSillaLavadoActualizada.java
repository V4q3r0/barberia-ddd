package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;

public class CaracteristicasSillaLavadoActualizada extends DomainEvent {
    private final NombreC nombreC;
    private final Precio precio;

    public CaracteristicasSillaLavadoActualizada(NombreC nombreC, Precio precio){
        super("sofka.lavado.caracteristicassillalavadoactualizada");
        this.nombreC = nombreC;
        this.precio = precio;
    }

    public NombreC getNombreC() {
        return nombreC;
    }

    public Precio getPrecio() {
        return precio;
    }
}
