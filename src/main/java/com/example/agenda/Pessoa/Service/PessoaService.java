package com.example.agenda.Pessoa.Service;

import com.example.agenda.Pessoa.Exception.PessoaNotFoundException;
import com.example.agenda.Pessoa.dto.CadastrarPessoaDto;
import com.example.agenda.Pessoa.model.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final Map<UUID, Pessoa> pessoasCadastradas = new HashMap<>();

    public PessoaService (){
        for (int i = 1; i <= 100; i++){
            Pessoa pessoaDto = new Pessoa(null, ""+i+"", ""+i+"", i);
            pessoasCadastradas.put(pessoaDto.getId() ,pessoaDto);
        }
    }

    public void Cadastrar (Pessoa pessoa){
        pessoasCadastradas.put(pessoa.getId() ,pessoa);
    }

    public Map<UUID, Pessoa> receberTudo (){
        return pessoasCadastradas;
    }

    public Pessoa pegaUnico (UUID id){
        if (!pessoasCadastradas.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com o id %s não encontrada".formatted(id));
        }
        return pessoasCadastradas.get(id);
    }

    public Pessoa Atualizar(UUID id, Pessoa cadastrarPessoa){
        if (!pessoasCadastradas.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com o id %s não encontrada".formatted(id));
        }
        pessoasCadastradas.get(id).atualizar(cadastrarPessoa);
        return pessoasCadastradas.get(id);
    }

    public void Deletar (UUID id){
        if (!pessoasCadastradas.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com o id %s não encontrada".formatted(id));
        }

        pessoasCadastradas.remove(id);
    }

}
