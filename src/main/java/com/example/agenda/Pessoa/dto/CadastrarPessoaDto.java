package com.example.agenda.Pessoa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CadastrarPessoaDto {

    private final UUID id = UUID.randomUUID();

    @NotBlank(message = "Nome não pode ficar em branco")
    private String nome;

    @NotBlank(message = "Telefone não pode ficar em branco")
    private String telefone;

    @Min(value = 0, message = "Idade não pode ser menor que 0")
    private Integer idade;

    public CadastrarPessoaDto() {}

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

    public void atualizar(CadastrarPessoaDto atualizarPessoaDto) {
        this.nome = atualizarPessoaDto.getNome();
        this.idade = atualizarPessoaDto.getIdade();
        this.telefone = atualizarPessoaDto.getTelefone();
    }
}