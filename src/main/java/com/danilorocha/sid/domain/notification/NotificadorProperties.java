package com.danilorocha.sid.domain.notification;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("notificador.email") /* esta anotação define que a classe representa um
 arquivo de configuração de propriedades */
public class NotificadorProperties {

    /**
     * Host do servidor de e-mail.
     */
    private String hostServidor;

    /**
     * Porta do servidor de e-mail
     */
    private Integer portaServidor = 28; //definindo que a porta padrão é 28

}
