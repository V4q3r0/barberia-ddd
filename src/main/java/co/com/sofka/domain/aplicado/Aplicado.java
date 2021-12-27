package co.com.sofka.domain.aplicado;

import co.com.sofka.domain.aplicado.event.*;
import co.com.sofka.domain.aplicado.value.*;
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

public class Aplicado extends AggregateEvent<AplicadoId> {

    protected Set<Producto> productos;
    protected Estilista estilista;
    protected Duracion duracion;
    protected Cliente cliente;
    protected Estado estado;

    public Aplicado(AplicadoId aplicadoId, Estilista estilista, Cliente cliente, Duracion duracion){
        super(aplicadoId);
        subscribe(new AplicadoChange(this));
        Objects.requireNonNull(estilista);
        Objects.requireNonNull(cliente);
        Objects.requireNonNull(duracion);
        appendChange(new AplicadoCreado(estilista, cliente, duracion)).apply();
    }

    public Aplicado(AplicadoId aplicadoId){
        super(aplicadoId);
        subscribe(new AplicadoChange(this));
    }

    public void actualizarCaracteristicasProducto(ProductoId productoId, NombreC nombreC, Precio precio){
        Objects.requireNonNull(productoId);
        Objects.requireNonNull(nombreC);
        Objects.requireNonNull(precio);
        appendChange(new CaracteristicasProductoActualizado(productoId, nombreC, precio)).apply();
    }

    public void cambiarCliente(ClienteId clienteId, DatosPersonales datosPersonales){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(datosPersonales);
        appendChange(new ClienteCambiado(clienteId, datosPersonales)).apply();
    }

    public void actualizarDuracionAplicado(Duracion duracion){
        Objects.requireNonNull(duracion);
        appendChange(new DuracionAplicadoActualizada(duracion)).apply();
    }

    public void actualizarEdadCliente(Edad edad){
        Objects.requireNonNull(edad);
        appendChange(new EdadClienteActualizada(edad)).apply();
    }

    public void actualizarEdadEstilista(Edad edad){
        Objects.requireNonNull(edad);
        appendChange(new EdadEstilistaActualizada(edad)).apply();
    }

    public void actualizarEstadoProducto(ProductoId productoId, Estado estado){
        Objects.requireNonNull(productoId);
        Objects.requireNonNull(estado);
        appendChange(new EstadoProductoActualizado(productoId, estado)).apply();
    }

    public void cambiarEstilista(EstilistaId estilistaId, DatosPersonales datosPersonales){
        Objects.requireNonNull(estilistaId);
        Objects.requireNonNull(datosPersonales);
        appendChange(new EstilistaCambiado(estilistaId, datosPersonales)).apply();
    }

    public void actualizarNombreCliente(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreClienteActualizado(nombre)).apply();
    }

    public void actualizarNombreEstilista(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreEstilistaActualizado(nombre)).apply();
    }

    public void agregarProducto(ProductoId productoId, Marca marca, Tipo tipo, Caracteristicas caracteristicas, Estado estado){
        Objects.requireNonNull(productoId);
        Objects.requireNonNull(marca);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(caracteristicas);
        Objects.requireNonNull(estado);
        appendChange(new ProductoAgregado(productoId, marca, tipo, caracteristicas, estado)).apply();
    }

    public void actualizarTelefonoCliente(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoClienteActualizado(telefono)).apply();
    }

    public void actualizarTelefonoEstilista(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoEstilistaActualizado(telefono)).apply();
    }

    public void cambiarEstado(Estado estado){
        Objects.requireNonNull(estado);
        appendChange(new EstadoCambiado(estado)).apply();
    }

    public Optional<Producto> getProductoById(ProductoId productoId){
        return productos.stream().filter(producto -> producto.identity().equals(productoId)).findFirst();
    }

    public static Aplicado from(AplicadoId aplicadoId, List<DomainEvent> events) {
        var aplicado = new Aplicado(aplicadoId);
        events.forEach(aplicado::applyEvent);
        return aplicado;
    }

    public Set<Producto> productos() {
        return productos;
    }

    public Estilista estilista() {
        return estilista;
    }

    public Duracion duracion() {
        return duracion;
    }

    public Cliente cliente() {
        return cliente;
    }
}
