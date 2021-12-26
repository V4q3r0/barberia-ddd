package co.com.sofka.usecase.lavado;

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
import co.com.sofka.domain.lavado.command.CambiarAsistenteCommand;
import co.com.sofka.domain.lavado.event.AsistenteCambiado;
import co.com.sofka.domain.lavado.event.LavadoCreado;
import co.com.sofka.domain.lavado.value.AsistenteId;
import co.com.sofka.domain.lavado.value.LavadoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarAsistenteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarAsistente(){
        //Arrange
        var lavado = getLavado();
        AsistenteId asistenteId = AsistenteId.of("Asis01");
        DatosPersonales datosPersonales = new DatosPersonales(
                new Nombre("Cristian", "Valencia"),
                new Telefono("034543"),
                new Edad(32)
        );
        var command = new CambiarAsistenteCommand(lavado.identity(), asistenteId, datosPersonales);
        var usecase = new CambiarAsistenteUseCase();

        when(repository.getEventsBy(lavado.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(lavado.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        AsistenteCambiado event = (AsistenteCambiado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Asis01", event.getAsistenteId().value());
        Assertions.assertEquals("Cristian", event.getDatosPersonales().value().nombre().value().nombres());
        Assertions.assertEquals("Valencia", event.getDatosPersonales().value().nombre().value().apellidos());
        Assertions.assertEquals("034543", event.getDatosPersonales().value().telefono().value());
        Assertions.assertEquals(32, event.getDatosPersonales().value().edad().value());
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