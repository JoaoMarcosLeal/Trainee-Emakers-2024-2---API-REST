package com.api.br.api_emakers.model.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @ManyToMany
    @JoinTable(name = "emprestimo")
    private List<Livro> emprestimos;
}
