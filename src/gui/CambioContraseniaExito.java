package gui;

import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CambioContraseniaExito extends JFrame{
    private JPanel panelInicial;
    private Usuario usuarioLogueado;

    public CambioContraseniaExito(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        this.setBounds(100, 60, 350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
    }

    private void colocarPanel(){
        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);
    }

    private void colocarEtiquetas(){
        JLabel titulo = new JLabel("Se ha registrado el usuario con éxito");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        panelInicial.add(titulo);
    }

    private void colocarBotones() {
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(25, 70, 160, 60);
        botonAceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAceptarClick(e);
            }
        });
        panelInicial.add(botonAceptar);
    }

    public void botonAceptarClick(MouseEvent e) {
        this.dispose();
        MenuUsuario menuUsuario = new MenuUsuario(usuarioLogueado);
        menuUsuario.setVisible(true);
    }
}
