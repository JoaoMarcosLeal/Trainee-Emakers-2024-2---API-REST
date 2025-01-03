package com.api.br.api_emakers.model.dto.response;

///import com.api.br.api_emakers.model.entidades.Livro;
import com.api.br.api_emakers.model.entidades.Pessoa;

///import java.util.List;

/// TODO pesquisar como mapear a lista de livros para o DTO
public record PessoaResponseDTO(
        Integer id,

        String nome,

        String cep
) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCep());
    }

}
