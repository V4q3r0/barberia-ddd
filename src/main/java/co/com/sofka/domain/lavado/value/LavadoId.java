package co.com.sofka.domain.lavado.value;

import co.com.sofka.domain.generic.Identity;

public final class LavadoId extends Identity {


    private LavadoId(String value){
        super(value);
    }

    public LavadoId(){}

    public static LavadoId of(String value){
        return new LavadoId(value);
    }
}
