package com.example.demo2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cursos")
public class Curso
{   @Id
    private String codigo;

    @Column(nullable = false)
    @NotEmpty(message = "Não pode ficar em branco ou nulo")
    @Size(min = 3, max = 255,message = "Nome Inválido")
    private String nome;

    public String getCodigo()            { return codigo;        }
    public String getNome()              { return nome;          }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNome  (String nome)   { this.nome   = nome;   }
}
