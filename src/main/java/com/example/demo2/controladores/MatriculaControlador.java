package com.example.demo2.controladores;

import com.example.demo2.dtos.SolicitacaoMatricula;
import com.example.demo2.negocio.UniversidadeFachada;
import org.springframework.web.bind.annotation.*;

@RestController// desabilita qualquer processamento de view
@RequestMapping("/matriculas")
public class MatriculaControlador {
    private UniversidadeFachada universidadeFachada;

    public MatriculaControlador(UniversidadeFachada universidadeFachada)
    {   this.universidadeFachada = universidadeFachada;
    }

    @PostMapping
    public void matricular(@RequestBody SolicitacaoMatricula solicitacao)
    {   universidadeFachada.matricular(solicitacao.matricula, solicitacao.curso);
    }
}