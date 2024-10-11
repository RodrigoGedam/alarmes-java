package br.com.fiap.alarmes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.alarmes.dto.OcorrenciaCreateDto;
import br.com.fiap.alarmes.dto.OcorrenciaResponseDto;
import br.com.fiap.alarmes.dto.OcorrenciaUpdateDto;
import br.com.fiap.alarmes.model.Ocorrencia;
import br.com.fiap.alarmes.service.OcorrenciaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {
    private final OcorrenciaService ocorrenciaService;
    
    @GetMapping
    public ResponseEntity<List<OcorrenciaResponseDto>> list() {

        List<OcorrenciaResponseDto> responseDtos = ocorrenciaService.list()
            .stream()
            .map(ocorrencia -> new OcorrenciaResponseDto().toDto(ocorrencia))
            .toList();
        return ResponseEntity.ok().body(responseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OcorrenciaResponseDto> findById(@PathVariable Long id) {
        
        OcorrenciaResponseDto responseDto = ocorrenciaService
                .findById(id)
                .map(ocorrencia -> new OcorrenciaResponseDto().toDto(ocorrencia))
                .orElseThrow(() -> new RuntimeException("Erro"));
        
                return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping
    public ResponseEntity<OcorrenciaResponseDto> create(@RequestBody OcorrenciaCreateDto requestDto) {
        Ocorrencia ocorrencia = ocorrenciaService.saveOrUpdate(requestDto.toModel());

        OcorrenciaResponseDto responseDto = new OcorrenciaResponseDto().toDto(ocorrencia);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<OcorrenciaResponseDto> update(@PathVariable Long id, @RequestBody OcorrenciaUpdateDto requestDto) {
        if (! ocorrenciaService.existsById(id)) {
            new RuntimeException("Erro");
        }

        Ocorrencia ocorrencia = ocorrenciaService.saveOrUpdate(requestDto.toModel());

        OcorrenciaResponseDto responseDto = new OcorrenciaResponseDto().toDto(ocorrencia);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        if (!ocorrenciaService.existsById(id)) {
            new RuntimeException("Erro");
        }
        
        ocorrenciaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
