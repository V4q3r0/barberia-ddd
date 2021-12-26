package co.com.sofka.domain.corte.value;

import co.com.sofka.domain.generic.Identity;

public final class EstiloId extends Identity {

    private EstiloId(String value){
        super(value);
    }

    public EstiloId(){

    }

    public static EstiloId of(String value){
        return new EstiloId(value);
    }
}
