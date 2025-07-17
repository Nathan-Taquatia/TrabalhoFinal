package org.trabalhofinal.controller;

import org.trabalhofinal.exception.AplicacaoException;
import org.trabalhofinal.model.Funcionario;
import org.trabalhofinal.model.Restaurante;
import org.trabalhofinal.repository.FuncionarioRepository;
import org.trabalhofinal.repository.RestauranteRepository;
import org.trabalhofinal.repository.VotoRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class RestauranteController {
    private final RestauranteRepository restauranteRepository;
    public RestauranteController() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabalhoFinal");

        EntityManager em = factory.createEntityManager();

        this.restauranteRepository = new RestauranteRepository(em);

    }

}
