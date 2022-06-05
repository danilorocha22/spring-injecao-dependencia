package com.danilorocha.sid.api.controllers;

import com.danilorocha.sid.domain.models.Cliente;
import com.danilorocha.sid.domain.services.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public PrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("Joao", "joao@gmail.com", "6399877-3344");
        ativacaoClienteService.ativar(joao);
        return "Hello";

    }

}
