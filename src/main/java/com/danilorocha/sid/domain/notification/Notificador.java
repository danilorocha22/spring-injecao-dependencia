package com.danilorocha.sid.domain.notification;

import com.danilorocha.sid.domain.models.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String msg);
}
