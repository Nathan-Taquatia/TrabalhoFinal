package org.trabalhofinal.repository;

import org.trabalhofinal.model.Voto;
import java.util.Calendar;
import javax.persistence.*;
import java.util.List;

public class VotoRepository {

    private final EntityManager em;
    public VotoRepository(EntityManager em) {
        this.em = em;
    }

    public void inserir(Voto voto) {
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }

    public List<Voto> buscarPorFuncionarioEData(Integer idFuncionario, Calendar data) {
        return em.createQuery("SELECT v FROM Voto v WHERE v.funcionario.id = :id AND v.data = :data", Voto.class)
                .setParameter("id", idFuncionario)
                .setParameter("data", data)
                .getResultList();
    }


}
