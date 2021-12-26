package co.com.sofka.domain.generic.values;

import co.com.sofka.domain.generic.Identity;

public final class ClienteId extends Identity {
    private ClienteId(String value){
        super(value);
    }

    public ClienteId(){

    }

    public static ClienteId of(String value){
        return new ClienteId(value);
    }
}
