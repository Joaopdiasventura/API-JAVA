package com.example.agenda.Pessoa;

import com.example.agenda.Pessoa.dto.CadastrarPessoaDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/agenda")
@CrossOrigin("*")
public class PessoaController {

    private final List<CadastrarPessoaDto> pessoasCadastradas = new ArrayList<>();

    public PessoaController (){
        for (int i = 1; i <= 100; i++){
            CadastrarPessoaDto pessoaDto = new CadastrarPessoaDto();
            pessoaDto.setNome("nome" + i);
            pessoaDto.setTelefone("telefone" + i);
            pessoaDto.setIdade(i);
            pessoasCadastradas.add(pessoaDto);
        }
    }

    @PostMapping("/hello")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<CadastrarPessoaDto> Cadastrar(@RequestBody @Valid CadastrarPessoaDto cadastrarPessoaDto){
        pessoasCadastradas.add(cadastrarPessoaDto);
        return ResponseEntity.ok(cadastrarPessoaDto);
    }

    @GetMapping("/hello")
    public ResponseEntity<List<CadastrarPessoaDto>> Ver (){
        return ResponseEntity.ok(pessoasCadastradas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastrarPessoaDto> VerUnico (@PathVariable("id") UUID id){
        for (CadastrarPessoaDto pessoa : pessoasCadastradas){
            if (pessoa.getId().equals(id)){
                return ResponseEntity.ok(pessoa);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastrarPessoaDto> Atualizar (@PathVariable("id") UUID id, @RequestBody @Valid CadastrarPessoaDto atualizarPessoaDto) {
        for (CadastrarPessoaDto pessoa: pessoasCadastradas){
            if (pessoa.getId().equals(id)){
                pessoa.atualizar(atualizarPessoaDto);
                return ResponseEntity.ok(pessoa);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<CadastrarPessoaDto>> Deletar (@PathVariable("id") UUID id){
        for (CadastrarPessoaDto pessoa : pessoasCadastradas){
            if (pessoa.getId().equals(id)){
                pessoasCadastradas.remove(pessoa);
                return ResponseEntity.ok(pessoasCadastradas);
            }
        }
        return ResponseEntity.notFound().build();
    }

}