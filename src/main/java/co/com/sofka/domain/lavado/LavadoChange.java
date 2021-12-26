package co.com.sofka.domain.lavado;

import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.lavado.event.*;

public class LavadoChange extends EventChange {
    public LavadoChange(Lavado lavado){
        apply((LavadoCreado event) -> {
            lavado.asistente = event.getAsistente();
            lavado.cliente = event.getCliente();
            lavado.duracion = event.getDuracion();
        });

        apply((AsistenteCambiado event) -> {
            lavado.asistente = new Asistente(event.getAsistenteId(), event.getDatosPersonales());
        });

        apply((CaracteristicasSecadoraActualizada event) -> {
            lavado.secadora.actualizarCaracteristicas(event.getNombreC(), event.getPrecio());
        });

        apply((CaracteristicasSillaLavadoActualizada event) -> {
            lavado.sillaLavado.actualizarCaracteristicas(event.getNombreC(), event.getPrecio());
        });

        apply((ClienteCambiado event) -> {
            lavado.cliente = new Cliente(event.getClienteId(), event.getDatosPersonales());
        });

        apply((DuracionLavadoActualizada event) -> {
            lavado.duracion = event.getDuracion();
        });

        apply((EdadAsistenteActualizada event) -> {
            var datosPersonales = new DatosPersonales(
                    lavado.asistente.datosPersonales().value().nombre(),
                    lavado.asistente.datosPersonales().value().telefono(),
                    event.getEdad()
            );
            lavado.asistente.actualizarDatosPersonales(datosPersonales);
        });

        apply((EdadClienteActualizada event) -> {
            var datosPersonales = new DatosPersonales(
                    lavado.cliente.datosPersonales().value().nombre(),
                    lavado.cliente.datosPersonales().value().telefono(),
                    event.getEdad()
            );
            lavado.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((EstadoSecadoraActualizada event) -> {
            lavado.secadora.actualizarEstado(event.getEstado());
        });

        apply((EstadoSillaLavadoActualizada event) -> {
            lavado.sillaLavado.actualizarEstado(event.getEstado());
        });

        apply((NombreAsistenteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    event.getNombre(),
                    lavado.asistente.datosPersonales().value().telefono(),
                    lavado.asistente.datosPersonales().value().edad()
            );
            lavado.asistente.actualizarDatosPersonales(datosPersonales);
        });

        apply((NombreClienteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    event.getNombre(),
                    lavado.cliente.datosPersonales().value().telefono(),
                    lavado.cliente.datosPersonales().value().edad()
            );
            lavado.cliente.actualizarDatosPersonales(datosPersonales);
        });

        apply((SecadoraAsignada event) -> {
            lavado.secadora = new Secadora(
                    event.getSecadoraId(),
                    event.getMarca(),
                    event.getCaracteristicas(),
                    event.getEstado(),
                    event.getTamanio()
            );
        });

        apply((SillaLavadoAsignada event) -> {
            lavado.sillaLavado = new SillaLavado(
                    event.getSillaLavadoId(),
                    event.getMarca(),
                    event.getCaracteristicas(),
                    event.getEstado(),
                    event.getTamanio()
            );
        });

        apply((TelefonoAsistenteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    lavado.asistente.datosPersonales().value().nombre(),
                    event.getTelefono(),
                    lavado.asistente.datosPersonales().value().edad()
            );
            lavado.asistente.actualizarDatosPersonales(datosPersonales);
        });

        apply((TelefonoClienteActualizado event) -> {
            var datosPersonales = new DatosPersonales(
                    lavado.cliente.datosPersonales().value().nombre(),
                    event.getTelefono(),
                    lavado.cliente.datosPersonales().value().edad()
            );
            lavado.cliente.actualizarDatosPersonales(datosPersonales);
        });
    }
}
