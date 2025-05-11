package org.quod.project.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ValidadorImagemService {

    public boolean validarFormatoImagem(String imagemBase64) {
        try {
            Base64.getDecoder().decode(imagemBase64);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean validarTamanhoImagem(String imagemBase64) {
        return imagemBase64.length() > 1000;
    }

    public boolean validarQualidadeImagem(String imagemBase64) {
        return imagemBase64.length() > 2000;
    }

    public boolean validarImagem(String imagemBase64) {
        return validarFormatoImagem(imagemBase64) &&
                validarTamanhoImagem(imagemBase64) &&
                validarQualidadeImagem(imagemBase64);
    }
}
