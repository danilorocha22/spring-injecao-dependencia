package com.danilorocha.sid.domain.config;

import org.springframework.context.annotation.Configuration;

@Configuration /*esta anotação também é um componente Spring, mas com objetivo
 claro de definir beans*/
public class AtivacaoClienteServiceConfig {

    /*@Bean(initMethod = "init", destroyMethod = "destroy")
    public AtivacaoClienteService ativacaoClienteService() {
        return new AtivacaoClienteService();
    }*/
}
