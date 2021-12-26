package co.com.sofka.domain.lavado;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.*;
import co.com.sofka.domain.generic.datos.*;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.lavado.event.*;
import co.com.sofka.domain.lavado.value.*;

import java.util.List;
import java.util.Objects;

public class Lavado extends AggregateEvent<LavadoId> {
    protected Asistente asistente;
    protected Secadora secadora;
    protected SillaLavado sillaLavado;
    protected Duracion duracion;
    protected Cliente cliente;

    public Lavado(LavadoId lavadoId, Asistente asistente,  Cliente cliente, Duracion duracion){
        super(lavadoId);
        subscribe(new LavadoChange(this));
        Objects.requireNonNull(asistente);
        Objects.requireNonNull(cliente);
        Objects.requireNonNull(duracion);
        appendChange(new LavadoCreado(asistente, cliente, duracion)).apply();
    }

    public Lavado(LavadoId lavadoId){
        super(lavadoId);
        subscribe(new LavadoChange(this));
    }

    public void cambiarAsistente(AsistenteId asistenteId, DatosPersonales datosPersonales){
        Objects.requireNonNull(asistenteId);
        Objects.requireNonNull(datosPersonales);
        appendChange(new AsistenteCambiado(asistenteId, datosPersonales)).apply();
    }

    public void actualizarCaracteristicasSecadora(NombreC nombreC, Precio precio){
        Objects.requireNonNull(nombreC);
        Objects.requireNonNull(precio);
        appendChange(new CaracteristicasSecadoraActualizada(nombreC, precio)).apply();
    }

    public void actualizarCaracteristicasSillaLavado(NombreC nombreC, Precio precio){
        Objects.requireNonNull(nombreC);
        Objects.requireNonNull(precio);
        appendChange(new CaracteristicasSillaLavadoActualizada(nombreC, precio)).apply();
    }

    public void cambiarCliente(ClienteId clienteId, DatosPersonales datosPersonales){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(datosPersonales);
        appendChange(new ClienteCambiado(clienteId, datosPersonales)).apply();
    }

    public void actualizarDuracionLavado(Duracion duracion){
        Objects.requireNonNull(duracion);
        appendChange(new DuracionLavadoActualizada(duracion)).apply();
    }

    public void actualizarEdadAsistente(Edad edad){
        Objects.requireNonNull(edad);
        appendChange(new EdadAsistenteActualizada(edad)).apply();
    }

    public void actualizarEdadCliente(Edad edad){
        Objects.requireNonNull(edad);
        appendChange(new EdadClienteActualizada(edad)).apply();
    }

    public void actualizarEstadoSecadora(Estado estado){
        Objects.requireNonNull(estado);
        appendChange(new EstadoSecadoraActualizada(estado)).apply();
    }

    public void actualizarEstadoSillaLavado(Estado estado){
        Objects.requireNonNull(estado);
        appendChange(new EstadoSillaLavadoActualizada(estado)).apply();
    }

    public void actualizarNombreAsistente(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreAsistenteActualizado(nombre)).apply();
    }

    public void actualizarNombreCliente(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreClienteActualizado(nombre)).apply();
    }

    public void asignarSecadora(SecadoraId secadoraId, Marca marca, Caracteristicas caracteristicas, Estado estado, Tamanio tamanio){
        Objects.requireNonNull(secadoraId);
        Objects.requireNonNull(marca);
        Objects.requireNonNull(caracteristicas);
        Objects.requireNonNull(estado);
        Objects.requireNonNull(tamanio);
        appendChange(new SecadoraAsignada(secadoraId, marca, caracteristicas, estado, tamanio)).apply();
    }

    public void asignarSillaLavado(SillaLavadoId sillaLavadoId, Marca marca, Caracteristicas caracteristicas, Estado estado, Tamanio tamanio){
        Objects.requireNonNull(sillaLavadoId);
        Objects.requireNonNull(marca);
        Objects.requireNonNull(caracteristicas);
        Objects.requireNonNull(estado);
        Objects.requireNonNull(tamanio);
        appendChange(new SillaLavadoAsignada(sillaLavadoId, marca, caracteristicas, estado, tamanio)).apply();
    }

    public void actualizarTelefonoAsistente(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoAsistenteActualizado(telefono)).apply();
    }

    public void actualizarTelefonoCliente(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoClienteActualizado(telefono)).apply();
    }

    public static Lavado from(LavadoId lavadoId, List<DomainEvent> events) {
        var lavado = new Lavado(lavadoId);
        events.forEach(lavado::applyEvent);
        return lavado;
    }

    public Asistente aistente() {
        return asistente;
    }

    public Secadora secadora() {
        return secadora;
    }

    public SillaLavado sillaLavado() {
        return sillaLavado;
    }

    public Duracion duracion() {
        return duracion;
    }

    public Cliente cliente() {
        return cliente;
    }
}
