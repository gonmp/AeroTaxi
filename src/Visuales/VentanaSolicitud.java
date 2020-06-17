package Visuales;

import javax.swing.*;
import java.awt.*;

public class VentanaSolicitud extends JFrame {

    private JPanel panelInicial;

    private String[] origenes = {"Buenos Aires", "Cordoba", "Santiago", "Montevideo"};
    private String[] destinos = {"Buenos Aires", "Cordoba", "Santiago", "Montevideo"};

    public VentanaSolicitud(){
        this.setBounds(100, 60, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis Un'kut");
        iniciarComponentesSolicitud();
    }

    private void iniciarComponentesSolicitud(){

        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarCajasTexto();
        colocarRadioBotones();
        colocarListaDesplegable();
        colocarAreaTexto();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);

    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Solicitud de reserva :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaFecha = new JLabel("Fecha :");
        etiquetaFecha.setBounds(15, 50, 400, 50);
        etiquetaFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaFecha);

        JLabel etiquetaOrigen = new JLabel("Origen :");
        etiquetaOrigen.setBounds(15, 95, 400, 50);
        etiquetaOrigen.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaOrigen);

        JLabel etiquetaDestino = new JLabel("Destino :");
        etiquetaDestino.setBounds(500, 95, 400, 50);
        etiquetaDestino.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaDestino);

        JLabel etiquetaCantidadPas = new JLabel("Cantidad de pasajeros :");
        etiquetaCantidadPas.setBounds(15, 150, 400, 50);
        etiquetaCantidadPas.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaCantidadPas);

        JLabel etiquetaCategoria = new JLabel("Categoria :");
        etiquetaCategoria.setBounds(15, 210, 400, 50);
        etiquetaCategoria.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaCategoria);

        JLabel etiquetaCosto = new JLabel("Costo Total :");
        etiquetaCosto.setBounds(15, 480, 400, 50);
        etiquetaCosto.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaCosto);

    }

    private void colocarBotones(){

        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(500, 500, 120, 40);
        botonConfirmar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonConfirmar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(645, 500, 120, 40);
        botonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(botonCancelar);

    }

    private void colocarCajasTexto(){

        JTextField cajaTextoFecha = new JTextField();
        cajaTextoFecha.setBounds(280, 50, 160, 30);
        panelInicial.add(cajaTextoFecha);

        JTextField cajaTextoCantidadPas = new JTextField();
        cajaTextoCantidadPas.setBounds(280, 160, 160, 30);
        panelInicial.add(cajaTextoCantidadPas);

        JTextField cajaTextoCosto = new JTextField();
        cajaTextoCosto.setBounds(280, 490, 160, 30);
        panelInicial.add(cajaTextoCosto);
    }

    private void colocarRadioBotones(){

        JRadioButton radioBotonBronze = new JRadioButton("Bronze");
        radioBotonBronze.setBounds(170, 226, 100, 27);
        panelInicial.add(radioBotonBronze);

        JRadioButton radioBotonSilver = new JRadioButton("Silver");
        radioBotonSilver.setBounds(320, 226, 100, 27);
        panelInicial.add(radioBotonSilver);

        JRadioButton radioBotonGold = new JRadioButton("Gold");
        radioBotonGold.setBounds(470, 226, 100, 27);
        panelInicial.add(radioBotonGold);
    }


        private void colocarListaDesplegable(){

            JComboBox listaOrigenes = new JComboBox(origenes);
            listaOrigenes.setBounds(279, 105, 165, 30);
            panelInicial.add(listaOrigenes);

            JComboBox listaDestinos = new JComboBox(destinos);
            listaDestinos.setBounds(610, 105, 165, 30);
            panelInicial.add(listaDestinos);

        }

        private void colocarAreaTexto(){

            JTextArea listadoVuelos = new JTextArea();
            listadoVuelos.setBounds(43, 280, 700, 180);
            panelInicial.add(listadoVuelos);

        }
}
