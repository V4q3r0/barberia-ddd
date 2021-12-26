package co.com.sofka.domain.corte.value;

import co.com.sofka.domain.generic.Identity;

public final class ImplementoId extends Identity {

    private ImplementoId(String value){
        super(value);
    }

    public ImplementoId(){

    }

    public static ImplementoId of(String value){
        return new ImplementoId(value);
    }
}
