package com.example.demo2.controladores;

import com.example.demo2.entidades.Estudante;
import com.example.demo2.excecoes.EstudanteNaoEncontradoException;
import com.example.demo2.repositorios.EstudanteRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteControlador
{   private final EstudanteRepositorio repositorio;

    public EstudanteControlador(EstudanteRepositorio umRepositorio) {
        repositorio = umRepositorio;
    }

    @GetMapping
    public List<Estudante> getEstudantes() { return repositorio.buscarTodos(); }

    @GetMapping("/{matricula}")
    public ResponseEntity<Estudante> getEstudantePorMatricula(@PathVariable String matricula)
    {   Estudante umEstudante = repositorio.buscarPorMatricula(matricula);
        if (umEstudante == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(umEstudante);
    }

    @DeleteMapping("/{matricula}") // tem que ser igual ao parâmetro
    public Estudante remover(@PathVariable String matricula) { return repositorio.removerPorMatricula(matricula); }

    @GetMapping("/Criacao")
    public void criar()
    {   Estudante estudante = new Estudante();
        estudante.setMatricula(String.valueOf((int)(Math.random() * 1000)));
        estudante.setNome("John Doe");
        estudante.setIdade((int)(Math.random() * 100));
        repositorio.cadastrar(estudante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar (@Valid @RequestBody Estudante umEstudante) {   repositorio.cadastrar(umEstudante); }

    @PutMapping("/{matricula}")
    public void alterar(@PathVariable String matricula,
                        @RequestBody Estudante umEstudante)
    {  Estudante estudante = repositorio.buscarPorMatricula(matricula);
        if (estudante == null)
            throw new EstudanteNaoEncontradoException("Matricula = " +matricula + " INVÁLIDA");
        umEstudante.setMatricula(matricula);
        repositorio.alterar(umEstudante);
    }
}
