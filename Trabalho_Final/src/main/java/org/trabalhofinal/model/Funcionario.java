package org.trabalhofinal.model;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;


@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.TABLE , generator="funcionario_generator")
    @TableGenerator(name="funcionario_generator",
            table="chave",
            pkColumnName="id",
            valueColumnName="valor",
            allocationSize=1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }
    public Funcionario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public Funcionario() {
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
