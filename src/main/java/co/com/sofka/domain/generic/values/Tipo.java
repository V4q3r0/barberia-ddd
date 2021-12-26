package co.com.sofka.domain.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Tipo implements ValueObject<String> {
    private final String value;

    public Tipo(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
