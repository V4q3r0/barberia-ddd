package co.com.sofka.usecase.events.aplicado;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.aplicado.Estilista;
import co.com.sofka.domain.aplicado.event.AplicadoCreado;
import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.EstilistaId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.datos.*;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AplicadoCreadoUseCaseTest {

    /*@Test
    void aplicadoCreado(){
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
            var event = new AplicadoCreado(estilista, cliente, duracion);
            event.setAggregateRootId(aplicadoId.value());
            var usecase = new AplicadoCreadoUseCase();

            //act
            var events = UseCaseHandler.getInstance()
                    .syncExecutor(usecase, new TriggeredEvent<>(event))
                    .orElseThrow()
                    .getDomainEvents().get(0);

            //asserts
            //Assertions.assertEquals("Iniciado", );

    }*/
}