package co.com.sofka.usecase.command.corte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarEdadClienteCommand;
import co.com.sofka.domain.corte.event.CorteCreado;
import co.com.sofka.domain.corte.event.EdadClienteActualizada;
import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.generic.datos.Nombre;
import co.com.sofka.domain.generic.datos.Telefono;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarEdadClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarEdadCliente(){
        //arrange
        var corte = getCorte();
        Edad edad = new Edad(28);
        var command = new ActualizarEdadClienteCommand(corte.identity(), edad);
        var usecase = new ActualizarEdadClienteUseCase();

        when(repository.getEventsBy(corte.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(corte.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        EdadClienteActualizada event = (EdadClienteActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals(28, event.getEdad().value());
        Mockito.verify(repository).getEventsBy(corte.identity().value());
    }

    private List<DomainEvent> events() {
        var corte = getCorte();
        return List.of(new CorteCreado(
                        corte.barbero(),
                        corte.cliente(),
                        corte.duracion()
                )
        );
    }

    public Corte getCorte(){
        var corteId = CorteId.of("Corte05");
        var barbero = new Barbero(
                BarberoId.of("Bar02"),
                new DatosPersonales(
                        new Nombre("Enrique", "Manco Lopez"),
                        new Telefono("312312"),
                        new Edad(30)
                )
        );
        var cliente = new Cliente(
                ClienteId.of("Cliente10"),
                new DatosPersonales(
                        new Nombre("Julian", "Herrera Vergara"),
                        new Telefono("213213123"),
                        new Edad(25)
                )
        );
        var duracion = new Duracion("3 horas");

        Corte corte = new Corte(corteId, barbero, cliente, duracion);

        return corte;
    }
}