package com.api.br.api_emakers.model.entidades;

import com.api.br.api_emakers.model.dto.request.LivroRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

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
    private Set<Pessoa> emprestimos;

    @Builder
    public Livro(LivroRequestDTO livroRequestDTO){
        this.nome = livroRequestDTO.nome();
        this.autor = livroRequestDTO.autor();
        this.data_lancamento = Date.valueOf(livroRequestDTO.data_lancamento());
    }

    public Livro(){

    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData_lancamento() {
        return data_lancamento.toString();
    }

    public void setData_lancamento(String data_lancamento){
        this.data_lancamento = Date.valueOf(data_lancamento);
    }

    public Set<Pessoa> getEmprestimos(){
        return emprestimos;
    }

    public void setEmprestimos(Set<Pessoa> emprestimos){
        this.emprestimos = emprestimos;
    }
}
