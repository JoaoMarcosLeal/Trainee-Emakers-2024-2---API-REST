package com.api.br.api_emakers.model.entidades;

import com.api.br.api_emakers.model.dto.request.PessoaRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
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

    @ManyToMany
    @JoinTable(
            name = "emprestimos",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livro> livros;

    @Builder
    public Pessoa(PessoaRequestDTO pessoaRequestDTO){
        this.nome = pessoaRequestDTO.nome();
        this.cep = pessoaRequestDTO.cep();
        this.livros = new ArrayList<>();
    }
}
