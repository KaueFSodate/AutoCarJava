package view;

import DAO.carrosDAO;
import DAO.conexao;
import controller.carroController;
import model.Carros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class AutoCar extends JFrame{
    private JTextField tfNome;
    private JTextField tfMarca;
    private JTextField tfTipo;
    private JTextField tfAno;
    private JSpinner tfValor;
    private JTextField tfPagamento;
    private JTextField tfChassi;

    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnComprar;
    private JButton btnLimpar;
    private JPanel telaAutoCar;
    private JButton consultarButton;

    public AutoCar() {


        setContentPane(telaAutoCar);  //Atributos da janela feitas pelo .form
        setTitle("AutoCar");
        setSize(570, 600);
        setLocation(550,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carros carro = new Carros(); // Criação do objeto do tipo Carros
                carro.setChassi(tfChassi.getText());
                carro.setNome(tfNome.getText());
                carro.setMarca(tfMarca.getText());
                carro.setTipo(tfTipo.getText());
                carro.setAno(tfAno.getText());
                carro.setValor(Integer.parseInt(tfValor.getValue().toString()));
                carro.setPagamento(tfPagamento.getText());

                carroController carroControl = new carroController(null);
                carroControl.cadastrar(carro);


            }
        });


        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Carros carro = new Carros(); // Criação do objeto do tipo Carros
                carro.setChassi(tfChassi.getText());
                carro.setNome(tfNome.getText());
                carro.setMarca(tfMarca.getText());
                carro.setTipo(tfTipo.getText());
                carro.setAno(tfAno.getText());
                carro.setValor(Integer.parseInt(tfValor.getValue().toString()));
                carro.setPagamento(tfPagamento.getText());

                carroController carroControl = new carroController(null);
                carroControl.alterar(carro);


            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carros carro = new Carros(); // Criação do objeto do tipo Carros
                carro.setChassi(tfChassi.getText());

                carroController carroControl = new carroController(null);
                carroControl.excluir(carro);

            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tfChassi.setText("");
                tfNome.setText("");
                tfMarca.setText("");
                tfTipo.setText("");
                tfAno.setText("");
                tfValor.setValue(0);
                tfPagamento.setText("");

            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String  chassi = tfChassi.getText();

                try {
                    Connection con = new conexao().getConnection();
                    carrosDAO CarroDAO = new carrosDAO(con);
                    Carros carro = CarroDAO.consultar(chassi);
                    if (carro == null) {

                    } else {
                        tfChassi.setText(carro.getChassi());
                        tfNome.setText(carro.getNome());
                        tfMarca.setText(carro.getMarca());
                        tfTipo.setText(carro.getTipo());
                        tfAno.setText(carro.getAno());
                        tfValor.setValue(carro.getValor());
                        tfPagamento.setText(carro.getPagamento());

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
