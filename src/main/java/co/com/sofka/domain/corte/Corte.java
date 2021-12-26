package co.com.sofka.domain.corte;

import co.com.sofka.domain.corte.event.*;
import co.com.sofka.domain.corte.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.*;
import co.com.sofka.domain.generic.datos.*;
import co.com.sofka.domain.generic.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Corte extends AggregateEvent<CorteId> {

    protected Barbero barbero;
    protected Set<Implemento> implementos;
    protected Estilo estilo;
    protected Duracion duracion;
    protected Cliente cliente;

    public Corte(CorteId corteId, Barbero barbero, Cliente cliente, Duracion duracion){
        super(corteId);
        subscribe(new CorteChange(this));
        Objects.requireNonNull(barbero);
        Objects.requireNonNull(cliente);
        Objects.requireNonNull(duracion);
        appendChange(new CorteCreado(barbero, cliente, duracion));
    }

    public Corte(CorteId corteId){
        super(corteId);
        subscribe(new CorteChange(this));
    }

    public void cambiarBarbero(BarberoId barberoId, DatosPersonales datosPersonales){
        Objects.requireNonNull(barberoId);
        Objects.requireNonNull(datosPersonales);
        appendChange(new BarberoCambiado(barberoId, datosPersonales)).apply();
    }

    public void actualizarCaracteristicasEstilo(NombreC nombre, Precio precio){
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(precio);
        appendChange(new CaracteristicasEstiloActualizado(nombre, precio)).apply();
    }

    public void actualizarCaracteristicasImplemento(ImplementoId implementoId, NombreC nombre, Precio precio){
        Objects.requireNonNull(implementoId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(precio);
        appendChange(new CaracteristicasImplementoActualizado(implementoId, nombre, precio)).apply();
    }

    public void cambiarCliente(ClienteId clienteId, DatosPersonales datosPersonales){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(datosPersonales);
        appendChange(new ClienteCambiado(clienteId, datosPersonales)).apply();
    }

    public void actualizarDuracionCorte(Duracion duracion){
        Objects.requireNonNull(duracion);
        appendChange(new DuracionCorteActualizada(duracion)).apply();
    }

    public void actualizarEdadBarbero(Edad edad){
        Objects.requireNonNull(edad);
        appendChange(new EdadBarberoActualizada(edad)).apply();
    }

    public void actualizarEdadCliente(Edad edad){
        Objects.requireNonNull(edad);
        appendChange(new EdadClienteActualizada(edad)).apply();
    }

    public void actualizarEstadoImplementado(ImplementoId implementoId, Estado estado){
        Objects.requireNonNull(implementoId);
        Objects.requireNonNull(estado);
        appendChange(new EstadoImplementoActualizado(implementoId, estado)).apply();
    }

    public void asignarEstilo(EstiloId estiloId, Caracteristicas caracteristicas){
        Objects.requireNonNull(estiloId);
        Objects.requireNonNull(caracteristicas);
        appendChange(new EstiloAsignado(estiloId, caracteristicas)).apply();
    }

    public void agregarImplemento(ImplementoId implementoId, Caracteristicas caracteristicas, Estado estado, Tipo tipo, Marca marca){
        Objects.requireNonNull(implementoId);
        Objects.requireNonNull(caracteristicas);
        Objects.requireNonNull(estado);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(marca);
        appendChange(new ImplementoAgregado(implementoId, caracteristicas, estado, tipo, marca)).apply();
    }

    public void actualizarNombreBarbero(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreBarberoActualizado(nombre)).apply();
    }

    public void actualizarNombreCliente(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreClienteActualizado(nombre)).apply();
    }

    public void actualizarTelefonoBarbero(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoBarberoActualizado(telefono)).apply();
    }

    public void actualizarTelefonoCliente(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoClienteActualizado(telefono)).apply();
    }

    public Optional<Implemento> getImplementoById(ImplementoId implementoId){
        Objects.requireNonNull(implementoId);
        return implementos.stream()
                .filter(implemento ->
                        implemento.identity().equals(implementoId))
                .findFirst();
    }

    public static Corte from(CorteId corteId, List<DomainEvent> events) {
        var corte = new Corte(corteId);
        events.forEach(corte::applyEvent);
        return corte;
    }

    public Barbero barbero() {
        return barbero;
    }

    public Set<Implemento> implementos() {
        return implementos;
    }

    public Estilo estilo() {
        return estilo;
    }

    public Duracion duracion() {
        return duracion;
    }

    public Cliente cliente() {
        return cliente;
    }
}
