package gui;

import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuAdmin extends JFrame {
    private JPanel panelInicial;
    private Usuario usuarioLogueado;

    public MenuAdmin(Usuario usuarioLogueado){
        this.usuarioLogueado = usuarioLogueado;
        this.setBounds(100, 60, 450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
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

        JLabel titulo = new JLabel("Bienvenido/a ADMIN " + usuarioLogueado.getNombre());
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        panelInicial.add(titulo);
    }

    private void colocarBotones(){

        JButton botonUsuarios = new JButton("Ver Usuarios");
        botonUsuarios.setBounds(25, 70, 160, 60);
        botonUsuarios.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonUsuariosClick(e);
            }
        });
        panelInicial.add(botonUsuarios);

        JButton botonReservas = new JButton("Ver reservas");
        botonReservas.setBounds(250, 70, 160, 60);
        botonReservas.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonReservas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonReservasClick(e);
            }
        });
        panelInicial.add(botonReservas);

        JButton botonAviones = new JButton("Ver aviones");
        botonAviones.setBounds(25, 170, 160, 60);
        botonAviones.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAviones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAvionesClick(e);
            }
        });
        panelInicial.add(botonAviones);

        JButton botonAgregarAvion = new JButton("Agregar avión");
        botonAgregarAvion.setBounds(250, 170, 160, 60);
        botonAgregarAvion.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAgregarAvion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAgregarAvionClick(e);
            }
        });
        panelInicial.add(botonAgregarAvion);

        JButton botonPerfil = new JButton("Mi Perfil");
        botonPerfil.setBounds(25, 270, 160, 60);
        botonPerfil.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonPerfil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonPerfilClick(e);
            }
        });
        panelInicial.add(botonPerfil);

        JButton botonDesconectar = new JButton("Desconectar");
        botonDesconectar.setBounds(250, 270, 160, 60);
        botonDesconectar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonDesconectar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonDesconectarClick(e);
            }
        });
        panelInicial.add(botonDesconectar);
    }

    public void botonAvionesClick (MouseEvent e) {
        this.dispose();
        AvionesAdmin avionesAdmin = new AvionesAdmin(usuarioLogueado);
        avionesAdmin.setVisible(true);
    }

    public void botonAgregarAvionClick(MouseEvent e) {
        this.dispose();
        AgregarAvionAdmin agregarAvionAdmin = new AgregarAvionAdmin(usuarioLogueado);
        agregarAvionAdmin.setVisible(true);
    }

    public void botonPerfilClick (MouseEvent e) {
        this.dispose();
        PerfilUsuario perfilUsuario = new PerfilUsuario(usuarioLogueado);
        perfilUsuario.setVisible(true);
    }

    public void botonUsuariosClick(MouseEvent e) {
        this.dispose();
        UsuariosAdmin usuariosAdmin = new UsuariosAdmin(usuarioLogueado);
        usuariosAdmin.setVisible(true);
    }

    public void botonReservasClick(MouseEvent e) {
        this.dispose();
        ReservasAdmin reservas = new ReservasAdmin(usuarioLogueado);
        reservas.setVisible(true);
    }

    public void botonDesconectarClick(MouseEvent e) {
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Pepe", "Gomez", "35123456", 29, "pepegomez@gmail.com", "123456");
        MenuAdmin menuAdmin = new MenuAdmin(usuario);
        menuAdmin.setVisible(true);
    }
}
