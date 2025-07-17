package org.trabalhofinal;

import org.trabalhofinal.controller.VotoController;
import org.trabalhofinal.exception.AplicacaoException;
import org.trabalhofinal.util.TecladoUtil;
import org.trabalhofinal.controller.FuncionarioController;

import java.util.Calendar;

public class Main {
    private static VotoController votoController = new VotoController();
    private static FuncionarioController funcionarioControllerController = new FuncionarioController();

    private static boolean sair = false;




    public static void main(String[] args) {
        while (!sair) {
            menu();
            int opcao = TecladoUtil.lerInteiro("Informa uma Opcao:");
            executaAcao(opcao);
        }
    }


    private static void executaAcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    inserirVoto();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    sair = true;
                    break;

                default:
                    System.out.println("Opcao invalida!!");
                    break;
            }
        }catch (AplicacaoException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void inserirVoto() throws  AplicacaoException{
        Integer id = TecladoUtil.lerInteiro("Informe o id:");
        Calendar data = Calendar.getInstance();
        String id_funcionario = TecladoUtil.lerString("Informe o nome do funcionario:");
        String id_restaurante = TecladoUtil.lerString("Informe o nome do restaurante:");


        votoController.inserir(id, data, id_funcionario, id_restaurante);

        System.out.println("Registro inserido!");
    }
private static void listarFuncionarios() throws AplicacaoException{
    System.out.println(votoController.buscarFuncionarios());

}
private static void listarRestaurantes() throws  AplicacaoException{
    System.out.println();
        
}

    private static void menu() {
        System.out.println("________________________");
        System.out.println("(1) Inserir votos");
        System.out.println("(2) Listar Funcionários");
        System.out.println("(3) Listar Restaurantes");
        System.out.println("(4) Apurar votação do dia");
        System.out.println("(5) Sair");
        System.out.println("________________________");
    }

}