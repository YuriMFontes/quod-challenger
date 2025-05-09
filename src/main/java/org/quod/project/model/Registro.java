package org.quod.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "registros")
public class Registro {

    @Id
    private String id;

    private String tipo; // "facial", "digital", "documento"
    private String nomeArquivo;
    private boolean fraudeDetectada;
    private String motivoFraude;
    private Map<String, String> metadados;
    private LocalDateTime dataRegistro;

    // Construtor vazio para o Spring
    public Registro() {}

    // Construtor completo
    public Registro(String tipo, String nomeArquivo, boolean fraudeDetectada,
                    String motivoFraude, Map<String, String> metadados, LocalDateTime dataRegistro) {
        this.tipo = tipo;
        this.nomeArquivo = nomeArquivo;
        this.fraudeDetectada = fraudeDetectada;
        this.motivoFraude = motivoFraude;
        this.metadados = metadados;
        this.dataRegistro = dataRegistro;
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public boolean isFraudeDetectada() {
        return fraudeDetectada;
    }

    public void setFraudeDetectada(boolean fraudeDetectada) {
        this.fraudeDetectada = fraudeDetectada;
    }

    public String getMotivoFraude() {
        return motivoFraude;
    }

    public void setMotivoFraude(String motivoFraude) {
        this.motivoFraude = motivoFraude;
    }

    public Map<String, String> getMetadados() {
        return metadados;
    }

    public void setMetadados(Map<String, String> metadados) {
        this.metadados = metadados;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
