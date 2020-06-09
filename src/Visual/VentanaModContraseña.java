package Visual;

import javax.swing.*;
import java.awt.*;

public class VentanaModContraseña extends JFrame {

    private JPanel panelInicial;

    public VentanaModContraseña(){
        this.setBounds(100, 60, 450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis Un'kut");
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
    }

    private void colocarCajasTexto() {

        JTextField cajaTextoContraseñaActual = new JTextField();
        cajaTextoContraseñaActual.setBounds(200, 60, 180, 40);
        panelInicial.add(cajaTextoContraseñaActual);

        JTextField cajaTextoNuevaContraseña = new JTextField();
        cajaTextoNuevaContraseña.setBounds(200, 120, 180, 40);
        panelInicial.add(cajaTextoNuevaContraseña);
    }

    private void colocarBotones(){

        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(50, 200, 120, 40);
        botonConfirmar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonConfirmar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(255, 200, 120, 40);
        botonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonCancelar);

    }
}
