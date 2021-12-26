package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.command.ActualizarCaracteristicasImplementoCommand;
import co.com.sofka.domain.corte.event.CaracteristicasImplementoActualizado;
import co.com.sofka.domain.corte.event.CorteCreado;
import co.com.sofka.domain.corte.event.ImplementoAgregado;
import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.corte.value.ImplementoId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.*;
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
class ActualizarCaracteristicasImplementoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarCaracteristicasImplemento(){
        //arrange
        var corte = getCorte();
        var implementoId = ImplementoId.of("Imple02");
        var nombreC = new NombreC("Shampoo caida");
        var precio = new Precio(55000.0);
        var command = new ActualizarCaracteristicasImplementoCommand(corte.identity(), implementoId, nombreC, precio);
        var usecase = new ActualizarCaracteristicasImplementoUseCase();

        when(repository.getEventsBy(corte.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(corte.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        CaracteristicasImplementoActualizado event = (CaracteristicasImplementoActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Imple02", event.getImplementoId().value());
        Assertions.assertEquals("Shampoo caida", event.getNombre().value());
        Assertions.assertEquals(55000.0, event.getPrecio().value());
    }

    private List<DomainEvent> events() {
        var corte = getCorte();
        return List.of(new CorteCreado(
                    corte.barbero(),
                    corte.cliente(),
                    corte.duracion()
            ), new ImplementoAgregado(
                ImplementoId.of("Imple02"),
                new Caracteristicas(
                        new NombreC("Shampo contra caída del pelo"),
                        new Precio(45000.0)
                ),
                new Estado("Bueno"),
                new Tipo("Liquido"),
                new Marca("head shoulder")
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