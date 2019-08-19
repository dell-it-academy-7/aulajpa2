package com.example.demo2.negocio;

import com.example.demo2.entidades.Curso;
import com.example.demo2.entidades.Estudante;
import com.example.demo2.excecoes.CursoNaoEncontradoException;
import com.example.demo2.excecoes.EstudanteNaoEncontradoException;
import com.example.demo2.repositorios.CursoRepositorio;
import com.example.demo2.repositorios.EstudanteRepositorio;
import org.springframework.stereotype.Service;

@Service // fornece serviços de negócio para alguém
public class UniversidadeFachada
{   private EstudanteRepositorio estudantesRepo;
    private CursoRepositorio cursoRepositorio;

    public UniversidadeFachada(EstudanteRepositorio estudantesRepo, CursoRepositorio cursoRepositorio)
    {   this.cursoRepositorio = cursoRepositorio;
        this.estudantesRepo   = estudantesRepo;
    }

    public void matricular(String  matriculaEstudante, String codigo)
    {   Estudante estudante = estudantesRepo.buscarPorMatricula(matriculaEstudante);
        if (estudante == null)
            throw new EstudanteNaoEncontradoException("Nº de Matricula não encontrado");
        Curso curso = cursoRepositorio.buscarPorCodigo(codigo);
        if(curso == null)
            throw new CursoNaoEncontradoException("Curso não encontrado não encontrado");
        estudante.getCursos().add(curso);
    }
}
