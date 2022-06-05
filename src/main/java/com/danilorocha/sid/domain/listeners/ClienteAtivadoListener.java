package com.danilorocha.sid.domain.listeners;

import com.danilorocha.sid.domain.events.ClienteAtivadoEvent;
import com.danilorocha.sid.domain.notification.NivelUrgencia;
import com.danilorocha.sid.domain.notification.Notificador;
import com.danilorocha.sid.domain.notification.TipoDeNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteAtivadoListener {

    @TipoDeNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro está ativado.");
    }
}
