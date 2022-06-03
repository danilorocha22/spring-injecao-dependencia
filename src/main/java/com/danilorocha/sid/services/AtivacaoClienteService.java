package com.danilorocha.sid.services;

import com.danilorocha.sid.models.Cliente;
import com.danilorocha.sid.notification.NivelUrgencia;
import com.danilorocha.sid.notification.Notificador;
import com.danilorocha.sid.notification.TipoDeNotificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@AllArgsConstructor
@Component
public class AtivacaoClienteService {

    /*
      Formas de resolver o problema de ambiguidades de Beans: @Qualifier, @Primary ou List de Beans.
      @Primary é utilizado na classe que será prioritária
     */
    /* @Qualifier("SMS") //definir aqui e na classe. Também pode ser definido somente aqui, desde que
     o nome qualificado seja identico ao nome do Bean que será gerado */
    /* @Autowired //com (requerid=false) o notificador é opcional para a classe funcionar
    private List<Notificador> notificadores;*/

    @TipoDeNotificador(NivelUrgencia.URGENTE) //outra forma de tratar ambiguidade dos Beans
    private Notificador notificador;

    /*
    Métodos init() e destroy() para demostrar o ciclo de vida do bean
     */
    @PostConstruct
    public void init() {
        System.out.println("Iniciou o bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruiu o bean");
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro foi atividado!");

        //List de Beans usado para desambiguação
        /*for (Notificador notificador : notificadores) {
            notificador.notificar(cliente, "Seu cadastro foi ativado!");
        }*/

        //Exemplo usado com @Autowired(requerid=false)
        /*if (notificador != null)
            this.notificador.notificar(cliente, "Seu cadastro foi ativado!");
        else
            System.out.println("Não existe notificador, mas o cliente foi ativado.");*/
    }

}
