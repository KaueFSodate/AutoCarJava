package controller;

import DAO.carrosDAO;
import DAO.conexao;
import DAO.funcionarioDAO;
import model.Carros;
import view.AutoCar;

import java.sql.Connection;
import java.sql.SQLException;

public class carroController {
    private AutoCar view;

    public carroController(AutoCar view) {
        this.view = view;
    }

    public void cadastrar(Carros carro){

        try {

            Connection con = new conexao().getConnection(); // Cria a conexao
            carrosDAO carroDAO = new carrosDAO(con);    // Cria o objeto ProdutoDAO do tipo produtoDAO na qual tem como parametro a conexao com o meu BD.
            carroDAO.cadastrar(carro);

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }


    public void alterar(Carros carro){

        try {

            Connection con = new conexao().getConnection(); // Cria a conexao
            carrosDAO carroDAO = new carrosDAO(con);    // Cria o objeto ProdutoDAO do tipo produtoDAO na qual tem como parametro a conexao com o meu BD.
            carroDAO.alterar(carro);

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public void excluir(Carros carro){

        try {

            Connection con = new conexao().getConnection(); // Cria a conexao
            carrosDAO carroDAO = new carrosDAO(con);    // Cria o objeto ProdutoDAO do tipo produtoDAO na qual tem como parametro a conexao com o meu BD.
            carroDAO.excluir(carro);

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
