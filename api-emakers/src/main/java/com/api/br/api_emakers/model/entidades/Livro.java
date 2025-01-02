package com.api.br.api_emakers.model.entidades;

import com.api.br.api_emakers.model.dto.request.LivroRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivro;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String autor;

    private Date data_lancamento;

    @ManyToMany(mappedBy = "livros")
    private List<Pessoa> emprestimos;

    @Builder
    public Livro(LivroRequestDTO livroRequestDTO){
        this.nome = livroRequestDTO.nome();
        this.autor = livroRequestDTO.autor();
        this.data_lancamento = livroRequestDTO.data_lancamento();
        this.emprestimos = new ArrayList<>();
    }
}
