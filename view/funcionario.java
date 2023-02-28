package view;

import controller.funcionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funcionario extends JFrame{
    private JPanel funcionarioFrame;
    private JTextField tfNome;
    private JTextField tfSenha;
    private JButton btnAcessar;
    private JButton btnLimpar;

    public funcionario(){

        setContentPane(funcionarioFrame);  //Atributos da janela feitas pelo .form
        setTitle("Login");
        setSize(300, 400);
        setLocation(550,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnAcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(tfNome.getText());
                funcionario.setSenha(tfSenha.getText());

                funcionarioController funcionarioControl = new funcionarioController(null);
                funcionarioControl.autenticar(funcionario);



            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNome.setText("");
                tfSenha.setText("");


            }
        });
    }

    public static void main (String[] args)
    {
        funcionario tela = new funcionario();     // Vai iniciar a tela de login.
        tela.setVisible(true);
    }


}
