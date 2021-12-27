package co.com.sofka.domain.aplicado;

import co.com.sofka.domain.aplicado.event.*;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.generic.datos.DatosPersonales;

import java.util.HashSet;

public class AplicadoChange extends EventChange {
    public AplicadoChange(Aplicado aplicado){
        apply((AplicadoCreado event) -> {
            aplicado.cliente = event.getCliente();
            aplicado.estilista = event.getEstilista();
            aplicado.duracion = event.getDuracion();
            aplicado.productos = new HashSet<>();
        });

        apply((CaracteristicasProductoActualizado event) -> {
            var producto = aplicado.getProductoById(event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el producto"));
            producto.caracteristicas().actualizarCaracteristicas(event.getNombreC(), event.getPrecio());
        });

        apply((ClienteCambiado event) -> {
            aplicado.cliente = new Cliente(event.getClienteId(), event.getDatosPersonales());
        });

        apply((DuracionAplicadoActualizada event) -> {
            aplicado.duracion = event.getDuracion();
        });

        apply((EdadClienteActualizada event) -> {
            var datosPersonales = new DatosPersonales(
                    aplicado.cliente.datosPersonales().value().nombre(),
                    aplicado.cliente.datosPersonales().value().telefono(),
                    event.getEdad()
            );
            aplicado.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((EdadEstilistaActualizada event) -> {
            var datosPersonales = new DatosPersonales(
                    aplicado.cliente.datosPersonales().value().nombre(),
                    aplicado.cliente.datosPersonales().value().telefono(),
                    event.getEdad()
            );
            aplicado.estilista.actualizarDatosPersonales(datosPersonales);
        });

        apply((EstadoProductoActualizado event) -> {
            var producto = aplicado.getProductoById(event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontro el producto"));
            producto.actualizarEstado(event.getEstado());
        });

        apply((EstilistaCambiado event) -> {
            aplicado.estilista = new Estilista(event.getEstilistaId(), event.getDatosPersonales());
        });

        apply((NombreClienteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    event.getNombre(),
                    aplicado.cliente.datosPersonales().value().telefono(),
                    aplicado.cliente.datosPersonales().value().edad()
            );
            aplicado.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((NombreEstilistaActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    event.getNombre(),
                    aplicado.cliente.datosPersonales().value().telefono(),
                    aplicado.cliente.datosPersonales().value().edad()
            );
            aplicado.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((ProductoAgregado event) -> {
            aplicado.productos.add(new Producto(
                    event.getProductoId(),
                    event.getMarca(),
                    event.getTipo(),
                    event.getCaracteristicas(),
                    event.getEstado())
            );
        });

        apply((TelefonoClienteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    aplicado.cliente.datosPersonales().value().nombre(),
                    event.getTelefono(),
                    aplicado.cliente.datosPersonales().value().edad()
            );
            aplicado.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((TelefonoEstilistaActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    aplicado.cliente.datosPersonales().value().nombre(),
                    event.getTelefono(),
                    aplicado.cliente.datosPersonales().value().edad()
            );
            aplicado.estilista.actualizarDatosPersonales(datosPersonales);
        });

        apply((EstadoCambiado event) -> {
            aplicado.estado = event.getEstado();
        });
    }
}
