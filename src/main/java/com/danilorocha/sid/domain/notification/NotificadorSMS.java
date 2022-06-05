package com.danilorocha.sid.domain.notification;

import com.danilorocha.sid.domain.models.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Primary define que este Bean tem prioridade
@Profile("prod") /* esta anotação define o perfil adotado pela aplicaçao, que neste
caso é de produção */
@TipoDeNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorSMS implements Notificador {

    public NotificadorSMS() {
        System.out.println("NotificadorSMS Real");
    }

    @Override
    public void notificar(Cliente cliente, String msg) {
        System.out.printf("Notificando cliente %s, por SMS através do telefone %s: %s%n",
                cliente.getNome(), cliente.getTelefone(), msg);
    }

}
