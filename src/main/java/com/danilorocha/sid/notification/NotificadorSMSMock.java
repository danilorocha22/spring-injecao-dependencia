package com.danilorocha.sid.notification;

import com.danilorocha.sid.models.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Primary define que este Bean tem prioridade
@Profile("dev") /* esta anotação define o perfil adotado pela aplicação, que
neste caso é de desenvolvimento */
@TipoDeNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMSMock implements Notificador {

    public NotificadorSMSMock() {
        System.out.println("NotificadorSMS MOCK");
    }

    @Override
    public void notificar(Cliente cliente, String msg) {
        System.out.printf("MOCK: Notificação seria enviada para o cliente %s," +
                        " por SMS através do telefone %s: %s%n",
                cliente.getNome(), cliente.getTelefone(), msg);
    }

}
