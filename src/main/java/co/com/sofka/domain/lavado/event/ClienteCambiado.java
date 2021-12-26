package co.com.sofka.domain.lavado.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.datos.DatosPersonales;
import co.com.sofka.domain.generic.values.ClienteId;

public class ClienteCambiado extends DomainEvent {
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;

    public ClienteCambiado(ClienteId clienteId, DatosPersonales datosPersonales){
        super("sofka.lavado.clientecambiado");
        this.clienteId = clienteId;
        this.datosPersonales = datosPersonales;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
