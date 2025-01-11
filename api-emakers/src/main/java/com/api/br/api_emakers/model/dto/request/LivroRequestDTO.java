package com.api.br.api_emakers.model.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public record LivroRequestDTO(

        @NotBlank(message = "O nome do livro é necessário.")
        String nome,

        @NotBlank(message = "É necessário informar o nome do autor.")
        String autor,

        // Se sobrar tempo: ser mais restrito quanto as datas.
        Date data_lancamento
) {
}
