package com.api.br.api_emakers.model.dto.response;

import com.api.br.api_emakers.model.entidades.Livro;
import com.api.br.api_emakers.model.entidades.Pessoa;

import java.util.List;


public record LivroResponseDTO(
        Integer id,

        String nome,

        String autor,

        String data,

        List<Pessoa> emprestimos
) {
    public LivroResponseDTO(Livro livro){
        this(livro.getIdLivro(), livro.getNome(), livro.getAutor(), livro.getData_lancamento(), livro.getEmprestimos());
    }
}
