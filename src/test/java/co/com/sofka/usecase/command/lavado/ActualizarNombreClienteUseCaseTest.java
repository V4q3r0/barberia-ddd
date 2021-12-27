package co.com.sofka.usecase.command.lavado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.generic.datos.Nombre;
import co.com.sofka.domain.generic.datos.Telefono;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.lavado.Asistente;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarNombreClienteCommand;
import co.com.sofka.domain.lavado.event.LavadoCreado;
import co.com.sofka.domain.lavado.event.NombreClienteActualizado;
import co.com.sofka.domain.lavado.value.AsistenteId;
import co.com.sofka.domain.lavado.value.LavadoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombreCliente(){
        //arrange
        var lavado = getLavado();
        Nombre nombre = new Nombre("Jaime", "Lopez");
        var command = new ActualizarNombreClienteCommand(lavado.identity(), nombre);
        var usecase = new ActualizarNombreClienteUseCase();

        when(repository.getEventsBy(lavado.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(lavado.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        NombreClienteActualizado event = (NombreClienteActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Jaime", event.getNombre().value().nombres());
        Assertions.assertEquals("Lopez", event.getNombre().value().apellidos());
        Mockito.verify(repository).getEventsBy(lavado.identity().value());
    }

    private List<DomainEvent> events() {
        var lavado = getLavado();
        return List.of(new LavadoCreado(
                        lavado.aistente(),
                        lavado.cliente(),
                        lavado.duracion()
                )
        );
    }

    public Lavado getLavado(){
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

        Lavado lavado = new Lavado(lavadoId, asistente, cliente, duracion);
        return lavado;
    }

}