package co.com.sofka.usecase.events.lavado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.generic.datos.Nombre;
import co.com.sofka.domain.generic.datos.Telefono;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.lavado.Asistente;
import co.com.sofka.domain.lavado.command.CrearLavadoCommand;
import co.com.sofka.domain.lavado.event.LavadoCreado;
import co.com.sofka.domain.lavado.value.AsistenteId;
import co.com.sofka.domain.lavado.value.LavadoId;
import co.com.sofka.usecase.command.lavado.CrearLavadoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LavadoCreadoUseCaseTest {

    @Test
    void lavadoCreado(){
        //arrange
        LavadoId lavadoId = LavadoId.of("Lavado01");
        Asistente asistente = new Asistente(
                AsistenteId.of("Asis02"),
                new DatosPersonales(
                        new Nombre("Ana Lucia", "Perez Gomez"),
                        new Telefono("213312"),
                        new Edad(25)
                )
        );
        Cliente cliente = new Cliente(
                ClienteId.of("Cliente20"),
                new DatosPersonales(
                        new Nombre("Gabriel", "Correa"),
                        new Telefono("1332121"),
                        new Edad(20)
                )
        );
        Duracion duracion = new Duracion("3 horas");
        var event = new LavadoCreado(asistente, cliente, duracion);
        event.setAggregateRootId(lavadoId.value());
        var usecase = new LavadoCreadoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();

        //asserts
        LavadoCreado datos = (LavadoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Lavado01", datos.aggregateRootId());
        Assertions.assertEquals("Asis02", datos.getAsistente().identity().value());
        Assertions.assertEquals("Cliente20", datos.getCliente().identity().value());
        Assertions.assertEquals("3 horas", datos.getDuracion().value());
    }
}