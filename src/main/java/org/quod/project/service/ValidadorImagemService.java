package org.quod.project.service;

import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public class ValidadorImagemService {

    // Validação básica do formato da imagem (base64)
    public boolean validarFormatoImagem(String imagemBase64) {
        try {
            Base64.getDecoder().decode(imagemBase64);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Validação do tamanho da imagem (tamanho mínimo simulado)
    public boolean validarTamanhoImagem(String imagemBase64) {
        return imagemBase64.length() > 1000; // Tamanho mínimo simulado, pode ser ajustado
    }

    // Validação da qualidade da imagem, como resolução e clareza
    public boolean validarQualidadeImagem(String imagemBase64) {
        // Aqui você pode incluir alguma lógica adicional, como análise da resolução da imagem
        // Para simplificar, vamos apenas simular que a qualidade está boa se o tamanho da imagem for maior que 1000
        return imagemBase64.length() > 2000;
    }
}
