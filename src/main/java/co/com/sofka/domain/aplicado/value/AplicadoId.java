package co.com.sofka.domain.aplicado.value;

import co.com.sofka.domain.generic.Identity;

public final class AplicadoId extends Identity {

    private AplicadoId(String value){
        super(value);
    }

    public AplicadoId(){}

    public static AplicadoId of(String value){
        return new AplicadoId(value);
    }
}
