package com.example.agenda.Pessoa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.UUID;

import com.example.agenda.Pessoa.model.Pessoa;

public class CadastrarPessoaDto {

    private UUID id = UUID.randomUUID();

    @NotBlank(message = "Nome não pode ficar em branco")
    private String nome;

    @NotBlank(message = "Telefone não pode ficar em branco")
    private String telefone;

    @Min(value = 0, message = "Idade não pode ser menor que 0")
    private Integer idade;

    public CadastrarPessoaDto(UUID id, String nome, String telefone, int idade) {

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Pessoa toPessoa (){
        return new Pessoa(
            this.id,
            this.nome,
            this.telefone,
            this.idade
        );
    }

    public static CadastrarPessoaDto fromPessoa (Pessoa pessoa){
        return new CadastrarPessoaDto(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getIdade());
    }
}