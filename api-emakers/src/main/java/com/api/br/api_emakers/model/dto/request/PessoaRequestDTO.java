package com.api.br.api_emakers.model.dto.request;

import jakarta.validation.constraints.NotBlank;


public record PessoaRequestDTO(

        @NotBlank(message = "Informar nome de usuário.")
        String nome,

        @NotBlank(message = "Informar cep para o usuário.")
        String cep
) {
}
