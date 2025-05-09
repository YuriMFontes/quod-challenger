package com.seuprojeto.controller;

import org.quod.project.dto.ImagemRequestDTO;
import org.quod.project.dto.ValidacaoResponseDTO;
import org.quod.project.dto.BiometriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/biometria")
public class BiometriaController {

    @Autowired
    private BiometriaService biometriaService;

    @PostMapping("/facial")
    public ResponseEntity<ValidacaoResponseDTO> validarBiometriaFacial(@RequestBody ImagemRequestDTO request) {
        ValidacaoResponseDTO resultado = biometriaService.validarBiometria(request, "facial");
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/digital")
    public ResponseEntity<ValidacaoResponseDTO> validarBiometriaDigital(@RequestBody ImagemRequestDTO request) {
        ValidacaoResponseDTO resultado = biometriaService.validarBiometria(request, "digital");
        return ResponseEntity.ok(resultado);
    }
}
