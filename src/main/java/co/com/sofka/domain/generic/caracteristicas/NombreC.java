package co.com.sofka.domain.generic.caracteristicas;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class NombreC implements ValueObject<String> {
    private final String value;

    public NombreC(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
