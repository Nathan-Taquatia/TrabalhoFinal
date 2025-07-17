package org.trabalhofinal.repository;

import org.trabalhofinal.model.Funcionario;
import org.trabalhofinal.model.Restaurante;
import javax.persistence.*;
import java.util.List;
import javax.persistence.EntityManager;

public class RestauranteRepository {

    private final EntityManager em;
    public RestauranteRepository(EntityManager em) {
        this.em = em;
    }

    public List<Restaurante> buscar() {
        TypedQuery<Restaurante> buscarTodosQuery =
                this.em.createQuery("select e from Funcionario e order by e.nome", Restaurante.class);
        return buscarTodosQuery.getResultList();
    }

    public Restaurante buscarRestID(String id) {
        return this.em.find(Restaurante.class, id.toUpperCase());
    }

    public List<Restaurante> buscar(String nome) {
        TypedQuery<Restaurante> buscarTodosQuery =
                this.em.createQuery("select e from Restaurante e where UPPER(e.nome) like :nome order by e.nome", Restaurante.class);
        buscarTodosQuery.setParameter("nome", nome.toUpperCase()+"%");

        return buscarTodosQuery.getResultList();
    }


}
