package com.example.demo2.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstudanteNaoEncontradoException //extends Exception         //Exceção obrigatóriamente trataveis
                                             extends RuntimeException   //Exceção não obrigatóriamente trataveis
{  public EstudanteNaoEncontradoException() {}
   public EstudanteNaoEncontradoException(String message) {   super(message); }
}
