package co.com.sofka.domain.corte;

import co.com.sofka.domain.corte.value.EstiloId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;

import java.util.Objects;

public class Estilo extends Entity<EstiloId> {
    private Caracteristicas caracteristicas;

    public Estilo(EstiloId estiloId, Caracteristicas caracteristicas){
        super(estiloId);
        this.caracteristicas = Objects.requireNonNull(caracteristicas);
    }

    public void actualizarCaracteristicas(Caracteristicas caracteristicas){
        this.caracteristicas = caracteristicas;
    }

    public Caracteristicas caracteristicas() {
        return caracteristicas;
    }
}
