package com.alunos.Sala.Model;

import org.springframework.stereotype.Component;

@Component
public class Mensagem {
    private String mensagemGerada;

    public String getMensagemGerada() {
        return mensagemGerada;
    }
    public void setMensagemGerada(String mensagemGerada) {
        this.mensagemGerada = mensagemGerada;
    }
}
