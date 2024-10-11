package br.com.fiap.alarmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.alarmes.model.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    
}
