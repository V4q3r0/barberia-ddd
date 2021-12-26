package co.com.sofka.usecase.aplicado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.Estilista;
import co.com.sofka.domain.aplicado.command.ActualizarCaracteristicasProductoCommand;
import co.com.sofka.domain.aplicado.event.AplicadoCreado;
import co.com.sofka.domain.aplicado.event.CaracteristicasProductoActualizado;
import co.com.sofka.domain.aplicado.event.ProductoAgregado;
import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.EstilistaId;
import co.com.sofka.domain.aplicado.value.ProductoId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.generic.datos.Nombre;
import co.com.sofka.domain.generic.datos.Telefono;
import co.com.sofka.domain.generic.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCaracteristicasProductoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarCaracteristicasProducto(){
        //arrange
        var aplicado = getAplicado();

        ProductoId productoId = ProductoId.of("Pro02");
        NombreC nombreC = new NombreC("Laca");
        Precio precio = new Precio(55000.0);
        var command = new ActualizarCaracteristicasProductoCommand(aplicado.identity(), productoId, nombreC, precio);
        var usecase = new ActualizarCaracteristicasProductoUseCase();

        when(repository.getEventsBy(aplicado.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(aplicado.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        CaracteristicasProductoActualizado event = (CaracteristicasProductoActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Pro02", event.getProductoId().value());
        Assertions.assertEquals("Laca", event.getNombreC().value());
        Assertions.assertEquals(55000.0, event.getPrecio().value());
    }

    private List<DomainEvent> events() {
        var aplicado = getAplicado();
        return List.of(new AplicadoCreado(
                aplicado.estilista(),
                aplicado.cliente(),
                aplicado.duracion()
        ), new ProductoAgregado(
                ProductoId.of("Pro02"),
                new Marca("Medishop"),
                new Tipo("Liquido"),
                new Caracteristicas(
                        new NombreC("Minoxidil"),
                        new Precio(60000.0)
                ),
                new Estado("Bueno")
        ));
    }

    public Aplicado getAplicado(){
        AplicadoId aplicadoId = AplicadoId.of("Apli02");
        Estilista estilista = new Estilista(
                EstilistaId.of("Esti02"),
                new DatosPersonales(
                        new Nombre("Jaime", "Gonzales"),
                        new Telefono("132312213"),
                        new Edad(22)
                )
        );
        Cliente cliente = new Cliente(
                ClienteId.of("Clien02"),
                new DatosPersonales(
                        new Nombre("Felipe", "Pardo"),
                        new Telefono("123213321"),
                        new Edad(16)
                )
        );
        Duracion duracion = new Duracion("3 horas");

        Aplicado aplicado = new Aplicado(aplicadoId, estilista, cliente, duracion);

        return aplicado;
    }
}