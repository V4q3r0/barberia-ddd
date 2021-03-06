package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.Estilista;
import co.com.sofka.domain.aplicado.command.ActualizarEdadEstilistaCommand;
import co.com.sofka.domain.aplicado.event.AplicadoCreado;
import co.com.sofka.domain.aplicado.event.EdadEstilistaActualizada;
import co.com.sofka.domain.aplicado.value.AplicadoId;
import co.com.sofka.domain.aplicado.value.EstilistaId;
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
class ActualizarEdadEstilistaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarEdadEstilista(){
        //arrange
        var aplicado = getAplicado();
        Edad edad = new Edad(20);
        var command = new ActualizarEdadEstilistaCommand(aplicado.identity(), edad);
        var usecase = new ActualizarEdadEstilistaUseCase();

        when(repository.getEventsBy(aplicado.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(aplicado.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        EdadEstilistaActualizada event = (EdadEstilistaActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals(20, event.getEdad().value());
        Mockito.verify(repository).getEventsBy(aplicado.identity().value());
    }

    @Test
    void actualizarEdadEstilista_ProblemaEdad(){
        //arrange
        var aplicado = getAplicado();
        Edad edad = new Edad(17);
        var command = new ActualizarEdadEstilistaCommand(aplicado.identity(), edad);
        var usecase = new ActualizarEdadEstilistaUseCase();

        when(repository.getEventsBy(aplicado.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var message = Assertions.assertThrows(BusinessException.class, () ->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(aplicado.identity().value())
                    .syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow();
        }).getMessage();

        //asserts
        Assertions.assertEquals("Estilista debe tener m??s de 18 a??os", message);
        Mockito.verify(repository).getEventsBy(aplicado.identity().value());
    }

    private List<DomainEvent> events() {
        var aplicado = getAplicado();
        return List.of(new AplicadoCreado(
                aplicado.estilista(),
                aplicado.cliente(),
                aplicado.duracion()
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