package org.trabalhofinal.controller;
import org.trabalhofinal.exception.AplicacaoException;
import org.trabalhofinal.model.*;
import org.trabalhofinal.model.Funcionario;
import org.trabalhofinal.model.Restaurante;
import org.trabalhofinal.repository.FuncionarioRepository;
import org.trabalhofinal.repository.RestauranteRepository;
import org.trabalhofinal.repository.VotoRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.Calendar;
import java.util.List;


public class VotoController {

    private final FuncionarioRepository funcionarioRepository;
    private final RestauranteRepository restauranteRepository;
    private final VotoRepository votoRepository;

    public VotoController(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CidadesDB");
        EntityManager em = factory.createEntityManager();
        this.votoRepository = new VotoRepository(em);
        this.funcionarioRepository = new FuncionarioRepository(em);
        this.restauranteRepository= new RestauranteRepository(em);
    }
    public void inserir(Integer id, Calendar data, String nomeRestaurante, String nomeFuncionario) throws  AplicacaoException {

        try {
            Restaurante restaurante = restauranteRepository.buscarRestID(nomeRestaurante);

            Funcionario funcionario = funcionarioRepository.buscarFunId(nomeFuncionario);

            if(funcionario == null) {
                funcionario = new Funcionario(nomeFuncionario);
            } else if ( restaurante==null) {
                restaurante = new Restaurante(nomeRestaurante);

            }

            votoRepository.inserir(new Voto(id, data, funcionario, restaurante));
        }catch (PersistenceException e) {
            e.printStackTrace();
            throw new AplicacaoException("Falha ao inserir Funcionario");
        }
    }


    public List<Funcionario> buscarFuncionarios() throws AplicacaoException {
        try {
            return funcionarioRepository.buscar();
        }catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao inserir Funcionário");
        }
    }

}
