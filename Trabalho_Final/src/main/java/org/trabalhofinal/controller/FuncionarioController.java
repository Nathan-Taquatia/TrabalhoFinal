package org.trabalhofinal.controller;

import org.trabalhofinal.exception.AplicacaoException;
import org.trabalhofinal.model.Funcionario;
import org.trabalhofinal.model.Restaurante;
import org.trabalhofinal.repository.FuncionarioRepository;
import org.trabalhofinal.repository.RestauranteRepository;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;
    //private final RestauranteRepository restauranteRepository;

public FuncionarioController(){
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabalhoFinal");
    EntityManager em = factory.createEntityManager();
    this.funcionarioRepository = new FuncionarioRepository(em);


}public List<Funcionario> buscarIdFun(Integer id) throws AplicacaoException {
        try {
            return funcionarioRepository.buscarIdFun(id);
        }catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao inserir Funcionário");
        }
    }
    public List<Funcionario> buscar() throws  AplicacaoException {
        try {
            return funcionarioRepository.buscar();
        }catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao inserir Estado");
        }
    }


}
