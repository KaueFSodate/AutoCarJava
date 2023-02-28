package DAO;

import model.Carros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class carrosDAO {
    private final Connection conexao;

    public carrosDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Carros carro){
        String sql = "INSERT INTO carros(chassi, nome, marca, tipo, ano, valor, pagamento) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try
        {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, carro.getChassi());
            stmt.setString(2, carro.getNome());
            stmt.setString(3, carro.getMarca());
            stmt.setString(4, carro.getTipo());
            stmt.setString(5, carro.getAno());
            stmt.setInt(6, carro.getValor());
            stmt.setString(7, carro.getPagamento());

            stmt.execute(); // Realiza o comando no BD.
            conexao.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public Carros consultar(String chassi){

        Carros carro = new Carros();
        String sql = "SELECT *FROM carros where chassi = ?";
        try
        {

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, chassi);

            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                carro.setChassi(rs.getString("chassi"));
                carro.setNome(rs.getString("nome"));
                carro.setMarca(rs.getString("marca"));
                carro.setTipo(rs.getString("tipo"));
                carro.setAno(rs.getString("ano"));
                carro.setValor(rs.getInt("valor"));
                carro.setPagamento(rs.getString("pagamento"));
                return carro;
            }else
            {
                return null;
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }


    public void alterar(Carros carro){

        String sql = "UPDATE carros SET nome = ?, marca = ?, tipo = ?, ano = ?, valor = ?, pagamento = ? WHERE (chassi = ?);";
        try
        {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, carro.getNome());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getTipo());
            stmt.setString(4, carro.getAno());
            stmt.setInt(5, carro.getValor());
            stmt.setString(6, carro.getPagamento());
            stmt.setString(7, carro.getChassi());

            stmt.execute(); // Realiza o comando no BD.
            conexao.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void excluir(Carros carro){

        String sql = "DELETE FROM carros WHERE (chassi = ?);";
        try
        {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, carro.getChassi());

            stmt.execute(); // Realiza o comando no BD.
            conexao.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

}
