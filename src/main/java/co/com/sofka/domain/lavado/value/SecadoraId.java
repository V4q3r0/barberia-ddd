package co.com.sofka.domain.lavado.value;

import co.com.sofka.domain.generic.Identity;

public final class SecadoraId extends Identity {
    private SecadoraId(String value){
        super(value);
    }

    public SecadoraId(){}

    public static SecadoraId of(String value){
        return new SecadoraId(value);
    }
}
