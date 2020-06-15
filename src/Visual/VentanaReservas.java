package Visual;

import javax.swing.*;
import java.awt.*;

public class VentanaReservas extends JFrame {

    private JPanel panelInicial;

    public VentanaReservas() {
        this.setBounds(100, 60, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis Un'kut");
        iniciarComponentesRegistro();

    }

    private void iniciarComponentesRegistro(){

        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarAreaTexto();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);

    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Mis Reservas :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

    }
    private void colocarBotones(){

        JButton botonModificar = new JButton("Modificar");
        botonModificar.setBounds(90, 400, 120, 40);
        botonModificar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonModificar);

        JButton botonAtras = new JButton("Atras");
        botonAtras.setBounds(565, 400, 120, 40);
        botonAtras.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonAtras);
    }

    private void colocarAreaTexto(){

        JTextArea listadoVuelos = new JTextArea();
        listadoVuelos.setBounds(43, 80, 700, 280);
        panelInicial.add(listadoVuelos);

    }

    public static void main(String[] args) {
        VentanaReservas ventanaReservas = new VentanaReservas();
        ventanaReservas.setVisible(true);
    }
}
