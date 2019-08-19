package com.example.demo2.repositorios;

import com.example.demo2.entidades.Estudante;
import com.example.demo2.excecoes.EstudanteNaoEncontradoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class EstudanteRepositorioJPA implements EstudanteRepositorio
{   @PersistenceContext
    private EntityManager em;

    @Override
    public List<Estudante> buscarTodos()
    {   TypedQuery<Estudante> typedQuery = em.createQuery("select e from Estudante e", Estudante.class);
        return typedQuery.getResultList();
    }

    @Override
    public Estudante removerPorMatricula(String umaMatricula)
    {   Estudante estudante = buscarPorMatricula(umaMatricula);
        if(estudante == null)
            throw new EstudanteNaoEncontradoException("Matricula = " +umaMatricula + " INVÁLIDA");
        em.remove(estudante);
        return estudante;
    }

    @Override
    public Estudante buscarPorMatricula (String umaMatricula) { return em.find(Estudante.class, umaMatricula); }

    @Override
    public void cadastrar(Estudante umEstudante) { em.persist(umEstudante);}

    @Override
    public void alterar  (Estudante umEstudante) { em.merge(umEstudante);  }
}