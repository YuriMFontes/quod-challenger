package org.quod.project.dto;

public class ImagemRequestDTO {
    private String usuarioId;
    private String imagemBase64;
    private String nomeArquivo;
    private String tipoImagem; // Ex: "facial", "digital", "documento"

    // Construtores
    public ImagemRequestDTO() {
    }

    public ImagemRequestDTO(String usuarioId, String imagemBase64, String nomeArquivo, String tipoImagem) {
        this.usuarioId = usuarioId;
        this.imagemBase64 = imagemBase64;
        this.nomeArquivo = nomeArquivo;
        this.tipoImagem = tipoImagem;
    }

    // Getters e Setters
    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getTipoImagem() {
        return tipoImagem;
    }

    public void setTipoImagem(String tipoImagem) {
        this.tipoImagem = tipoImagem;
    }
}
