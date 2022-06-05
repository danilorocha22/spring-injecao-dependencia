package com.danilorocha.sid.domain.services;

import com.danilorocha.sid.domain.events.ClienteAtivadoEvent;
import com.danilorocha.sid.domain.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

//@AllArgsConstructor
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

    /*@TipoDeNotificador(NivelUrgencia.URGENTE) //outra forma de tratar ambiguidade dos Beans
    @Autowired
    private Notificador notificador;*/

    /*
    Métodos init() e destroy() para demostrar o ciclo de vida do bean
     */
    // @PostConstruct //esta anotação foi passada para a classe ServiceConfig
   /* public void init() {
        System.out.println("Iniciou o bean");
    }*/

    // @PreDestroy //esta anotação foi passada para a classe ServiceConfig
    /*public void destroy() {
        System.out.println("Destruiu o bean");
    }*/

    /*
    Não há mais necessidade de usar a interface Notificador, quando se usa ApplicationEventPublisher
     */
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        //diz para o container do Spring que o clienete está ativo
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));

        // this.notificador.notificar(cliente, "Seu cadastro foi atividado!");

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
