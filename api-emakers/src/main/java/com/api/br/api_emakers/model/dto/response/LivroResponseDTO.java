package com.api.br.api_emakers.model.dto.response;

import com.api.br.api_emakers.model.entidades.Livro;
import com.api.br.api_emakers.model.entidades.Pessoa;

import java.sql.Date;
import java.util.List;
import java.util.Set;


public record LivroResponseDTO(
        Integer id,

        String nome,

        String autor,

        Date data
) {
    public LivroResponseDTO(Livro livro){
        this(livro.getIdLivro(), livro.getNome(), livro.getAutor(), livro.getData_lancamento());
    }
}
