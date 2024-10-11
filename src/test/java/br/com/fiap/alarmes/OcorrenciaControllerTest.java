package br.com.fiap.alarmes;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.fiap.alarmes.dto.OcorrenciaCreateDto;
import br.com.fiap.alarmes.model.Ocorrencia;
import br.com.fiap.alarmes.service.OcorrenciaService;

@WebMvcTest
public class OcorrenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OcorrenciaService service;

    private OcorrenciaCreateDto ocorrenciaCreateDto;

    
    @BeforeEach
    public void setup() {
        ocorrenciaCreateDto = new OcorrenciaCreateDto();
        ocorrenciaCreateDto.setDescricao("Nova Ocorrencia");
        ocorrenciaCreateDto.setLocalizacao("ZN");
        ocorrenciaCreateDto.setStatus("Em Andamento");
        ocorrenciaCreateDto.setPrioridade("4");
        }
    
    @DisplayName("test create Ocorrencia")
    @Test
    void testGivenNewOcorrencia_whenCreate_thenSavedOcorrencia() throws Exception{
        
        given(service.saveOrUpdate(any(Ocorrencia.class)))
            .willAnswer((invocation) -> invocation.getArguments()[0]);

        String body = "{\"prioridade\":\"2\", \"localizacao\": \"ZN\", \"descricao\": \"Assalto\", \"status\": \"Em Andamento\"}";
        
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/ocorrencias")
            .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
            .content(body));

        response.andExpect(status().isOk());
    }

    @DisplayName("test fail")
    @Test
    void testGivenNewOcorrencia_whenCreate_thenFail() throws Exception{
        // fail("Um erro acontecerá");
    }
}
