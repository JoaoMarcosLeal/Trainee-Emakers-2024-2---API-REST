package com.api.br.api_emakers.model.dto.response;

import com.api.br.api_emakers.model.entidades.Livro;
import com.api.br.api_emakers.model.entidades.Pessoa;

import java.util.List;


public record PessoaResponseDTO(
        Integer idPessoa,

        String nome,

        String cep,

        List<Livro> livros
) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCep(), pessoa.getLivros());
    }

}
