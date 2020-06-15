package Visual;

import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenuUsuario extends JFrame {

    private JPanel panelInicial;
    private Usuario usuarioLogueado;

    public VentanaMenuUsuario(Usuario usuarioLogueado){
        this.usuarioLogueado = usuarioLogueado;
        this.setBounds(100, 60, 450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis Un'kut");
        iniciarComponentesIngreso();
    }

    private void iniciarComponentesIngreso(){

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

        JLabel titulo = new JLabel("Bienvenido/a " + usuarioLogueado.getNombre());
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        panelInicial.add(titulo);
    }

    private void colocarBotones(){

        JButton botonReservar = new JButton("Nueva reserva");
        botonReservar.setBounds(25, 70, 160, 60);
        botonReservar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonReservar);

        JButton botonGestionar = new JButton("Mis reservas");
        botonGestionar.setBounds(250, 70, 160, 60);
        botonGestionar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonGestionar);

        JButton botonPerfil = new JButton("Mi Perfil");
        botonPerfil.setBounds(25, 170, 160, 60);
        botonPerfil.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonPerfil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonPerfilClick(e);
            }
        });
        panelInicial.add(botonPerfil);

        JButton botonDesconectar = new JButton("Desconectar");
        botonDesconectar.setBounds(250, 170, 160, 60);
        botonDesconectar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonDesconectar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonDesconectarClick(e);
            }
        });
        panelInicial.add(botonDesconectar);
    }

    public void botonPerfilClick (MouseEvent e) {
        this.dispose();
        VentanaPerfil ventanaPerfil = new VentanaPerfil(usuarioLogueado);
        ventanaPerfil.setVisible(true);
    }

    public void botonDesconectarClick(MouseEvent e) {
        this.dispose();
        VentanaIngreso ventanaIngreso = new VentanaIngreso();
        ventanaIngreso.setVisible(true);
    }

}
