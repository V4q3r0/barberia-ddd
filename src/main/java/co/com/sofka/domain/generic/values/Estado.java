package co.com.sofka.domain.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Estado implements ValueObject<String> {
    private final String value;

    public Estado(String value){
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
