package co.com.sofka.domain.lavado.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Tamanio implements ValueObject {
    private final String value;

    public Tamanio(String value){
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public Object value() {
        return value;
    }
}
