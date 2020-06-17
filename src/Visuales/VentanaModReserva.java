package Visuales;

import javax.swing.*;
import java.awt.*;

public class VentanaModReserva extends JFrame {

    private JPanel panelInicial;

    private String[] destinos = {"Buenos Aires", "Cordoba", "Santiago", "Montevideo"};

    public VentanaModReserva() {
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
        colocarListaDesplegable();
        colocarRadioBotones();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);

    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Gestionar Reserva :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaFecha = new JLabel("Fecha :");
        etiquetaFecha.setBounds(15, 50, 400, 50);
        etiquetaFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaFecha);

        JLabel etiquetaCantidadPas = new JLabel("Cantidad de pasajeros :");
        etiquetaCantidadPas.setBounds(15, 100, 400, 50);
        etiquetaCantidadPas.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaCantidadPas);

        JLabel etiquetaNuevoDestino = new JLabel("Nuevo destino :");
        etiquetaNuevoDestino.setBounds(15, 160, 400, 50);
        etiquetaNuevoDestino.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaNuevoDestino);

        JLabel etiquetaAviso = new JLabel("<html>En caso de querer modificar la categoria o la ciudad <P>" + "<html>de origen, por favor, cancele la reserva y vuelva a formularla<P>");
        etiquetaAviso.setBounds(15, 250, 400, 60);
        etiquetaAviso.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        panelInicial.add(etiquetaAviso);

        JLabel etiquetaCosto = new JLabel("Nuevo Costo :");
        etiquetaCosto.setBounds(15, 380, 400, 50);
        etiquetaCosto.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaCosto);

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

    private void colocarCajasTexto(){

        JTextField cajaTextoFecha = new JTextField();
        cajaTextoFecha.setBounds(280, 50, 160, 30);
        panelInicial.add(cajaTextoFecha);

        JTextField cajaTextoCantidadPas = new JTextField();
        cajaTextoCantidadPas.setBounds(280, 110, 160, 30);
        panelInicial.add(cajaTextoCantidadPas);

        JTextField cajaTextoCosto = new JTextField();
        cajaTextoCosto.setBounds(280, 390, 160, 30);
        panelInicial.add(cajaTextoCosto);
    }

    private void colocarListaDesplegable(){

        JComboBox listaDestinos = new JComboBox(destinos);
        listaDestinos.setBounds(280, 170, 165, 30);
        panelInicial.add(listaDestinos);

    }

    private void colocarRadioBotones(){

        JRadioButton radioBotonCancelar = new JRadioButton("Cancelar Reserva");
        radioBotonCancelar.setBounds(17, 326, 300, 37);
        panelInicial.add(radioBotonCancelar);
    }

}
