package com.danilorocha.sid;

import com.danilorocha.sid.notification.NivelUrgencia;
import com.danilorocha.sid.notification.NotificadorEmail;
import com.danilorocha.sid.notification.TipoDeNotificador;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration /*esta anotação também é um componente Spring, mas com objetivo
 claro de definir beans*/
public class SidConfig {

    //@Qualifier("Email") define que este Bean tem prioridade, pode ser usado aqui ou no atributo
    @TipoDeNotificador(NivelUrgencia.NORMAL)
    @Bean /*esta anotação indica que o método é responsável por instanciar e
    configurar um novo objeto que será gerenciado pelo container do Spring*/
    public NotificadorEmail notificadorEmail() {
        NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.googleemail.com");
        notificadorEmail.setCaixaAlta(false);
        return notificadorEmail;
    }
}
