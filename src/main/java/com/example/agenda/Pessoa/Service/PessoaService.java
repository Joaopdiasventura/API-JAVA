package com.example.agenda.Pessoa.Service;

import com.example.agenda.Pessoa.Exception.PessoaNotFoundException;
import com.example.agenda.Pessoa.entity.Pessoa;
import com.example.agenda.Pessoa.repository.PessoaRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public void Cadastrar(@NonNull Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }    

    public List<Pessoa> receberTudo (){
        return pessoaRepository.findAll();
    }

    public Pessoa pegaUnico (@NonNull UUID id){
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException("Pessoa com o id %s não encontrada".formatted(id)));
    }

    public Pessoa Atualizar(@NonNull UUID id, Pessoa cadastrarPessoa){

        Pessoa pessoa = pegaUnico(id);
        pessoa.atualizar(cadastrarPessoa);

        return pessoaRepository.save(pessoa);
    }

    public void Deletar (@NonNull UUID id){

        Pessoa pessoa = pegaUnico(id);
        if (pessoa != null) {
            pessoaRepository.delete(pessoa);
        }
    }

}
