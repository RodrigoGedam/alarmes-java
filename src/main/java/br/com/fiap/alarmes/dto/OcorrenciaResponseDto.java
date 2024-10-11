package br.com.fiap.alarmes.dto;

import org.modelmapper.ModelMapper;

import br.com.fiap.alarmes.model.Ocorrencia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaResponseDto {
    private Long id;
    private String prioridade;
    private String localizacao;
    private String descricao;
    private String status; 
    private static final ModelMapper mapper = new ModelMapper();
    
    public OcorrenciaResponseDto toDto(Ocorrencia ocorrencia) {
        return  mapper.map(ocorrencia, OcorrenciaResponseDto.class);
    }
}
