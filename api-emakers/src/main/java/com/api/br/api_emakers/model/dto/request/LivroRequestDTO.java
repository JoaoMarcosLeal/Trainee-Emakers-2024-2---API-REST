package com.api.br.api_emakers.model.dto.request;

import com.api.br.api_emakers.model.entidades.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;


public record LivroRequestDTO(

        @NotBlank(message = "O nome do livro é necessário.")
        String nome,

        @NotBlank(message = "É necessário informar o nome do autor.")
        String autor,

        // Se sobrar tempo: ser mais restrito quanto as datas.
        @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "A data de lançamento do livro deve seguir este formato: YY-MM-DD")
        String data_lancamento

) {
}
