package com.example.agenda.Pessoa.model;

import java.util.Objects;
import java.util.UUID;

public class Pessoa {
    
    private UUID id;

    private String nome;

    private String telefone;

    private Integer idade;

    public Pessoa (UUID id, String nome, String telefone, int idade){

        this.id = Objects.isNull(id) ? UUID.randomUUID() : id;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;

    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void atualizar(Pessoa pessoaAtualizada) {
        this.nome = pessoaAtualizada.getNome();
        this.idade = pessoaAtualizada.getIdade();
        this.telefone = pessoaAtualizada.getTelefone();
    }
}
