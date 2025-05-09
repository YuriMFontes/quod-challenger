package org.quod.project.dto;

public class ValidacaoResponseDTO {
    private String usuarioId;
    private boolean valido;
    private boolean fraudeDetectada;
    private String tipoBiometria; // "facial", "digital", "documento"
    private String mensagem;

    // Construtores
    public ValidacaoResponseDTO() {
    }

    public ValidacaoResponseDTO(String usuarioId, boolean valido, boolean fraudeDetectada, String tipoBiometria, String mensagem) {
        this.usuarioId = usuarioId;
        this.valido = valido;
        this.fraudeDetectada = fraudeDetectada;
        this.tipoBiometria = tipoBiometria;
        this.mensagem = mensagem;
    }

    // Getters e Setters
    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean isFraudeDetectada() {
        return fraudeDetectada;
    }

    public void setFraudeDetectada(boolean fraudeDetectada) {
        this.fraudeDetectada = fraudeDetectada;
    }

    public String getTipoBiometria() {
        return tipoBiometria;
    }

    public void setTipoBiometria(String tipoBiometria) {
        this.tipoBiometria = tipoBiometria;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
