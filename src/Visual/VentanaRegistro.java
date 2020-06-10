package Visual;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistro extends JFrame {

    private JPanel panelInicial;

    public VentanaRegistro() {
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

        JLabel titulo = new JLabel("Registro de usuario :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaDni = new JLabel("DNI :");
        etiquetaDni.setBounds(15, 60, 400, 50);
        etiquetaDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaDni);

        JLabel etiquetaContraseña = new JLabel("Contraseña :");
        etiquetaContraseña.setBounds(15, 120, 400, 50);
        etiquetaContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaContraseña);

        JLabel etiquetaRepetirContraseña = new JLabel("Repetir Contraseña :");
        etiquetaRepetirContraseña.setBounds(15, 180, 400, 50);
        etiquetaRepetirContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaRepetirContraseña);

        JLabel etiquetaNombre = new JLabel("Nombre :");
        etiquetaNombre.setBounds(430, 60, 400, 50);
        etiquetaNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaNombre);

        JLabel etiquetaApellido = new JLabel("Apellido :");
        etiquetaApellido.setBounds(430, 120, 400, 50);
        etiquetaApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaApellido);

        JLabel etiquetaEdad = new JLabel("Edad :");
        etiquetaEdad.setBounds(430, 180, 400, 50);
        etiquetaEdad.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaEdad);

        JLabel etiquetaEmail = new JLabel("Correo :");
        etiquetaEmail.setBounds(430, 240, 400, 50);
        etiquetaEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaEmail);
    }

    private void colocarBotones(){

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(90, 400, 120, 40);
        botonAceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonAceptar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(565, 400, 120, 40);
        botonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonCancelar);
    }

    private void colocarCajasTexto(){

        JTextField cajaTextoNuevoDni = new JTextField();
        cajaTextoNuevoDni.setBounds(200, 60, 180, 40);
        panelInicial.add(cajaTextoNuevoDni);

        JTextField cajaTextoNuevaContraseña = new JTextField();
        cajaTextoNuevaContraseña.setBounds(200, 120, 180, 40);
        panelInicial.add(cajaTextoNuevaContraseña);

        JTextField cajaTextoConfirmarContraseña = new JTextField();
        cajaTextoConfirmarContraseña.setBounds(200, 180, 180, 40);
        panelInicial.add(cajaTextoConfirmarContraseña);

        JTextField cajaTextoNombre = new JTextField();
        cajaTextoNombre.setBounds(520, 60, 200, 40);
        panelInicial.add(cajaTextoNombre);

        JTextField cajaTextoApellido = new JTextField();
        cajaTextoApellido.setBounds(520, 120, 200, 40);
        panelInicial.add(cajaTextoApellido);

        JTextField cajaTextoEdad = new JTextField();
        cajaTextoEdad.setBounds(520, 180, 200, 40);
        panelInicial.add(cajaTextoEdad);

        JTextField cajaTextoEmail = new JTextField();
        cajaTextoEmail.setBounds(520, 240, 200, 40);
        panelInicial.add(cajaTextoEmail);

    }

    private void colocarRadioBotones(){

        JRadioButton radioBotonAdmin = new JRadioButton("Juro que no soy un robot");
        radioBotonAdmin.setBounds(15, 240, 200, 40);
        panelInicial.add(radioBotonAdmin);

        JRadioButton radioBotonTerminos = new JRadioButton("Acepto terminos y condiciones");
        radioBotonTerminos.setBounds(15, 300, 200, 40);
        panelInicial.add(radioBotonTerminos);
    }

}
