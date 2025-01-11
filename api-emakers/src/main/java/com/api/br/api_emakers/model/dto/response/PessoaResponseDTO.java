package com.api.br.api_emakers.model.dto.response;

import com.api.br.api_emakers.model.entidades.Pessoa;

import java.util.Set;


public record PessoaResponseDTO(
        Integer idPessoa,

        String nome,

        String cep,

        Set<LivroResponseDTO> emprestimos
) {
    public PessoaResponseDTO(Pessoa pessoa) {
        // Agora chama o construtor principal passando os argumentos
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCep(), pessoa.getLivros());
    }
}
