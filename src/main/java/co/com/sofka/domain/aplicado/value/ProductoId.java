package co.com.sofka.domain.aplicado.value;

import co.com.sofka.domain.generic.Identity;

public final class ProductoId extends Identity {

    private ProductoId(String value){
        super(value);
    }

    public ProductoId(){}

    public static ProductoId of(String value){
        return new ProductoId(value);
    }
}
