package org.quod.project.service;

import org.quod.project.dto.ValidacaoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {
    public void notificarFraude(ValidacaoResponseDTO response) {
        System.out.println("FRAUDE DETECTADA: " + response.getMensagem());
    }

    public void notificarSucesso(ValidacaoResponseDTO response) {
        System.out.println("VALIDAÇÃO OK: " + response.getMensagem());
    }
}
