package com.danilorocha.sid.domain.listeners;

import com.danilorocha.sid.domain.events.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotaFiscalEmitidaListener {

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        System.out.println("Nota Fiscal emitida para o cliente "+ event.getCliente().getNome());
    }
}
