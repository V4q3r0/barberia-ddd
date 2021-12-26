package co.com.sofka.domain.generic.datos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Nombre implements ValueObject<Nombre.Properties> {
    private final String nombres;
    private final String apellidos;

    public Nombre(String nombres, String apellidos){
        this.nombres = Objects.requireNonNull(nombres, "Nombres requerido");
        this.apellidos = Objects.requireNonNull(apellidos, "Apellidos requeridos");
    }

    @Override
    public Nombre.Properties value() {
        return new Properties() {
            @Override
            public String nombres() {
                return nombres;
            }

            @Override
            public String apellidos() {
                return apellidos;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(nombres, nombre.nombres) && Objects.equals(apellidos, nombre.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombres, apellidos);
    }

    public interface  Properties {
        String nombres();
        String apellidos();
    }
}
