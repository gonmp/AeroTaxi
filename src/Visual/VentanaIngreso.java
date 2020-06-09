package Visual;

import javax.swing.*;
import java.awt.*;

public class VentanaIngreso extends JFrame {

    private JPanel panelInicial;

    public VentanaIngreso(){
        this.setBounds(100, 60, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis Un'kut");
        iniciarComponentesIngreso();
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

        JLabel saludoInicial = new JLabel("Bienvenido a aerotaxis Un'Kut");
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

    }

    private void colocarBotones(){

        JButton botonIngresar = new JButton("Ingresar");
        botonIngresar.setBounds(80, 370, 150, 50);
        botonIngresar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(botonIngresar);

        JButton botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setBounds(318, 370, 150, 50);
        botonRegistrarse.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(botonRegistrarse);

        JButton botonExit = new JButton("Salir");
        botonExit.setBounds(550, 370, 150, 50);
        botonExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(botonExit);
    }

    private void colocarCajasTexto(){

        JTextField cajaTextoDni = new JTextField();
        cajaTextoDni.setBounds(370, 150, 200, 40);
        panelInicial.add(cajaTextoDni);

        JTextField cajaTextoContraseña = new JTextField();
        cajaTextoContraseña.setBounds(370, 250, 200, 40);
        panelInicial.add(cajaTextoContraseña);

    }

    }
