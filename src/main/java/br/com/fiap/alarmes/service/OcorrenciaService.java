package br.com.fiap.alarmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.alarmes.model.Ocorrencia;
import br.com.fiap.alarmes.repository.OcorrenciaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OcorrenciaService {
    private final OcorrenciaRepository ocorrenciaRepository;

    public List<Ocorrencia> list() {
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia saveOrUpdate(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }
    
    public void delete(long id) {
        ocorrenciaRepository.deleteById(id);
    }

    public Optional<Ocorrencia> findById(long id) {
        return ocorrenciaRepository.findById(id);
    }
    
    public boolean existsById(long id) {
        return ocorrenciaRepository.existsById(id);
    }
}