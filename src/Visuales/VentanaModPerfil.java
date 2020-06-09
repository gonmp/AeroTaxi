package Visuales;

import javax.swing.*;
import java.awt.*;

public class VentanaModPerfil extends JFrame {

    private JPanel panelInicial;

    public VentanaModPerfil() {
        this.setBounds(100, 60, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis Un'kut");
        iniciarComponentesRegistro();

    }

    private void iniciarComponentesRegistro(){

        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarCajasTexto();
        colocarRadioBotones();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);
    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Datos a modificar :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaModDni = new JLabel("Nuevo DNI :");
        etiquetaModDni.setBounds(15, 60, 400, 50);
        etiquetaModDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModDni);

        JLabel etiquetaModNombre = new JLabel("Nuevo nombre :");
        etiquetaModNombre.setBounds(15, 110, 400, 50);
        etiquetaModNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModNombre);

        JLabel etiquetaModApellido = new JLabel("Nuevo Apellido :");
        etiquetaModApellido.setBounds(15, 160, 400, 50);
        etiquetaModApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModApellido);

        JLabel etiquetaModEdad = new JLabel("Nueva edad :");
        etiquetaModEdad.setBounds(15, 210, 400, 50);
        etiquetaModEdad.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModEdad);

        JLabel etiquetaModEmail = new JLabel("Nuevo correo :");
        etiquetaModEmail.setBounds(15, 260, 400, 50);
        etiquetaModEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModEmail);
    }

    private void colocarCajasTexto(){

        JTextField cajaTextoNuevoDni = new JTextField();
        cajaTextoNuevoDni.setBounds(220, 65, 200, 35);
        panelInicial.add(cajaTextoNuevoDni);

        JTextField cajaTextoNuevoNombre = new JTextField();
        cajaTextoNuevoNombre.setBounds(220, 115, 200, 35);
        panelInicial.add(cajaTextoNuevoNombre);

        JTextField cajaTextoNuevoApellido = new JTextField();
        cajaTextoNuevoApellido.setBounds(220, 165, 200, 35);
        panelInicial.add(cajaTextoNuevoApellido);

        JTextField cajaTextoNuevaEdad = new JTextField();
        cajaTextoNuevaEdad.setBounds(220, 215, 200, 35);
        panelInicial.add(cajaTextoNuevaEdad);

        JTextField cajaTextoNuevoCorreo = new JTextField();
        cajaTextoNuevoCorreo.setBounds(220, 266, 200, 35);
        panelInicial.add(cajaTextoNuevoCorreo);

    }

    private void colocarRadioBotones(){

        JRadioButton radioBotonAdmin = new JRadioButton("Juro que no soy un robot");
        radioBotonAdmin.setBounds(15, 330, 200, 40);
        panelInicial.add(radioBotonAdmin);
    }

    private void colocarBotones(){

        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(500, 400, 120, 40);
        botonConfirmar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonConfirmar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(645, 400, 120, 40);
        botonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonCancelar);

    }

}
