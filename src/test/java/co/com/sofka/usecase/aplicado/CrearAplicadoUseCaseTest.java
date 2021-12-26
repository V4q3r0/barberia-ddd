package co.com.sofka.usecase.aplicado;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.aplicado.Estilista;
import co.com.sofka.domain.aplicado.command.CrearAplicadoCommand;
import co.com.sofka.domain.aplicado.event.AplicadoCreado;
import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.EstilistaId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.datos.*;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearAplicadoUseCaseTest {

    @Test
    void crearAplicado(){
        //arrange
        AplicadoId aplicadoId = AplicadoId.of("Apli01");
        Estilista estilista = new Estilista(
                EstilistaId.of("Esti01"),
                new DatosPersonales(
                        new Nombre("Jose Gregorio",
                                "Vasquez Lopez"),
                        new Telefono("3146745465"),
                        new Edad(25)
                )
        );
        Cliente cliente = new Cliente(ClienteId.of("Cli01"),
                new DatosPersonales(
                        new Nombre("Enrique", "Iglesias"),
                        new Telefono("1132321"),
                        new Edad(25)
                )
        );
        Duracion duracion = new Duracion("4 hora");
        var command = new CrearAplicadoCommand(aplicadoId, estilista, cliente, duracion);
        var usecase = new CrearAplicadoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        AplicadoCreado event = (AplicadoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Apli01", event.aggregateRootId());
        Assertions.assertEquals("Esti01", event.getEstilista().identity().value());
        Assertions.assertEquals("Cli01", event.getCliente().identity().value());
        Assertions.assertEquals("4 hora", event.getDuracion().value());
    }

    @Test
    void crearAplicado_problemaEdadEstilista(){
        //arrange
        AplicadoId aplicadoId = AplicadoId.of("Apli01");
        Estilista estilista = new Estilista(
                EstilistaId.of("Esti01"),
                new DatosPersonales(
                        new Nombre("Jose Gregorio",
                                "Vasquez Lopez"),
                        new Telefono("3146745465"),
                        new Edad(17)
                )
        );
        Cliente cliente = new Cliente(ClienteId.of("Cli01"),
                new DatosPersonales(
                        new Nombre("Enrique", "Iglesias"),
                        new Telefono("1132321"),
                        new Edad(22)
                )
        );
        Duracion duracion = new Duracion("4 hora");
        var command = new CrearAplicadoCommand(aplicadoId, estilista, cliente, duracion);
        var usecase = new CrearAplicadoUseCase();

        //act
        var message = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        }).getMessage();


        //asserts
        Assertions.assertEquals("Estilista debe tener más de 18 años", message);
    }

    @Test
    void crearAplicado_problemaEdadCliente(){
        //arrange
        AplicadoId aplicadoId = AplicadoId.of("Apli01");
        Estilista estilista = new Estilista(
                EstilistaId.of("Esti01"),
                new DatosPersonales(
                        new Nombre("Jose Gregorio",
                                "Vasquez Lopez"),
                        new Telefono("3146745465"),
                        new Edad(20)
                )
        );
        Cliente cliente = new Cliente(ClienteId.of("Cli01"),
                new DatosPersonales(
                        new Nombre("Enrique", "Iglesias"),
                        new Telefono("1132321"),
                        new Edad(0)
                )
        );
        Duracion duracion = new Duracion("4 hora");
        var command = new CrearAplicadoCommand(aplicadoId, estilista, cliente, duracion);
        var usecase = new CrearAplicadoUseCase();

        //act
        var message = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        }).getMessage();


        //asserts
        Assertions.assertEquals("Ingresa una edad valida para el cliente", message);
    }

}