package com.api.br.api_emakers.model.entidades;

import com.api.br.api_emakers.model.dto.request.PessoaRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;

    //TODO revisar relação ManyToMany
    @ManyToMany(mappedBy = "emprestimos")
    @JoinTable(name = "emprestimos")
    private List<Livro> emprestimos;

    @Builder
    public Pessoa(PessoaRequestDTO pessoaRequestDTO){
        this.nome = pessoaRequestDTO.nome();
        this.cep = pessoaRequestDTO.cep();
        this.emprestimos = new ArrayList<>();
    }
}
