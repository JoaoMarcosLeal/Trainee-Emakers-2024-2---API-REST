package com.api.br.api_emakers.exceptions;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){super("Pessoa não encontrada");}

    public UserNotFoundException(String message ){super(message);}
}
