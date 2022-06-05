package com.danilorocha.sid.domain.models;

import lombok.Getter;

@Getter
public class Cliente {
    private String nome, email, telefone;
    private boolean ativo;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void ativar() {
        this.ativo = true;
    }

}
