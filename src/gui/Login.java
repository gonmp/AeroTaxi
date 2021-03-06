package gui;

import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

    private JPanel panelInicial;
    private control.Login login;
    private Usuario usuarioLoguar;

    JTextField cajaTextoDni;
    JPasswordField cajaTextoContrasenia;

    JLabel etiquetaError;

    public Login(){
        this.setBounds(100, 60, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentesIngreso();
        login = new control.Login();
    }


    //Creando el panel de la primera ventana

    private void iniciarComponentesIngreso(){

        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarCajasTexto();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);

    }

    private void colocarEtiquetas(){

        JLabel saludoInicial = new JLabel("Bienvenido a aerotaxis PepePotamo");
        saludoInicial.setBounds(155, 50, 1000, 100);
        saludoInicial.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        panelInicial.add(saludoInicial);

        JLabel etiquetaDni = new JLabel("Dni:");
        etiquetaDni.setBounds(130, 150, 200, 50);
        etiquetaDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        panelInicial.add(etiquetaDni);

        JLabel etiquetaContraseña = new JLabel("Contraseña:");
        etiquetaContraseña.setBounds(130, 250, 200, 50);
        etiquetaContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        panelInicial.add(etiquetaContraseña);

        etiquetaError = new JLabel("");
        etiquetaError.setBounds(280, 300, 400, 50);
        etiquetaError.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaError.setForeground(Color.RED);
        panelInicial.add(etiquetaError);

    }

    private void colocarBotones(){

        JButton botonIngresar = new JButton("Ingresar");
        botonIngresar.setBounds(80, 370, 150, 50);
        botonIngresar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        botonIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonIngresarClick(e);
            }
        });
        panelInicial.add(botonIngresar);

        JButton botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setBounds(318, 370, 150, 50);
        botonRegistrarse.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        botonRegistrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonRegistrarseClick(e);
            }
        });
        panelInicial.add(botonRegistrarse);

        JButton botonExit = new JButton("Salir");
        botonExit.setBounds(550, 370, 150, 50);
        botonExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        botonExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonSalirClick(e);
            }
        });
        panelInicial.add(botonExit);
    }

    private void colocarCajasTexto(){

        cajaTextoDni = new JTextField();
        cajaTextoDni.setBounds(370, 150, 200, 40);
        panelInicial.add(cajaTextoDni);

        cajaTextoContrasenia = new JPasswordField();
        cajaTextoContrasenia.setBounds(370, 250, 200, 40);
        panelInicial.add(cajaTextoContrasenia);

    }

    public void botonIngresarClick(MouseEvent e) {
        //Comprobar si el usuario existe
        usuarioLoguar = login.buscarUsuario(cajaTextoDni.getText());

        if(usuarioLoguar == null) {
            etiquetaError.setText("Usuario no encontrado");
            return;
        }

        //Comprobar si la contraseña ingresada es correcta
        if(!login.comprobarConstrasenia(usuarioLoguar, cajaTextoContrasenia.getText())) {
            etiquetaError.setText("Contraseña incorrecta");
            return;
        }

        //Loguear al usuario
        System.out.println(usuarioLoguar.toString());
        loguearUsuario();
    }

    public void botonRegistrarseClick(MouseEvent e) {
        this.dispose();
        Registro ventana = new Registro();
        ventana.setVisible(true);
    }

    public void botonSalirClick(MouseEvent e) {
        System.exit(0);
    }

    public void loguearUsuario() {
        if(usuarioLoguar.isAdmin()) {
            this.dispose();
            MenuAdmin menuAdmin = new MenuAdmin(usuarioLoguar);
            menuAdmin.setVisible(true);
        } else {
            this.dispose();
            MenuUsuario menuUsuario = new MenuUsuario(usuarioLoguar);
            menuUsuario.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Login ventania = new Login();
        ventania.setVisible(true);
    }

}
