package gui;

import control.ReservarVuelo;
import modelos.Ciudad;
import modelos.Reserva;
import modelos.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ReservasAdmin extends JFrame{
    private JPanel panelInicial;
    private JTable listadoVuelos;
    private JButton botonEliminar;
    private Usuario usuarioLogueado;
    private List<Reserva> reservasPorFecha;
    private Reserva reservaSeleccionada;
    private DefaultTableModel model;
    private ReservarVuelo reservarVuelo;

    private JComboBox listaAnios;
    private JComboBox listaMeses;
    private JComboBox listaDias;
    private List<Integer> anios;
    private List<String> meses;
    private List<Integer> dias;

    private Calendar calendario;

    public ReservasAdmin(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        reservarVuelo = new ReservarVuelo();
        reservasPorFecha = new ArrayList<Reserva>();
        anios = new ArrayList<>();
        meses = new ArrayList<>();
        dias = new ArrayList<>();

        calendario = Calendar.getInstance();

        completarAnios();

        this.setBounds(100, 60, 1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentes();
        completarReservas();
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Id");
        model.addColumn("Fecha");
        model.addColumn("Usuario");
        model.addColumn("DNI");
        model.addColumn("Pasajeros");
        model.addColumn("Origen");
        model.addColumn("Destino");
        model.addColumn("Avion");
        model.addColumn("Total pagado");

        listadoVuelos.setModel(model);
        agregarFilaJTable();

    }

    private void iniciarComponentes(){

        colocarPanel();
        colocarEtiquetas();
        colocarListaDesplegable();
        colocarBotones();
        colocarAreaTexto();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        panelInicial.setBounds(0, 0, 1100, 600);
        this.getContentPane().add(panelInicial);

    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Reservas :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaAnio = new JLabel("Año :");
        etiquetaAnio.setBounds(15, 50, 400, 50);
        etiquetaAnio.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaAnio);

        JLabel etiquetaMes = new JLabel("Mes :");
        etiquetaMes.setBounds(190, 50, 400, 50);
        etiquetaMes.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaMes);

        JLabel etiquetaDia = new JLabel("Día :");
        etiquetaDia.setBounds(360, 50, 400, 50);
        etiquetaDia.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaDia);

    }
    private void colocarBotones(){

        botonEliminar = new JButton("Eliminar reserva");
        botonEliminar.setBounds(350, 500, 200, 40);
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
        botonAtras.setBounds(750, 500, 120, 40);
        botonAtras.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAtrasClick();
            }
        });
        panelInicial.add(botonAtras);
    }

    private void colocarListaDesplegable(){

        listaAnios = new JComboBox(anios.toArray());
        listaAnios.setBounds(70, 60, 100, 30);
        listaAnios.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                listaMeses.removeAllItems();
                completarMeses();
                agregarMesesListaMeses();
                modificarTabla();
            }
        });
        panelInicial.add(listaAnios);

        completarMeses();
        listaMeses = new JComboBox(meses.toArray());
        listaMeses.setBounds(240, 60, 100, 30);
        listaMeses.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                listaDias.removeAllItems();
                completarDias();
                agregarDiasListaDias();
                modificarTabla();
            }
        });
        panelInicial.add(listaMeses);

        completarDias();
        listaDias = new JComboBox(dias.toArray());
        listaDias.setBounds(410, 60, 100, 30);
        listaDias.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                modificarTabla();
            }
        });
        panelInicial.add(listaDias);
    }

    private void colocarAreaTexto(){

        listadoVuelos = new JTable();
        listadoVuelos.setBounds(0, 0, 1100, 180);
        listadoVuelos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = listadoVuelos.rowAtPoint(e.getPoint());
                reservaSeleccionada = reservasPorFecha.get(seleccion);
                System.out.println(reservaSeleccionada.toString());
                if(reservaSeleccionada != null) {
                    botonEliminar.setEnabled(true);
                }
            }
        });
        JScrollPane barraDeDesplazamiento = new JScrollPane(listadoVuelos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barraDeDesplazamiento.setBounds(43, 180, 1100, 280);
        panelInicial.add(barraDeDesplazamiento);

    }

    public void completarReservas() {
        reservasPorFecha.clear();
        reservasPorFecha = reservarVuelo.filtrarAvionesPorFecha((Integer) listaAnios.getSelectedItem(), transformarMesEnInt((String) listaMeses.getSelectedItem()), (Integer) listaDias.getSelectedItem());
    }

    public void modificarJTable() {
        limpiarTabla();
        reservaSeleccionada = null;
        agregarFilaJTable();

    }

    public void agregarFilaJTable() {
        if(listaAnios.getSelectedItem() == null || listaMeses.getSelectedItem() == null || listaDias.getSelectedItem() == null){
            return;
        }
        completarReservas();
        limpiarTabla();
        Object fila[] = new Object[9];
        DateFormat date = DateFormat.getDateInstance();
        Iterator<Reserva> iteradorReserva = reservasPorFecha.iterator();
        Reserva aux;
        int i = 0;
        while(iteradorReserva.hasNext()) {
            aux = iteradorReserva.next();
            fila[0] = aux.getId();
            fila[1] = date.format(aux.getFecha().getTime()) + " " + aux.getFecha().get(Calendar.HOUR_OF_DAY) + " horas";
            fila[2] = aux.getUsuario().getNombre() + " " + aux.getUsuario().getApellido();
            fila[3] = aux.getUsuario().getDni();
            fila[4] = aux.getPasajeros();
            fila[5] = aux.getOrigen();
            fila[6] = aux.getDestino();
            fila[7] = aux.getAvion().getCategoria();
            fila[8] = aux.getCostoDeVuelo();
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
        ReservaEliminada modificarPerfilAdmin = new ReservaEliminada(usuarioLogueado);
        modificarPerfilAdmin.setVisible(true);
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

    public void completarAnios() {
        anios.add(calendario.get(Calendar.YEAR));
        anios.add(calendario.get(Calendar.YEAR) + 1);
    }

    public void agregarMesesListaMeses() {
        Iterator<String> iterador = meses.iterator();
        String aux;
        while(iterador.hasNext()) {
            aux = iterador.next();
            listaMeses.addItem(aux);
        }
    }

    public void completarMeses() {
        meses.clear();
        if(listaAnios.getSelectedItem().equals(calendario.get(Calendar.YEAR))) {
            completarMesesAnioActual();
        } else {
            completarTodosMeses();
        }
    }

    public void completarTodosMeses() {
        for(int i = 0; i < 12; i++) {
            meses.add(transformarMesEnString(i));
        }
    }

    public void completarMesesAnioActual() {
        for (int i = calendario.get(Calendar.MONTH); i < 12; i++) {
            meses.add(transformarMesEnString(i));
        }
    }

    public void agregarDiasListaDias() {
        Iterator<Integer> iterador = dias.iterator();
        int aux;
        while(iterador.hasNext()) {
            aux = iterador.next();
            listaDias.addItem(aux);
        }
    }

    public void completarDias() {
        dias.clear();
        if(listaMeses.getSelectedItem() != null) {
            if (listaAnios.getSelectedItem().equals(calendario.get(Calendar.YEAR)) && listaMeses.getSelectedItem().equals(transformarMesEnString(calendario.get(Calendar.MONTH)))) {
                completarDiasMesActual();
            } else {
                completarDiasCompleto();
            }
        }
    }

    public void completarDiasCompleto() {
        if(listaMeses.getSelectedItem() == "Febrero") {
            diasCompleto(28);
        } else if(listaMeses.getSelectedItem() == "Enero" || listaMeses.getSelectedItem() == "Marzo" || listaMeses.getSelectedItem() == "Mayo" || listaMeses.getSelectedItem() == "Julio" || listaMeses.getSelectedItem() == "Agosto" || listaMeses.getSelectedItem() == "Octubre" || listaMeses.getSelectedItem() == "Diciembre") {
            diasCompleto(31);
        } else {
            diasCompleto(30);
        }
    }

    public void completarDiasMesActual() {
        if(listaMeses.getSelectedItem() == "Enero") {
            diasMesActual(28);
        } else if(listaMeses.getSelectedItem() == "Enero" || listaMeses.getSelectedItem() == "Marzo" || listaMeses.getSelectedItem() == "Mayo" || listaMeses.getSelectedItem() == "Julio" || listaMeses.getSelectedItem() == "Agosto" || listaMeses.getSelectedItem() == "Octubre" || listaMeses.getSelectedItem() == "Diciembre") {
            diasMesActual(31);
        } else {
            diasMesActual(30);
        }
    }

    public void diasMesActual(int diasDelMes) {
        for(int i = calendario.get(Calendar.DATE); i <= diasDelMes; i++) {
            dias.add(i);
        }
    }

    public void diasCompleto(int diasDelMes) {
        for(int i = 1; i <= diasDelMes; i++) {
            dias.add(i);
        }
    }

    public String transformarMesEnString(int numeroMes) {
        String mes = "";

        switch (numeroMes) {
            case 0:
                mes = "Enero";
                break;
            case 1:
                mes = "Febrero";
                break;
            case 2:
                mes = "Marzo";
                break;
            case 3:
                mes = "Abril";
                break;
            case 4:
                mes = "Mayo";
                break;
            case 5:
                mes = "Junio";
                break;
            case 6:
                mes = "Julio";
                break;
            case 7:
                mes = "Agosto";
                break;
            case 8:
                mes = "Septiembre";
                break;
            case 9:
                mes = "Octubre";
                break;
            case 10:
                mes = "Noviembre";
                break;
            case 11:
                mes = "Diciembre";
                break;
        }
        return mes;
    }

    public int transformarMesEnInt(String mes) {
        int numeroMes = -1;

        switch (mes) {
            case "Enero":
                numeroMes = 0;
                break;
            case "Febrero":
                numeroMes = 1;
                break;
            case "Marzo":
                numeroMes = 2;
                break;
            case "Abril":
                numeroMes = 3;
                break;
            case "Mayo":
                numeroMes = 4;
                break;
            case "Junio":
                numeroMes = 5;
                break;
            case "Julio":
                numeroMes = 6;
                break;
            case "Agosto":
                numeroMes = 7;
                break;
            case "Septiempre":
                numeroMes = 8;
                break;
            case "Octuble":
                numeroMes = 9;
                break;
            case "Noviembre":
                numeroMes = 10;
                break;
            case "Diciembre":
                numeroMes = 11;
                break;
        }
        return numeroMes;
    }

    public Ciudad transformarCiudadSeleccionada(String ciudadSeleccionada) {
        Ciudad ciudad = null;
        switch (ciudadSeleccionada) {
            case "Buenos Aires":
                ciudad = Ciudad.BUENOS_AIRES;
                break;
            case "Cordoba":
                ciudad = Ciudad.CORDOBA;
                break;
            case "Montevideo":
                ciudad = Ciudad.MONTEVIDEO;
                break;
            case "Santiago":
                ciudad = Ciudad.SANTIAGO;
                break;
        }

        return ciudad;
    }

    public void modificarTabla() {
        limpiarTabla();
        reservaSeleccionada = null;
        //botonConfirmar.setEnabled(false);
        agregarFilaJTable();
    }


    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Pepe", "Gomez", "35123456", 29, "pepegomez@gmail.com", "123456");
        ReservasAdmin usuariosAdmin = new ReservasAdmin(usuario);
        usuariosAdmin.setVisible(true);
    }
}
