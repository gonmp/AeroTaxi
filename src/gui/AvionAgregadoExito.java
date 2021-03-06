package gui;

import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AvionAgregadoExito extends JFrame{
    private JPanel panelInicial;
    private Usuario usuarioLogueado;

    public AvionAgregadoExito(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        this.setBounds(100, 60, 300, 200);
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
        JLabel titulo = new JLabel("El avión fue agregado con éxito");
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
        MenuAdmin menuAdmin = new MenuAdmin(usuarioLogueado);
        menuAdmin.setVisible(true);
    }
}
