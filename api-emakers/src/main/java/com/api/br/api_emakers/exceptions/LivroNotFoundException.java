package com.api.br.api_emakers.exceptions;


public class LivroNotFoundException extends RuntimeException{
    public LivroNotFoundException(){super("Livro não encontrado.");}

    public LivroNotFoundException(String message ){super(message);}
}