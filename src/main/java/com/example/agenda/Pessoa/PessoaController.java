package com.example.agenda.Pessoa;

import com.example.agenda.Pessoa.dto.CadastrarPessoaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")
@CrossOrigin("*")
public class PessoaController {
    @GetMapping()
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("foi");
    }

    @PostMapping("/hello")
    public void Cadastrar(@RequestBody CadastrarPessoaDto cadastrarPessoaDto){
        System.out.println(cadastrarPessoaDto.getNome());
    }

}
