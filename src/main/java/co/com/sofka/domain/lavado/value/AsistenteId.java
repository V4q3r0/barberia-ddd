package co.com.sofka.domain.lavado.value;

import co.com.sofka.domain.generic.Identity;

public final class AsistenteId extends Identity {
    private AsistenteId(String value){
        super(value);
    }

    public AsistenteId(){}

    public static AsistenteId of(String value){
        return new AsistenteId(value);
    }
}
