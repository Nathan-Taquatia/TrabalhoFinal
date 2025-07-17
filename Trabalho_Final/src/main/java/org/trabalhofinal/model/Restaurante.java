package org.trabalhofinal.model;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANTE")
public class Restaurante {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.TABLE , generator="restaurante_generator")
    @TableGenerator(name="restaurante_generator",
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

    public Restaurante(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Restaurante(String nome) {
        this.nome = nome;
    }

    public Restaurante() {
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
