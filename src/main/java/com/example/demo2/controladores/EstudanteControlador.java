package com.example.demo2.controladores;

import com.example.demo2.entidades.Estudante;
import com.example.demo2.repositorios.EstudanteRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteControlador {
    private final EstudanteRepositorio repositorio;

    public EstudanteControlador(EstudanteRepositorio umRepositorio) {
        repositorio = umRepositorio;
    }

    @GetMapping
    public List<Estudante> getEstudantes() {
        return repositorio.buscarTodos();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Estudante> getEstudantePorMatricula(@PathVariable String matricula) {
        Estudante umEstudante = repositorio.buscarPorMatricula(matricula);
        if (umEstudante == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(umEstudante);
    }

    @DeleteMapping("/{matricula}")
    public Estudante remove(@PathVariable String umaMatricula)
    {  return   repositorio.removerPorMatricula(umaMatricula);
    }



    @GetMapping("/testeCriacao")
    public void criar()
    {   Estudante estudante = new Estudante();
        estudante.setMatricula("123");
        estudante.setNome("John Doe");
        estudante.setIdade(22);
        repositorio.cadastrar(estudante);
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar (@RequestBody Estudante umEstudante)
    {   repositorio.cadastrar(umEstudante);
    }
}
