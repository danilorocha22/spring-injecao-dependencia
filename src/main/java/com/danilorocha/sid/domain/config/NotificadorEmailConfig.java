package com.danilorocha.sid.domain.config;

import com.danilorocha.sid.domain.notification.NivelUrgencia;
import com.danilorocha.sid.domain.notification.NotificadorEmail;
import com.danilorocha.sid.domain.notification.NotificadorProperties;
import com.danilorocha.sid.domain.notification.TipoDeNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration /*esta anotação também é um componente Spring, mas com objetivo
 claro de definir beans*/
public class NotificadorEmailConfig {

    /*
    @Value faz a injeção de um valor usando expression do Spring para fazer a ligação dos
    atributos com as propriedades customizadas definidas no arquivo application.properties.
    Quando o projeto possui muitas propriedades customizadas o ideal é criar uma classe para
    agrupar todas elas.
     */
   /* @Value("${notificador.email.host-servidor}")
    private String host;

    @Value("${notificador.email.porta-servidor}")
    private Integer porta;*/

    /*
    Ao invés de definir os valores com @Value diretamente nos atributos, conforme feito acima
    faz a injeção do objeto da classe NotificadorProperties
     */
    @Autowired
    private NotificadorProperties properties;

    //@Qualifier("Email") define que este Bean tem prioridade, pode ser usado aqui ou no atributo
    @Primary
    @TipoDeNotificador(NivelUrgencia.URGENTE)
    @Bean /*esta anotação indica que o método é responsável por instanciar e
    configurar um novo objeto que será gerenciado pelo container do Spring*/
    public NotificadorEmail notificadorEmail() {
        //Checando se as propriedades customizadas estão funcionando
        System.out.println("Host: "+ this.properties.getHostServidor());
        System.out.println("Porta: "+ this.properties.getPortaServidor());

        NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.googleemail.com");
        notificadorEmail.setCaixaAlta(false);
        return notificadorEmail;
    }
}
