package com.api.br.api_emakers.model.entidades;

import com.api.br.api_emakers.model.dto.request.PessoaRequestDTO;
import com.api.br.api_emakers.model.dto.response.LivroResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

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

    // Set utilizado para previnir que uma pessoa pegue o mesmo livro duas vezes silmultaneamente
    @ManyToMany
    @JoinTable(
            name = "emprestimos",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private Set<Livro> livros = new HashSet<>();

    @Builder
    public Pessoa(PessoaRequestDTO pessoaRequestDTO){
        this.nome = pessoaRequestDTO.nome();
        this.cep = pessoaRequestDTO.cep();
    }

    public Pessoa(){

    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Set<LivroResponseDTO> getLivros(){
        Set<LivroResponseDTO> livroResponseDTOS = new HashSet<>();
        for (Livro livro : livros){
            livroResponseDTOS.add(new LivroResponseDTO(livro));
        }

        return livroResponseDTOS;
    }

    public void setLivros(Set<Livro> livros){
        this.livros = livros;
    }

    public void addEmprestimo(Livro livro){
        this.livros.add(livro);
        livro.addEmprestimo(this);
    }

    public void removerEmprestimo(Livro livro){
        livros.remove(livro);
    }
}
