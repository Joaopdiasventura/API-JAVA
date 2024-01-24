package com.example.agenda.Pessoa.Exception;

public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException(String message){
        super(message);
    }
}
