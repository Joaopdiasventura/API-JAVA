package com.example.agenda.Pessoa;

import com.example.agenda.Pessoa.Service.PessoaService;
import com.example.agenda.Pessoa.dto.CadastrarPessoaDto;
import com.example.agenda.Pessoa.entity.Pessoa;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/agenda")
@CrossOrigin("*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/hello")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void Cadastrar(@RequestBody @Valid @NonNull CadastrarPessoaDto cadastrarPessoaDto) {

        Pessoa pessoa = cadastrarPessoaDto.toPessoa();
        
        pessoaService.Cadastrar(pessoa);
        
    }

    @GetMapping("/hello")
    public ResponseEntity<List<CadastrarPessoaDto>> Ver() {
        List<Pessoa> pessoasCadastradas = pessoaService.receberTudo();
        List<CadastrarPessoaDto> pessoas = pessoasCadastradas.stream().map(p -> CadastrarPessoaDto.fromPessoa(p)).toList();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastrarPessoaDto> VerUnico(@PathVariable("id") @NonNull UUID id) {

        Pessoa pessoa = pessoaService.pegaUnico(id);
        return ResponseEntity.ok(CadastrarPessoaDto.fromPessoa(pessoa));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastrarPessoaDto> Atualizar(@PathVariable("id") @NonNull UUID id, @RequestBody @Valid Pessoa pessoa) {
        
        pessoaService.Atualizar(id, pessoa);
        return ResponseEntity.ok(CadastrarPessoaDto.fromPessoa(pessoaService.pegaUnico(id)));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Deletar(@PathVariable("id") @NonNull UUID id) {

        pessoaService.Deletar(id);
        return ResponseEntity.ok("Deletado com sucesso");
        

    }

}