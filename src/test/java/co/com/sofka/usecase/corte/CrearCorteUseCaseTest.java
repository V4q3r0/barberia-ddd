package co.com.sofka.usecase.corte;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.corte.command.CrearCorteCommand;
import co.com.sofka.domain.corte.event.CorteCreado;
import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.datos.*;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearCorteUseCaseTest {

    @Test
    void crearCorte(){
        //arrange
        var corteId = CorteId.of("Corte01");
        var barbero = new Barbero(
                BarberoId.of("Bar01"),
                new DatosPersonales(
                        new Nombre("Andres Felipe", "Guzman Vasquez"),
                        new Telefono("12321"),
                        new Edad(30)
                )
        );
        var cliente = new Cliente(
                ClienteId.of("Cliente05"),
                new DatosPersonales(
                        new Nombre("Mario", "Kart"),
                        new Telefono("132312213"),
                        new Edad(25)
                )
        );
        var duracion = new Duracion("2 horas");
        var command = new CrearCorteCommand(corteId, barbero, cliente, duracion);
        var usecase = new CrearCorteUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        CorteCreado event = (CorteCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Corte01", event.aggregateRootId());
        Assertions.assertEquals("Bar01", event.getBarbero().identity().value());
        Assertions.assertEquals("Cliente05", event.getCliente().identity().value());
    }

    @Test
    void crearCorte_ProblemaEdadBarbero(){
        //arrange
        var corteId = CorteId.of("Corte01");
        var barbero = new Barbero(
                BarberoId.of("Bar01"),
                new DatosPersonales(
                        new Nombre("Andres Felipe", "Guzman Vasquez"),
                        new Telefono("12321"),
                        new Edad(17)
                )
        );
        var cliente = new Cliente(
                ClienteId.of("Cliente05"),
                new DatosPersonales(
                        new Nombre("Mario", "Kart"),
                        new Telefono("132312213"),
                        new Edad(25)
                )
        );
        var duracion = new Duracion("2 horas");
        var command = new CrearCorteCommand(corteId, barbero, cliente, duracion);
        var usecase = new CrearCorteUseCase();

        //act
        var message = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        }).getMessage();

        //asserts
        Assertions.assertEquals("La edad del barbero debe ser mayor a 18", message);
    }

    @Test
    void crearCorte_ProblemaEdadCliente(){
        //arrange
        var corteId = CorteId.of("Corte01");
        var barbero = new Barbero(
                BarberoId.of("Bar01"),
                new DatosPersonales(
                        new Nombre("Andres Felipe", "Guzman Vasquez"),
                        new Telefono("12321"),
                        new Edad(30)
                )
        );
        var cliente = new Cliente(
                ClienteId.of("Cliente05"),
                new DatosPersonales(
                        new Nombre("Mario", "Kart"),
                        new Telefono("132312213"),
                        new Edad(-1)
                )
        );
        var duracion = new Duracion("2 horas");
        var command = new CrearCorteCommand(corteId, barbero, cliente, duracion);
        var usecase = new CrearCorteUseCase();

        //act
        var message = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        }).getMessage();

        //asserts
        Assertions.assertEquals("La edad del cliente debe ser mayor a 0", message);
    }
}