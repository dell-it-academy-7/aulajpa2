package com.example.demo2.repositorios;

import com.example.demo2.entidades.Estudante;

import java.util.List;

public interface EstudanteRepositorio
{   List<Estudante> buscarTodos();

    Estudante buscarPorMatricula (String umaMatricula);
    Estudante removerPorMatricula(String umaMatricula);

    void cadastrar(Estudante umEstudante);
    void alterar  (Estudante umEstudante);
}
