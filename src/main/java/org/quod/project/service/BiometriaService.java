package org.quod.project.service;

import org.quod.project.dto.ImagemRequestDTO;
import org.quod.project.dto.ValidacaoResponseDTO;
import org.quod.project.model.ResultadoValidacao;
import org.quod.project.repository.ResultadoValidacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public ValidacaoResponseDTO validarBiometria(ImagemRequestDTO request, String tipoBiometria) {
        boolean imagemValida = validadorImagemService.validarImagem(request.getImagemBase64());

        if (!imagemValida) {
            throw new RuntimeException("Imagem inválida. Verifique a qualidade da captura.");
        }

        boolean valido = true;
        boolean fraudeDetectada = detectorFraudeService.detectarFraude(request.getNomeArquivo(), request.getTipoImagem());

        ValidacaoResponseDTO response = new ValidacaoResponseDTO();
        response.setUsuarioId(request.getUsuarioId());
        response.setValido(valido);
        response.setFraudeDetectada(fraudeDetectada);
        response.setTipoBiometria(tipoBiometria);
        response.setMensagem(fraudeDetectada ? "Fraude detectada" : "Validação bem-sucedida");

        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado.setUsuarioId(request.getUsuarioId());
        resultado.setTipoImagem(request.getTipoImagem());
        resultado.setImagemBase64(request.getImagemBase64());
        resultado.setSucesso(valido);
        resultado.setFraudeDetectada(fraudeDetectada);
        resultado.setTipo(tipoBiometria);
        resultado.setMensagem(response.getMensagem());
        resultado.setData(LocalDateTime.now());

        resultadoValidacaoRepository.save(resultado);

        if (fraudeDetectada) {
            notificacaoService.notificarFraude(response);
        } else {
            notificacaoService.notificarSucesso(response);
        }

        return response;
    }
}
