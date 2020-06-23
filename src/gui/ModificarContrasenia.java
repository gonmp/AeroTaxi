package gui;

import control.DatosUsuario;
import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarContrasenia extends JFrame {

    private JPanel panelInicial;
    private JPasswordField cajaTextoContraseñaActual;
    private JPasswordField cajaTextoNuevaContraseña;
    private JLabel etiquetaError;
    private Usuario usuarioLogueado;
    private DatosUsuario datosUsuario;

    public ModificarContrasenia(Usuario usuarioLogueado){
        this.usuarioLogueado = usuarioLogueado;
        datosUsuario = new DatosUsuario();
        this.setBounds(100, 60, 500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentesIngreso();
    }

    private void iniciarComponentesIngreso(){

        colocarPanel();
        colocarEtiquetas();
        colocarCajasTexto();
        colocarBotones();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);
    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Cambiar contraseña :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        panelInicial.add(titulo);

        JLabel contraseñaActual = new JLabel("Contraseña Actual :");
        contraseñaActual.setBounds(30, 59, 300, 50);
        contraseñaActual.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        panelInicial.add(contraseñaActual);

        JLabel nuevaContraseña = new JLabel("Nueva Contraseña :");
        nuevaContraseña.setBounds(30, 113, 300, 50);
        nuevaContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        panelInicial.add(nuevaContraseña);

        etiquetaError = new JLabel("");
        etiquetaError.setBounds(30, 200, 300, 50);
        etiquetaError.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        etiquetaError.setForeground(Color.RED);
        panelInicial.add(etiquetaError);
    }

    private void colocarCajasTexto() {

        cajaTextoContraseñaActual = new JPasswordField();
        cajaTextoContraseñaActual.setBounds(200, 60, 180, 40);
        panelInicial.add(cajaTextoContraseñaActual);

        cajaTextoNuevaContraseña = new JPasswordField();
        cajaTextoNuevaContraseña.setBounds(200, 120, 180, 40);
        panelInicial.add(cajaTextoNuevaContraseña);
    }

    private void colocarBotones(){

        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(50, 250, 120, 40);
        botonConfirmar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonConfirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonConfirmarClick();
            }
        });
        panelInicial.add(botonConfirmar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(255, 250, 120, 40);
        botonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonCancelarClick();
            }
        });
        panelInicial.add(botonCancelar);

    }

    public boolean comprobarContraseniaActual() {
        return usuarioLogueado.getContrasenia().equals((String) cajaTextoContraseñaActual.getText());
    }

    public void botonConfirmarClick() {
        if(!comprobarContraseniaActual()) {
            etiquetaError.setText("Error en la contraseña actual");
            return;
        }

        Usuario nuevoUsuario = datosUsuario.modificarContrasenia(usuarioLogueado, cajaTextoNuevaContraseña.getText());
        this.dispose();
        CambioContraseniaExito cambioContraseniaExito = new CambioContraseniaExito(nuevoUsuario);
        cambioContraseniaExito.setVisible(true);
    }

    public void botonCancelarClick() {
        this.dispose();
        MenuUsuario menuUsuario = new MenuUsuario(usuarioLogueado);
        menuUsuario.setVisible(true);
    }
}
