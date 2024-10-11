package br.com.fiap.alarmes.dto;

import org.modelmapper.ModelMapper;

import br.com.fiap.alarmes.model.Ocorrencia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaUpdateDto {
    private Long id;
    private String prioridade;
    private String localizacao;
    private String descricao;
    private String status;  
    private static final ModelMapper mapper = new ModelMapper();
    
    public Ocorrencia toModel() {
        return  mapper.map(this, Ocorrencia.class);
    }
}
