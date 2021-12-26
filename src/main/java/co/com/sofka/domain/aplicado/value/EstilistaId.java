package co.com.sofka.domain.aplicado.value;

import co.com.sofka.domain.generic.Identity;

public final class EstilistaId extends Identity {

    private EstilistaId(String value){
        super(value);
    }

    public EstilistaId(){}

    public static EstilistaId of(String value){
        return new EstilistaId(value);
    }
}
