package gui;

import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PerfilUsuario extends JFrame {

    private JPanel panelInicial;
    private Usuario usuarioLogueado;

    public PerfilUsuario(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        this.setBounds(100, 60, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentesRegistro();

    }

    private void iniciarComponentesRegistro(){

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

        JLabel titulo = new JLabel("Mi Perfil :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaDni = new JLabel("DNI :");
        etiquetaDni.setBounds(15, 60, 400, 50);
        etiquetaDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaDni);

        JLabel etiquetaNombre = new JLabel("Nombre :");
        etiquetaNombre.setBounds(15, 120, 400, 50);
        etiquetaNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaNombre);

        JLabel etiquetaApellido = new JLabel("Apellido :");
        etiquetaApellido.setBounds(15, 180, 400, 50);
        etiquetaApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaApellido);

        JLabel etiquetaEdad = new JLabel("Edad :");
        etiquetaEdad.setBounds(15, 240, 400, 50);
        etiquetaEdad.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaEdad);

        JLabel etiquetaEmail = new JLabel("Correo :");
        etiquetaEmail.setBounds(15, 300, 400, 50);
        etiquetaEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaEmail);

    }

    private void colocarCajasTexto() {

        JTextField cajaTextoDni = new JTextField();
        cajaTextoDni.setBounds(200, 60, 180, 40);
        cajaTextoDni.setEnabled(false);
        cajaTextoDni.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        cajaTextoDni.setText(usuarioLogueado.getDni());
        panelInicial.add(cajaTextoDni);

        JTextField cajaTextoNombre = new JTextField();
        cajaTextoNombre.setBounds(200, 120, 180, 40);
        cajaTextoNombre.setEnabled(false);
        cajaTextoNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        cajaTextoNombre.setText(usuarioLogueado.getNombre());
        panelInicial.add(cajaTextoNombre);

        JTextField cajaTextoApellido = new JTextField();
        cajaTextoApellido.setBounds(200, 180, 180, 40);
        cajaTextoApellido.setEnabled(false);
        cajaTextoApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        cajaTextoApellido.setText(usuarioLogueado.getApellido());
        panelInicial.add(cajaTextoApellido);

        JTextField cajaTextoEdad = new JTextField();
        cajaTextoEdad.setBounds(200, 245, 180, 40);
        cajaTextoEdad.setEnabled(false);
        cajaTextoEdad.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        cajaTextoEdad.setText(String.valueOf(usuarioLogueado.getEdad()));
        panelInicial.add(cajaTextoEdad);

        JTextField cajaTextoCorreo = new JTextField();
        cajaTextoCorreo.setBounds(200, 305, 260, 40);
        cajaTextoCorreo.setEnabled(false);
        cajaTextoCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        cajaTextoCorreo.setText(usuarioLogueado.getEmail());
        panelInicial.add(cajaTextoCorreo);

    }

    private void colocarBotones(){

        JButton botonModificarDatos = new JButton("Modificar Datos");
        botonModificarDatos.setBounds(175, 400, 200, 40);
        botonModificarDatos.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonModificarDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonModificarDatosClick(e);
            }
        });
        panelInicial.add(botonModificarDatos);

        JButton botonAtras = new JButton("Atras");
        botonAtras.setBounds(645, 400, 120, 40);
        botonAtras.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAtrasClick(e);
            }
        });
        panelInicial.add(botonAtras);

        JButton botonCambiarContraseña= new JButton("Cambiar contraseña");
        botonCambiarContraseña.setBounds(400, 400, 220, 40);
        botonCambiarContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonCambiarContraseña);

    }

    public void botonAtrasClick(MouseEvent e) {
        this.dispose();
        MenuUsuario menuUsuario = new MenuUsuario(usuarioLogueado);
        menuUsuario.setVisible(true);
    }

    public void botonModificarDatosClick(MouseEvent e) {
        this.dispose();
        ModificarPerfil modificarPerfil = new ModificarPerfil(usuarioLogueado);
        modificarPerfil.setVisible(true);
    }

    /*private void colocarRadioBotones(){

        JRadioButton radioBotonEliminar = new JRadioButton("Eliminar mi perfil");
        radioBotonEliminar.setBounds(17, 326, 300, 37);
        panelInicial.add(radioBotonEliminar);
    }*/

    public static void main(String[] args) {
        /*VentanaPerfil ventanaPerfil = new VentanaPerfil();
        ventanaPerfil.setVisible(true);*/
    }
}
