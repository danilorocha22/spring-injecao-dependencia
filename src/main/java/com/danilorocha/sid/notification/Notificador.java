package com.danilorocha.sid.notification;

import com.danilorocha.sid.models.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String msg);
}
