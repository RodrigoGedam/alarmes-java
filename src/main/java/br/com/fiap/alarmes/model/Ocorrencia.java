package br.com.fiap.alarmes.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ocorrencias")
@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class Ocorrencia extends AbstractEntity<Long> {

	@Column(nullable = false, length = 50)
    private String prioridade;

    @Column(nullable = false, length = 50)
    private String localizacao;

    @Column(nullable = false, length = 50)
    private String descricao;

    @Column(nullable = false, length = 50)
    private String status;
}
