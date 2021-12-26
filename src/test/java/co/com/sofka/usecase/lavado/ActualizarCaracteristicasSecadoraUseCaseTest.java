package co.com.sofka.usecase.lavado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.corte.Barbero;
import co.com.sofka.domain.corte.Corte;
import co.com.sofka.domain.corte.event.CorteCreado;
import co.com.sofka.domain.corte.event.EstiloAsignado;
import co.com.sofka.domain.corte.value.BarberoId;
import co.com.sofka.domain.corte.value.CorteId;
import co.com.sofka.domain.corte.value.EstiloId;
import co.com.sofka.domain.generic.Cliente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.caracteristicas.Caracteristicas;
import co.com.sofka.domain.generic.caracteristicas.NombreC;
import co.com.sofka.domain.generic.caracteristicas.Precio;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.datos.Edad;
import co.com.sofka.domain.generic.datos.Nombre;
import co.com.sofka.domain.generic.datos.Telefono;
import co.com.sofka.domain.generic.values.ClienteId;
import co.com.sofka.domain.generic.values.Duracion;
import co.com.sofka.domain.generic.values.Estado;
import co.com.sofka.domain.generic.values.Marca;
import co.com.sofka.domain.lavado.Asistente;
import co.com.sofka.domain.lavado.Lavado;
import co.com.sofka.domain.lavado.command.ActualizarCaracteristicasSecadoraCommand;
import co.com.sofka.domain.lavado.event.CaracteristicasSecadoraActualizada;
import co.com.sofka.domain.lavado.event.LavadoCreado;
import co.com.sofka.domain.lavado.event.SecadoraAsignada;
import co.com.sofka.domain.lavado.value.AsistenteId;
import co.com.sofka.domain.lavado.value.LavadoId;
import co.com.sofka.domain.lavado.value.SecadoraId;
import co.com.sofka.domain.lavado.value.Tamanio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCaracteristicasSecadoraUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarCaracteristicasSecadora(){
        //arrange
        var lavado = getLavado();
        NombreC nombreC = new NombreC("Secadora medium 2500");
        Precio precio = new Precio(135000.0);
        var command = new ActualizarCaracteristicasSecadoraCommand(lavado.identity(), nombreC, precio);
        var usecase = new ActualizarCaracteristicasSecadoraUseCase();

        when(repository.getEventsBy(lavado.identity().value())).thenReturn(events());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(lavado.identity().value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        CaracteristicasSecadoraActualizada event = (CaracteristicasSecadoraActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Secadora medium 2500", event.getNombreC().value());
        Assertions.assertEquals(135000.0, event.getPrecio().value());
    }

    private List<DomainEvent> events() {
        var lavado = getLavado();
        return List.of(new LavadoCreado(
                        lavado.aistente(),
                        lavado.cliente(),
                        lavado.duracion()
                ), new SecadoraAsignada(
                    SecadoraId.of("Seca0330"),
                    new Marca("Ejemplo"),
                    new Caracteristicas(
                            new NombreC("Secado master 3000"),
                            new Precio(140000.0)
                    ),
                    new Estado("Buena"),
                    new Tamanio("Mediana")
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