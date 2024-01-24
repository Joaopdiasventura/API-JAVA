package com.example.agenda.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.agenda.Pessoa.Exception.PessoaNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {

    private static final Log log = LogFactory.getLog(MyControllerAdvice.class);

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<Void> notFound (PessoaNotFoundException e){
        log.warn(e.getMessage());
        return ResponseEntity.notFound().build();
    } 
    
}
