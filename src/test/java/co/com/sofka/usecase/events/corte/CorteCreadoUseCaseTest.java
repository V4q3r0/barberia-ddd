package co.com.sofka.usecase.events.corte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.corte.command.CrearCorteCommand;
import co.com.sofka.domain.corte.event.CorteCreado;
import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.generic.datos.Nombre;
import co.com.sofka.domain.generic.datos.Telefono;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.usecase.command.corte.CrearCorteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorteCreadoUseCaseTest {

    @Test
    void corteCreado(){
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
        var event = new CorteCreado(barbero, cliente, duracion);
        event.setAggregateRootId(corteId.value());
        var usecase = new CorteCreadoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();

        //asserts
        var datos = (CorteCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Corte01", datos.aggregateRootId());
        Assertions.assertEquals("Bar01", datos.getBarbero().identity().value());
        Assertions.assertEquals("Cliente05", datos.getCliente().identity().value());
        Assertions.assertEquals("2 horas", datos.getDuracion().value());
    }

}