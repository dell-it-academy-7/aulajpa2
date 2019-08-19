package com.example.demo2.entidades;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name= "estudantes")
public class Estudante
{   @Id
    private String matricula;

    private final String idade_message = "Idade minima é 6 anos e maximo de 100 anos";

    @Column(nullable = false)
    @NotEmpty(message = "Não pode ficar em branco ou nulo")
    @Size(min = 3, max = 255,message = "Nome Inválido")
    private String nome;

    @Min(value = 6, message = idade_message)
    @Max(value = 100, message = idade_message)
    @Column(nullable = false)
    private int idade;

    @ElementCollection
    private Collection<String> telefones;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Curso> cursos;


    public String     getMatricula()            { return matricula;           }
    public String     getNome()                 { return nome;                }
    public Set<Curso> getCursos()               { return cursos;              }
    public  int       getIdade()                { return idade;               }

    public void setNome     (String nome)       { this.nome      = nome;      }
    public void setMatricula(String matricula)  { this.matricula = matricula; }
    public void setCursos   (Set<Curso> cursos) { this.cursos    = cursos;    }
    public void setIdade    (int idade)         { this.idade     = idade;     }


    @Override
    public String toString()
    {   return "[nome = " + getNome() + ", idade = " + getIdade() + ", matricula = " + getMatricula() + "]";
    }
}
