package co.com.sofka.domain.corte.value;

import co.com.sofka.domain.generic.Identity;

public final class BarberoId extends Identity {

    private BarberoId(String value){
        super(value);
    }

    public BarberoId(){

    }

    public static BarberoId of(String value){
        return new BarberoId(value);
    }
}
