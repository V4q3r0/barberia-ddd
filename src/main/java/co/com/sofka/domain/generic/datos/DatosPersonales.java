package co.com.sofka.domain.generic.datos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class DatosPersonales implements ValueObject<DatosPersonales.Properties> {

    private final Nombre nombre;
    private final Telefono telefono;
    private final Edad edad;

    public DatosPersonales(Nombre nombre, Telefono telefono, Edad edad) {
        this.nombre = Objects.requireNonNull(nombre);
        this.telefono = telefono;
        this.edad = edad;
    }

    @Override
    public DatosPersonales.Properties value() {
        return new Properties() {
            @Override
            public Nombre nombre() {
                return nombre;
            }

            @Override
            public Telefono telefono() {
                return telefono;
            }

            @Override
            public Edad edad() {
                return edad;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosPersonales that = (DatosPersonales) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(telefono, that.telefono) && Objects.equals(edad, that.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono, edad);
    }

    public interface Properties {
        Nombre nombre();
        Telefono telefono();
        Edad edad();
    }
}
