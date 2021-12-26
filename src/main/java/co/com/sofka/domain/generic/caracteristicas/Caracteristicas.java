package co.com.sofka.domain.generic.caracteristicas;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Caracteristicas implements ValueObject<Caracteristicas.Properties> {
    private final NombreC nombre;
    private final Precio precio;

    public Caracteristicas(NombreC nombre, Precio precio){
        this.nombre = Objects.requireNonNull(nombre);
        this.precio = Objects.requireNonNull(precio);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public NombreC nombre() {
                return nombre;
            }

            @Override
            public Precio precio() {
                return precio;
            }
        };
    }

    public Caracteristicas actualizarCaracteristicas(NombreC nombre, Precio precio){
        return new Caracteristicas(nombre, precio);
    }

    public interface Properties{
        NombreC nombre();
        Precio precio();
    }
}
