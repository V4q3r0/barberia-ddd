package co.com.sofka.usecase.command.aplicado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.aplicado.Aplicado;
import co.com.sofka.domain.aplicado.Estilista;
import co.com.sofka.domain.aplicado.command.ActualizarEdadClienteCommand;
import co.com.sofka.domain.aplicado.event.AplicadoCreado;
import co.com.sofka.domain.aplicado.event.EdadClienteActualizada;
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
class ActualizarEdadClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarEdadCliente(){
        //arrange
        var aplicado = getAplicado();
        Edad edad = new Edad(18);
        var command = new ActualizarEdadClienteCommand(aplicado.identity(), edad);
        var usecase = new ActualizarEdadClienteUseCase();

        when(repository.getEventsBy(aplicado.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(aplicado.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        EdadClienteActualizada event = (EdadClienteActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals(18, event.getEdad().value());
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