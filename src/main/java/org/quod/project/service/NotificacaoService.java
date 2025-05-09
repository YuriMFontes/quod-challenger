package org.quod.project.service;

import org.quod.project.dto.ValidacaoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {

    private final String URL_NOTIFICACAO_FRAUDE = "https://api.quod.com.br/fraude/notificar"; // Exemplo de URL

    // Método para notificar sistema externo em caso de fraude detectada
    public void notificarFraude(ValidacaoResponseDTO response) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForEntity(URL_NOTIFICACAO_FRAUDE, response, String.class);
        } catch (Exception e) {
            System.out.println("Erro ao notificar sistema de fraude: " + e.getMessage());
        }
    }

    // Método para notificar sucesso de validação
    public void notificarSucesso(ValidacaoResponseDTO response) {
        try {
            // Aqui você pode definir uma URL para notificações de sucesso, se necessário
            String URL_SUCESSO = "https://api.quod.com.br/validacao/sucesso"; // Exemplo de URL
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForEntity(URL_SUCESSO, response, String.class);
        } catch (Exception e) {
            System.out.println("Erro ao notificar sucesso: " + e.getMessage());
        }
    }
}
