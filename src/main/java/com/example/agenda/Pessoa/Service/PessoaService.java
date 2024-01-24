package com.example.agenda.Pessoa.Service;

import com.example.agenda.Pessoa.Exception.PessoaNotFoundException;
import com.example.agenda.Pessoa.dto.CadastrarPessoaDto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final Map<UUID, CadastrarPessoaDto> pessoasCadastradas = new HashMap<>();

    public PessoaService (){
        for (int i = 1; i <= 100; i++){
            CadastrarPessoaDto pessoaDto = new CadastrarPessoaDto();
            pessoaDto.setNome("nome" + i);
            pessoaDto.setTelefone("telefone" + i);
            pessoaDto.setIdade(i);
            pessoasCadastradas.put(pessoaDto.getId() ,pessoaDto);
        }
    }

    public void Cadastrar (CadastrarPessoaDto cadastrarPessoaDto){
        pessoasCadastradas.put(cadastrarPessoaDto.getId() ,cadastrarPessoaDto);
    }

    public Map<UUID, CadastrarPessoaDto> receberTudo (){
        return pessoasCadastradas;
    }

    public CadastrarPessoaDto pegaUnico (UUID id){
        if (!pessoasCadastradas.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com o id %s não encontrada".formatted(id));
        }
        return pessoasCadastradas.get(id);
    }

    public CadastrarPessoaDto Atualizar(UUID id, CadastrarPessoaDto cadastrarPessoaDto){
        if (!pessoasCadastradas.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com o id %s não encontrada".formatted(id));
        }
        pessoasCadastradas.get(id).atualizar(cadastrarPessoaDto);
        return pessoasCadastradas.get(id);
    }

    public void Deletar (UUID id){
        if (!pessoasCadastradas.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com o id %s não encontrada".formatted(id));
        }

        pessoasCadastradas.remove(id);
    }

}
