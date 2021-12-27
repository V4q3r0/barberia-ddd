package co.com.sofka.domain.generic.datos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Edad implements ValueObject<Integer> {
    private final Integer value;

    public Edad(Integer value){
        if(value <= 0){
            throw new IllegalArgumentException("La edad debe ser mayor a 0.");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
