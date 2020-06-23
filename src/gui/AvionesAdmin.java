package gui;

import control.DatosAvion;
import modelos.Avion;
import modelos.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvionesAdmin extends JFrame{
    private JPanel panelInicial;
    private JTable listadoAviones;
    private JButton botonEliminar;
    private Avion avionSeleccionado;
    private Usuario usuarioLogueado;
    private List<Avion> aviones;
    private DatosAvion datosAvion;
    private DefaultTableModel model;

    public AvionesAdmin(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        //todasLasReservas = new ArrayList<Reserva>();
        datosAvion = new DatosAvion();
        this.setBounds(100, 60, 1400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentes();
        aviones = new ArrayList<Avion>();
        completarAviones();
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Id");
        model.addColumn("Categoria");
        model.addColumn("Capicidad de combustible");
        model.addColumn("Costo por kilometro");
        model.addColumn("Capacidad de pasajeros");
        model.addColumn("Velocidad máxima");
        model.addColumn("Propulsión");
        model.addColumn("Tiene wifi");
        model.addColumn("Tiene servicio de catering");

        listadoAviones.setModel(model);
        agregarFilaJTable();

    }

    private void iniciarComponentes(){

        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarAreaTexto();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        panelInicial.setBounds(0, 0, 1100, 500);
        this.getContentPane().add(panelInicial);

    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Aviones :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

    }
    private void colocarBotones(){

        botonEliminar = new JButton("Eliminar avión");
        botonEliminar.setBounds(350, 400, 200, 40);
        botonEliminar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonEliminar.setEnabled(false);
        botonEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(avionSeleccionado != null) {
                    datosAvion.eleminarAvion(avionSeleccionado);
                    botonEliminarClick(e);
                }
            }
        });
        panelInicial.add(botonEliminar);

        JButton botonAtras = new JButton("Atrás");
        botonAtras.setBounds(750, 400, 120, 40);
        botonAtras.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAtrasClick();
            }
        });
        panelInicial.add(botonAtras);
    }

    private void colocarAreaTexto(){

        listadoAviones = new JTable();
        listadoAviones.setBounds(0, 0, 1300, 180);
        listadoAviones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = listadoAviones.rowAtPoint(e.getPoint());
                avionSeleccionado = aviones.get(seleccion);
                System.out.println(avionSeleccionado.toString());
                if(avionSeleccionado != null) {
                    botonEliminar.setEnabled(true);
                }
            }
        });
        JScrollPane barraDeDesplazamiento = new JScrollPane(listadoAviones, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barraDeDesplazamiento.setBounds(43, 80, 1300, 280);
        panelInicial.add(barraDeDesplazamiento);

    }

    public void completarAviones() {
        aviones = datosAvion.listarTodosLosAviones();
    }

    public void modificarJTable() {
        avionSeleccionado = null;
    }

    public void agregarFilaJTable() {
        limpiarTabla();
        Object fila[] = new Object[9];
        DateFormat date = DateFormat.getDateInstance();
        Iterator<Avion> iteradorAviones = aviones.iterator();
        Avion aux;
        int i = 0;
        while(iteradorAviones.hasNext()) {
            aux = iteradorAviones.next();
            fila[0] = aux.getId();
            fila[1] = aux.getCategoria();
            fila[2] = aux.getCapacidadCombustible();
            fila[3] = aux.getCostoPorKilometro();
            fila[4] = aux.getCapacidadPasajeros();
            fila[5] = aux.getVelocidadMaxima();
            fila[6] = aux.getPropulsion();
            fila[7] = convertirBooleanAString(aux.tieneWifi());
            fila[8] = convertirBooleanAString(aux.tieneCatering());
            model.addRow(fila);
            i++;
        }
    }

    public void limpiarTabla() {
        model.setRowCount(0);
    }

    public void botonAtrasClick() {
        this.dispose();
        MenuAdmin menuUsuario = new MenuAdmin(usuarioLogueado);
        menuUsuario.setVisible(true);
    }

    public void botonEliminarClick(MouseEvent e) {
        this.dispose();
        AvionEliminado avionEliminado = new AvionEliminado(usuarioLogueado);
        avionEliminado.setVisible(true);
    }

    public String convertirBooleanAString(boolean dato) {
        String booleano = "";
        if(dato) {
            booleano = "SI";
        } else {
            booleano = "NO";
        }
        return booleano;
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Pepe", "Gomez", "35123456", 29, "pepegomez@gmail.com", "123456");
        AvionesAdmin avionesAdmin = new AvionesAdmin(usuario);
        avionesAdmin.setVisible(true);
    }
}
