package org.quod.project.model;

import java.time.LocalDateTime;

public class ResultadoValidacao {

    private boolean sucesso;
    private boolean fraudeDetectada;
    private String tipo;
    private String mensagem;
    private LocalDateTime data;

    public ResultadoValidacao() {}

    public ResultadoValidacao(boolean sucesso, boolean fraudeDetectada, String tipo, String mensagem, LocalDateTime data) {
        this.sucesso = sucesso;
        this.fraudeDetectada = fraudeDetectada;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.data = data;
    }

    // Getters e Setters

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public boolean isFraudeDetectada() {
        return fraudeDetectada;
    }

    public void setFraudeDetectada(boolean fraudeDetectada) {
        this.fraudeDetectada = fraudeDetectada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
