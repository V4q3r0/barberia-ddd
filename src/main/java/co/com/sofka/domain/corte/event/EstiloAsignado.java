package co.com.sofka.domain.corte.event;

import co.com.sofka.domain.corte.value.EstiloId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;

public class EstiloAsignado extends DomainEvent {
    private final EstiloId estiloId;
    private final Caracteristicas caracteristicas;

    public EstiloAsignado(EstiloId estiloId, Caracteristicas caracteristicas){
        super("sofka.corte.estiloasignado");
        this.estiloId = estiloId;
        this.caracteristicas = caracteristicas;
    }

    public EstiloId getEstiloId() {
        return estiloId;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }
}
