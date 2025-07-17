package org.trabalhofinal.repository;

import org.trabalhofinal.model.Funcionario;
import org.trabalhofinal.model.Restaurante;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.criterion.Projections.id;

public class FuncionarioRepository {

private final EntityManager em;
    public FuncionarioRepository(EntityManager em) {
        this.em = em;
    }

    public void inserir(Funcionario funcionario) {
        this.em.getTransaction().begin();
        this.em.merge(funcionario);
        this.em.getTransaction().commit();
    }

    public List<Funcionario> buscar() {
        TypedQuery<Funcionario> buscarTodosQuery =
                this.em.createQuery("select e from Funcionario e order by e.nome", Funcionario.class);
        return buscarTodosQuery.getResultList();
    }


    public List<Funcionario> buscarIdFun(Integer id) {

        TypedQuery<Funcionario> buscarTodosQuery =
                this.em.createQuery("select e from Funcionario e where UPPER(e.id) like :id order by e.id", Funcionario.class);
        buscarTodosQuery.setParameter("id ", id.intValue()+"%");

        return buscarTodosQuery.getResultList();
    }

    public List<Funcionario> buscar(String nome) {
        TypedQuery<Funcionario> buscarTodosQuery =
                this.em.createQuery("select e from Funcionario e where UPPER(e.nome) like :nome order by e.nome", Funcionario.class);
        buscarTodosQuery.setParameter("nome", nome.toUpperCase()+"%");

        return buscarTodosQuery.getResultList();
    }
    public Funcionario buscarFunId(String id) {
        return this.em.find(Funcionario.class, id.toUpperCase());
    }
}
