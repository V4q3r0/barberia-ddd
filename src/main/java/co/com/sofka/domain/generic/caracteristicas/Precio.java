package co.com.sofka.domain.generic.caracteristicas;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Precio implements ValueObject<Double> {
    private  final Double value;

    public Precio(Double value){
        this.value = Objects.requireNonNull(value);
    }


    @Override
    public Double value() {
        return value;
    }
}
