package co.com.sofka.domain.lavado.value;

import co.com.sofka.domain.generic.Identity;

public final class SillaLavadoId extends Identity {
    private SillaLavadoId(String value){
        super(value);
    }

    public SillaLavadoId(){}

    public static SillaLavadoId of(String value){
        return new SillaLavadoId(value);
    }
}
