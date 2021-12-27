package co.com.sofka.usecase.command.lavado;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.datos.*;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.lavado.Asistente;
import co.com.sofka.domain.lavado.command.CrearLavadoCommand;
import co.com.sofka.domain.lavado.event.LavadoCreado;
import co.com.sofka.domain.lavado.value.AsistenteId;
import co.com.sofka.domain.lavado.value.LavadoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearLavadoUseCaseTest {

    @Test
    void crearLavado(){
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
        var command = new CrearLavadoCommand(lavadoId, asistente, cliente, duracion);
        var usecase = new CrearLavadoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        LavadoCreado event = (LavadoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Lavado01", event.aggregateRootId());
        Assertions.assertEquals("Asis02", event.getAsistente().identity().value());
        Assertions.assertEquals("Cliente20", event.getCliente().identity().value());
        Assertions.assertEquals("3 horas", event.getDuracion().value());
    }

    @Test
    void crearLavado_EdadAsistente(){
        //arrange
        LavadoId lavadoId = LavadoId.of("Lavado01");
        Asistente asistente = new Asistente(
                AsistenteId.of("Asis02"),
                new DatosPersonales(
                        new Nombre("Ana Lucia", "Perez Gomez"),
                        new Telefono("213312"),
                        new Edad(17)
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
        var command = new CrearLavadoCommand(lavadoId, asistente, cliente, duracion);
        var usecase = new CrearLavadoUseCase();

        //act
        var message = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        }).getMessage();

        //asserts
        Assertions.assertEquals("La edad del asistente debe ser mayor a 18", message);
    }

}