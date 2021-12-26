package co.com.sofka.domain.corte;

import co.com.sofka.domain.corte.event.*;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.datos.DatosPersonales;

import java.util.HashSet;

public class CorteChange extends EventChange {

    public CorteChange(Corte corte){
        apply((CorteCreado event) -> {
            corte.barbero = event.getBarbero();
            corte.cliente = event.getCliente();
            corte.duracion = event.getDuracion();
            corte.implementos = new HashSet<>();
        });

        apply((BarberoCambiado event) -> {
            corte.barbero = new Barbero(event.getBarberoId(), event.getDatosPersonales());
        });

        apply((CaracteristicasEstiloActualizado event) -> {
            corte.estilo.actualizarCaracteristicas(new Caracteristicas(event.getNombre(), event.getPrecio()));
        });

        apply((CaracteristicasImplementoActualizado event) -> {
            var implemento = corte.getImplementoById(event.getImplementoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontro el implemento"));
            implemento.actualizarCaracteristicas(event.getNombre(), event.getPrecio());
        });

        apply((ClienteCambiado event) -> {
            corte.cliente = new Cliente(event.getClienteId(), event.getDatosPersonales());
        });

        apply((DuracionCorteActualizada event) -> {
            corte.duracion = event.getDuracion();
        });

        apply((EdadBarberoActualizada event) -> {
            var datosPersonales = new DatosPersonales(
                    corte.barbero.datosPersonales().value().nombre(),
                    corte.barbero.datosPersonales().value().telefono(),
                    event.getEdad()
            );
            corte.barbero.actualizarDatosPersonales(datosPersonales);
        });

        apply((EdadClienteActualizada event) -> {
            var datosPersonales = new DatosPersonales(
                    corte.cliente.datosPersonales().value().nombre(),
                    corte.cliente.datosPersonales().value().telefono(),
                    event.getEdad()
            );
            corte.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((EstadoImplementoActualizado event) -> {
            var implemento = corte.getImplementoById(event.getImplementoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontro el implemento"));
            implemento.actualizarEstado(event.getEstado());
        });

        apply((EstiloAsignado event) -> {
            corte.estilo = new Estilo(event.getEstiloId(), event.getCaracteristicas());
        });

        apply((ImplementoAgregado event) -> {
            corte.implementos.add(new Implemento(
                    event.getImplementoId(),
                    event.getCaracteristicas(),
                    event.getEstado(),
                    event.getTipo(),
                    event.getMarca()
            ));
        });

        apply((NombreBarberoActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    event.getNombre(),
                    corte.barbero.datosPersonales().value().telefono(),
                    corte.barbero.datosPersonales().value().edad()
            );
            corte.barbero.actualizarDatosPersonales(datosPersonales);
        });

        apply((NombreClienteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    event.getNombre(),
                    corte.cliente.datosPersonales().value().telefono(),
                    corte.cliente.datosPersonales().value().edad()
            );
            corte.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((TelefonoBarberoActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    corte.barbero.datosPersonales().value().nombre(),
                    event.getTelefono(),
                    corte.barbero.datosPersonales().value().edad()
            );
            corte.barbero.actualizarDatosPersonales(datosPersonales);
        });

        apply((TelefonoClienteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    corte.cliente.datosPersonales().value().nombre(),
                    event.getTelefono(),
                    corte.cliente.datosPersonales().value().edad()
            );
            corte.cliente.actualizarDatosPersonales(datosPersonales);
        });
    }
}
