package gui;

import control.ReservarVuelo;
import modelos.Reserva;
import modelos.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Reservas extends JFrame {

    private JPanel panelInicial;
    private JTable listadoVuelos;
    private JButton botonEliminar;
    private Reserva reservaSeleccionada;
    private Usuario usuarioLogueado;
    private ReservarVuelo reservarVuelo;
    private List<Reserva> todasLasReservas;
    private DefaultTableModel model;

    public Reservas(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        todasLasReservas = new ArrayList<Reserva>();
        reservarVuelo = new ReservarVuelo();
        this.setBounds(100, 60, 1200, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentesRegistro();
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Fecha");
        model.addColumn("Origen");
        model.addColumn("Destino");
        model.addColumn("Categoria del avion");
        model.addColumn("Cantidad de pasajeros");
        model.addColumn("WiFi");
        model.addColumn("Servicio de catering");
        model.addColumn("Total pagado");

        listadoVuelos.setModel(model);
        agregarFilaJTable();

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
        panelInicial.setBounds(0, 0, 1100, 500);
        this.getContentPane().add(panelInicial);
    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Mis Reservas :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

    }
    private void colocarBotones(){

        botonEliminar = new JButton("Eliminar reserva");
        botonEliminar.setBounds(350, 400, 170, 40);
        botonEliminar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonEliminar.setEnabled(false);
        botonEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(reservaSeleccionada != null) {
                    reservarVuelo.eliminarReserva(reservaSeleccionada);
                    botonEliminarClick(e);
                }
            }
        });
        panelInicial.add(botonEliminar);

        JButton botonAtras = new JButton("Atras");
        botonAtras.setBounds(565, 400, 120, 40);
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

        listadoVuelos = new JTable();
        listadoVuelos.setBounds(0, 0, 1100, 180);
        listadoVuelos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = listadoVuelos.rowAtPoint(e.getPoint());
                reservaSeleccionada = todasLasReservas.get(seleccion);
                System.out.println(reservaSeleccionada.toString());
                if(reservaSeleccionada != null) {
                    botonEliminar.setEnabled(true);
                }
            }
        });
        JScrollPane barraDeDesplazamiento = new JScrollPane(listadoVuelos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barraDeDesplazamiento.setBounds(43, 80, 1100, 280);
        panelInicial.add(barraDeDesplazamiento);

    }

    public void completarReservasDeUsuario() {
        todasLasReservas.clear();
        todasLasReservas = reservarVuelo.filtrarReservasDeUsuario(usuarioLogueado);
    }

    public void modificarJTable() {
        reservaSeleccionada = null;
    }

    public void agregarFilaJTable() {
        completarReservasDeUsuario();
        limpiarTabla();
        Object fila[] = new Object[8];
        DateFormat date = DateFormat.getDateInstance();
        Iterator<Reserva> iteradorReservas = todasLasReservas.iterator();
        Reserva aux;
        int i = 0;
        while(iteradorReservas.hasNext()) {
            aux = iteradorReservas.next();
            fila[0] = date.format(aux.getFecha().getTime()) + " " + aux.getFecha().get(Calendar.HOUR_OF_DAY) + " horas";
            fila[1] = aux.getOrigen();
            fila[2] = aux.getDestino();
            fila[3] = aux.getAvion().getCategoria();
            fila[4] = aux.getPasajeros();
            fila[5] = convertirBooleanAString(aux.getAvion().tieneWifi());
            fila[6] = convertirBooleanAString(aux.getAvion().tieneCatering());
            fila[7] = aux.getCostoDeVuelo();
            model.addRow(fila);
            i++;
        }
    }

    public void limpiarTabla() {
        model.setRowCount(0);
    }

    public void botonAtrasClick() {
        this.dispose();
        MenuUsuario menuUsuario = new MenuUsuario(usuarioLogueado);
        menuUsuario.setVisible(true);
    }

    public void botonEliminarClick(MouseEvent e) {
        this.dispose();
        ReservaEliminada reservaEliminada = new ReservaEliminada(usuarioLogueado);
        reservaEliminada.setVisible(true);
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
        Reservas reservas = new Reservas(usuario);
        reservas.setVisible(true);
    }
}
