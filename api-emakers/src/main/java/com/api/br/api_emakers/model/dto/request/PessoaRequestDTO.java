package com.api.br.api_emakers.model.dto.request;

import com.api.br.api_emakers.model.entidades.Livro;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PessoaRequestDTO(

        @NotBlank(message = "Informar nome de usuário.")
        String nome,

        @NotBlank(message = "Informar cep para o usuário.")
        String cep,

        List<Livro> livros
){
}
