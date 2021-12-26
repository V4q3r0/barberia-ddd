package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarCaracteristicasEstiloCommand;
import co.com.sofka.domain.corte.event.CaracteristicasEstiloActualizado;
import co.com.sofka.domain.corte.event.CorteCreado;
import co.com.sofka.domain.corte.event.EstiloAsignado;
import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.corte.value.EstiloId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;
import co.com.sofka.domain.generic.datos.*;
import co.com.sofka.domain.generic.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ActualizarCaracteristicasEstiloUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarCaracteristicasEstilo(){
        //arrange
        var corte = getCorte();
        var nombre = new NombreC("El siete");
        var precio = new Precio(15000.0);
        var command = new ActualizarCaracteristicasEstiloCommand(corte.identity(), nombre, precio);
        var usecase = new ActualizarCaracteristicasEstiloUseCase();

        when(repository.getEventsBy(corte.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(corte.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        CaracteristicasEstiloActualizado event = (CaracteristicasEstiloActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("El siete", event.getNombre().value());
        Assertions.assertEquals(15000.0, event.getPrecio().value());
    }

    private List<DomainEvent> events() {
        var corte = getCorte();
        return List.of(new CorteCreado(
                corte.barbero(),
                corte.cliente(),
                corte.duracion()
            ), new EstiloAsignado(
                EstiloId.of("Estilo02"),
                new Caracteristicas(
                        new NombreC("Afro"),
                        new Precio(18000.0)
                    )
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