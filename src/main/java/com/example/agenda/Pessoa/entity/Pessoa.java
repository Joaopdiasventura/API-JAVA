package com.example.agenda.Pessoa.entity;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    
    @Id
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private Integer idade;

    protected Pessoa (){
        
    }

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
