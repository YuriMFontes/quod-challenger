package org.quod.project.service;

import org.quod.project.dto.ImagemRequestDTO;
import org.quod.project.dto.ValidacaoResponseDTO;
import org.quod.project.model.ResultadoValidacao;
import org.quod.project.repository.ResultadoValidacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiometriaService {

    @Autowired
    private ResultadoValidacaoRepository resultadoValidacaoRepository;

    @Autowired
    private DetectorFraudeService detectorFraudeService;

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private ValidadorImagemService validadorImagemService;

    public ValidacaoResponseDTO validarBiometria(ImagemRequestDTO request) {
        // Validação da imagem
        boolean imagemValida = validadorImagemService.validarImagem(request.getImagemBase64());
        if (!imagemValida) {
            throw new RuntimeException("Imagem inválida. Verifique a qualidade da captura.");
        }

        // Simulação de validação da biometria (facial ou digital)
        boolean valido = true;  // Simulação de validação bem-sucedida (deve ser substituído pela validação real)
        boolean fraudeDetectada = detectorFraudeService.detectarFraude(request.getImagemBase64());

        // Resposta da validação
        ValidacaoResponseDTO response = new ValidacaoResponseDTO();
        response.setValido(valido);
        response.setFraudeDetectada(fraudeDetectada);
        response.setMensagem(fraudeDetectada ? "Fraude detectada" : "Validação bem-sucedida");

        // Salvar o resultado da validação no banco de dados
        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado.setUsuarioId(request.getUsuarioId());
        resultado.setTipoImagem(request.getTipoImagem());
        resultado.setValido(valido);
        resultado.setFraudeDetectada(fraudeDetectada);
        resultado.setMensagem(response.getMensagem());
        resultado.setImagemBase64(request.getImagemBase64());

        resultadoValidacaoRepository.save(resultado);

        // Se fraude for detectada, envia notificação
        if (fraudeDetectada) {
            notificacaoService.enviarNotificacaoDeFraude(request.getUsuarioId(), "Fraude detectada na biometria.");
        }

        return response;
    }
}
