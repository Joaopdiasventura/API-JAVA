package com.example.agenda.Pessoa;

import com.example.agenda.Pessoa.Exception.PessoaNotFoundException;
import com.example.agenda.Pessoa.Service.PessoaService;
import com.example.agenda.Pessoa.dto.CadastrarPessoaDto;
import com.example.agenda.Pessoa.model.Pessoa;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void Cadastrar(@RequestBody @Valid CadastrarPessoaDto cadastrarPessoaDto) {
        pessoaService.Cadastrar(cadastrarPessoaDto.toPessoa());
    }

    @GetMapping("/hello")
    public ResponseEntity<List<CadastrarPessoaDto>> Ver() {
        Map<UUID, Pessoa> pessoasCadastradas = pessoaService.receberTudo();
        List<CadastrarPessoaDto> pessoas = pessoasCadastradas.values().stream().map(p -> CadastrarPessoaDto.fromPessoa(p)).toList();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastrarPessoaDto> VerUnico(@PathVariable("id") UUID id) {

        Pessoa pessoa = pessoaService.pegaUnico(id);
        return ResponseEntity.ok(CadastrarPessoaDto.fromPessoa(pessoa));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastrarPessoaDto> Atualizar(@PathVariable("id") UUID id, @RequestBody @Valid Pessoa pessoa) {
        
        pessoaService.Atualizar(id, pessoa);
        return ResponseEntity.ok(CadastrarPessoaDto.fromPessoa(pessoaService.pegaUnico(id)));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Deletar(@PathVariable("id") UUID id) {

        pessoaService.Deletar(id);
        return ResponseEntity.ok("Deletado com sucesso");
        

    }

}