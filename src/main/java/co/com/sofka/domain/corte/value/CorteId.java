package co.com.sofka.domain.corte.value;

import co.com.sofka.domain.generic.Identity;

public final class CorteId extends Identity {

    private CorteId(String value){
        super(value);
    }

    public CorteId(){

    }

    public static CorteId of(String value){
        return new CorteId(value);
    }

}
