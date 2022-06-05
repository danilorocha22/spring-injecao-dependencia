package com.danilorocha.sid.domain.notification;

import com.danilorocha.sid.domain.models.Cliente;

//@Component //esta anotação foi comentada pq foi criada a classe de configuração SidConfig
//que vai gerenciar o bean desta classe
public class NotificadorEmail implements Notificador {

    private boolean caixaAlta;
    private String hostServidorSmtp;

    public NotificadorEmail(String hostServidorSmtp) {
        this.hostServidorSmtp = hostServidorSmtp;
    }

    @Override
    public void notificar(Cliente cliente, String msg) {
        if (this.caixaAlta)
            msg = msg.toUpperCase();

        System.out.printf("Notificando cliente %s, através do email %s, usando servidor SMTP %s: %s%n",
                cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, msg);
    }

    public void setCaixaAlta(boolean caixaAlta) {
        this.caixaAlta = caixaAlta;
    }
}
