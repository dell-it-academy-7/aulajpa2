package com.example.demo2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name= "estudantes")
public class Estudante
{   @Id
    private String matricula;

    @Column(nullable = false)
    private String nome;

    @Min(value = 6, message = "Idade minima é  6 anos")
    @Max(100)
    @Column(nullable = false)
    private int idade;

    public String getMatricula()               { return matricula;           }
    public String getNome()                    { return nome;                }
    public  int   getIdade()                   { return idade;               }

    public void setNome (String nome)          { this.nome      = nome;      }
    public void setIdade(int idade)            { this.idade     = idade;     }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    @Override
    public String toString()
    {   return "[nome = " + getNome() + ", idade = " + getIdade() + ", matricula = " + getMatricula() + "]";
    }
}
