package org.quod.project.service;

import org.springframework.stereotype.Service;

@Service
public class DetectorFraudeService {
    public boolean detectarFraude(String nomeArquivo, String tipoImagem) {
        // Simulação simples
        return nomeArquivo.contains("fraude") || tipoImagem.equalsIgnoreCase("suspeita");
    }
}
