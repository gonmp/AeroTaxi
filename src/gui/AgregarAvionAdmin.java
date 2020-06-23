package gui;

import control.ReservarVuelo;
import modelos.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class AgregarAvionAdmin extends JFrame {
    /*private JPanel panelInicial;

    private String[] propulsion = {"Buenos Aires", "Cordoba", "Santiago", "Montevideo"};
    private List<String> destinos;
    private String[] categorias = {"Gold", "Silver", "Bronze"};
    private String[] booleanos = {"SI", "NO"};
    private List<Integer> anios;
    private List<String> meses;
    private List<Integer> dias;
    private List<Integer> horas;
    JTable listadoVuelos;
    DefaultTableModel model;

    ReservarVuelo reservarVuelo;
    Reserva reservaSeleccionada;

    List<Avion> avionesPosibles;
    List<Reserva> reservasPosibles;

    JComboBox listaAnios;
    JComboBox listaMeses;
    JComboBox listaDias;
    JComboBox listaHoras;
    JComboBox listaOrigenes;
    JComboBox listaDestinos;
    JSpinner spinnerPasajeros;
    JComboBox listaCategoriaAvion;

    JButton botonConfirmar;

    Calendar calendario;

    Usuario usuarioLogueado;

    int anioSeleccionado;
    int mesSeleccionado;
    int diaSeleccionado;
    int horaSeleccionada;
    Ciudad origenSeleccionado;
    Ciudad destinoSeleccionado;
    int cantidadDePasajerosSeleccionado;
    String categoriaAvionSeleccionada;

    public AgregarAvionAdmin(Usuario usuarioLogueado){


        this.usuarioLogueado = usuarioLogueado;

        calendario = Calendar.getInstance();

        destinos = new ArrayList<String>();

        anios = new ArrayList<>();
        meses = new ArrayList<>();
        dias = new ArrayList<>();
        horas = new ArrayList<>();

        avionesPosibles = new ArrayList<Avion>();
        reservasPosibles = new ArrayList<Reserva>();

        completarAnios();

        reservarVuelo = new ReservarVuelo();

        this.setBounds(100, 60, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentesSolicitud();

        //listadoVuelos.

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Categoria");
        model.addColumn("WiFi");
        model.addColumn("Servicio de catering");
        model.addColumn("Precio");
        modificarTabla();
        listadoVuelos.setModel(model);
    }

    private void iniciarComponentesSolicitud(){

        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarSpinner();
        //colocarCajasTexto();
        //colocarRadioBotones();
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

        JLabel etiquetaHora = new JLabel("Hora :");
        etiquetaHora.setBounds(540, 50, 400, 50);
        etiquetaHora.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaHora);

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

        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(500, 500, 120, 40);
        botonConfirmar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonConfirmar.setEnabled(false);
        botonConfirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(reservaSeleccionada != null) {
                    reservarVuelo.reservarVuelo(reservaSeleccionada);
                    botonConfirmarClick(e);
                }
            }
        });
        panelInicial.add(botonConfirmar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(645, 500, 120, 40);
        botonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonCancelarClick();
            }
        });
        panelInicial.add(botonCancelar);

    }

    private void colocarCajasTexto(){

        JTextField cajaTextoCantidadPas = new JTextField();
        cajaTextoCantidadPas.setBounds(280, 160, 160, 30);
        cajaTextoCantidadPas.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                agregarFilaJTable();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                limpiarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                limpiarTabla();
                agregarFilaJTable();
            }
        });
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

        listaAnios = new JComboBox(anios.toArray());
        listaAnios.setBounds(70, 60, 100, 30);
        listaAnios.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                listaMeses.removeAllItems();
                completarMeses();
                agregarMesesListaMeses();

                listaHoras.removeAllItems();
                completarHoras();
                agregarHorasListaHoras();

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

                listaHoras.removeAllItems();
                completarHoras();
                agregarHorasListaHoras();

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
                listaHoras.removeAllItems();
                completarHoras();
                agregarHorasListaHoras();

                modificarTabla();
            }
        });
        panelInicial.add(listaDias);

        completarHoras();
        listaHoras = new JComboBox(horas.toArray());
        listaHoras.setBounds(620, 60, 100, 30);
        listaHoras.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                modificarTabla();
            }
        });
        panelInicial.add(listaHoras);

        listaOrigenes = new JComboBox(origenes);
        listaOrigenes.setBounds(279, 105, 165, 30);
        listaOrigenes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                listaDestinos.removeAllItems();
                modificarDestinos();
                modificarListaDestinos();
                listaDestinos.setSelectedIndex(0);
                modificarTabla();
            }
        });
        panelInicial.add(listaOrigenes);

        modificarDestinos();
        listaDestinos = new JComboBox(destinos.toArray());
        listaDestinos.setBounds(610, 105, 165, 30);
        listaDestinos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                modificarTabla();
            }
        });
        panelInicial.add(listaDestinos);

        listaCategoriaAvion = new JComboBox(categorias);
        listaCategoriaAvion.setBounds(280, 226, 165, 30);
        listaCategoriaAvion.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                modificarTabla();
            }
        });
        panelInicial.add(listaCategoriaAvion);

    }

    private void colocarAreaTexto(){
        listadoVuelos = new JTable();
        listadoVuelos.setBounds(0, 0, 700, 180);
        listadoVuelos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = listadoVuelos.rowAtPoint(e.getPoint());
                reservaSeleccionada = reservasPosibles.get(seleccion);
                System.out.println(reservaSeleccionada.toString());
                if(reservaSeleccionada != null) {
                    botonConfirmar.setEnabled(true);
                }
            }
        });
        JScrollPane barraDeDesplazamiento = new JScrollPane(listadoVuelos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barraDeDesplazamiento.setBounds(43, 280, 700, 180);
        panelInicial.add(barraDeDesplazamiento);

    }

    public void colocarSpinner() {
        SpinnerModel modelo = new SpinnerNumberModel(1, 1, 20, 1);
        spinnerPasajeros = new JSpinner(modelo);
        spinnerPasajeros.setBounds(280, 160, 160, 30);
        spinnerPasajeros.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                modificarTabla();
            }
        });
        panelInicial.add(spinnerPasajeros);
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

    public void agregarHorasListaHoras() {
        Iterator<Integer> iteradorHoras = horas.iterator();
        int aux;
        while(iteradorHoras.hasNext()) {
            aux = iteradorHoras.next();
            listaHoras.addItem(aux);
        }
    }

    public void completarHoras() {
        horas.clear();
        if(listaDias.getSelectedItem() != null) {
            if (listaAnios.getSelectedItem().equals(calendario.get(Calendar.YEAR)) && listaMeses.getSelectedItem().equals(transformarMesEnString(calendario.get(Calendar.MONTH))) && listaDias.getSelectedItem().equals(calendario.get(Calendar.DATE))) {
                horasDiaActual();
            } else {
                horasCompleto();
            }
        }
    }

    public void horasDiaActual() {
        for(int i = calendario.get(Calendar.HOUR) + 2; i <= 24; i++) {
            horas.add(i);
        }
    }

    public void horasCompleto() {
        for(int i = 1; i <= 24; i++) {
            horas.add(i);
        }
    }

    public void modificarListaDestinos() {
        Iterator<String> iteradorDestinos = destinos.iterator();
        String aux;
        while(iteradorDestinos.hasNext()) {
            aux = iteradorDestinos.next();
            listaDestinos.addItem(aux);
        }
    }

    public void modificarDestinos() {
        destinos.clear();
        for(int i = 0; i < origenes.length; i++){
            if(!origenes[i].equals(listaOrigenes.getSelectedItem())) {
                destinos.add(origenes[i]);
            }
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

    public CategoriaAvion transformarCategoriaSeleccionada(String categoriaSeleccionada) {
        CategoriaAvion categoria = null;
        switch (categoriaSeleccionada) {
            case "Gold":
                categoria = CategoriaAvion.GOLD;
                break;
            case "Silver":
                categoria = CategoriaAvion.SILVER;
                break;
            case "Bronze":
                categoria = CategoriaAvion.BRONZE;
                break;
        }

        return categoria;
    }

    /*public CategoriaAvion transformarCategoriaSeleccionada(String categoriaSeleccionada) {
        CategoriaAvion categoria = null;
        switch (categoriaSeleccionada) {
            case "":
                ciudad = Ciudad.BUENOS_AIRES;
                break;
            case "Cordoba":
                ciudad = Ciudad.CORDOBA;
                break;
            case "Montevideo":
                ciudad = Ciudad.MONTEVIDEO;
                break;
            case "Santiango":
                ciudad = Ciudad.SANTIAGO;
                break;
        }

        return ciudad;
    }*/

    /*public void buscarAvionesPosibles() {
        avionesPosibles.clear();
        if(listaCategoriaAvion.getSelectedItem().equals("Todas")) {
            avionesPosibles = reservarVuelo.filtrarAviones((Integer) spinnerPasajeros.getValue(), (Integer) listaAnios.getSelectedItem(), transformarMesEnInt((String) listaMeses.getSelectedItem()), (Integer) listaDias.getSelectedItem());
        } else {
            avionesPosibles = reservarVuelo.filtrarAviones((Integer) spinnerPasajeros.getValue(), (Integer) listaAnios.getSelectedItem(), transformarMesEnInt((String) listaMeses.getSelectedItem()), (Integer) listaDias.getSelectedItem(), transformarCategoriaSeleccionada((String) listaCategoriaAvion.getSelectedItem()));
        }
    }

    public void generarReservasPosibles() {
        reservasPosibles.clear();
        Iterator<Avion> iteratorAviones = avionesPosibles.iterator();
        Avion aux;
        while(iteratorAviones.hasNext()) {
            aux = iteratorAviones.next();
            reservasPosibles.add(reservarVuelo.crearReserva((Integer) listaAnios.getSelectedItem(), transformarMesEnInt((String) listaMeses.getSelectedItem()), (Integer) listaDias.getSelectedItem(), (Integer) listaHoras.getSelectedItem(), (Integer) spinnerPasajeros.getValue(), transformarCiudadSeleccionada((String) listaOrigenes.getSelectedItem()), transformarCiudadSeleccionada((String) listaDestinos.getSelectedItem()), usuarioLogueado, aux));
        }
    }

    public void modificarTabla() {
        limpiarTabla();
        reservaSeleccionada = null;
        botonConfirmar.setEnabled(false);
        agregarFilaJTable();
    }

    public void tomarTodosLosDatos() {
        anioSeleccionado = (int) listaAnios.getSelectedItem();
        mesSeleccionado = transformarMesEnInt((String) listaMeses.getSelectedItem());
        diaSeleccionado = (int) listaDias.getSelectedItem();
        horaSeleccionada = (int) listaHoras.getSelectedItem();
        origenSeleccionado = transformarCiudadSeleccionada((String) listaOrigenes.getSelectedItem());
        destinoSeleccionado = transformarCiudadSeleccionada((String) listaDestinos.getSelectedItem());
        cantidadDePasajerosSeleccionado = (int) spinnerPasajeros.getValue();
        categoriaAvionSeleccionada = (String) listaCategoriaAvion.getSelectedItem();
    }

    public void agregarFilaJTable() {
        if(listaAnios.getSelectedItem() == null || listaMeses.getSelectedItem() == null || listaDias.getSelectedItem() == null || listaHoras.getSelectedItem() == null || listaOrigenes.getSelectedItem() == null || listaDestinos.getSelectedItem() == null || spinnerPasajeros.getValue() == null){
            return;
        }
        buscarAvionesPosibles();
        generarReservasPosibles();
        limpiarTabla();
        Object fila[] = new Object[4];
        Iterator<Reserva> reservaIterator = reservasPosibles.iterator();
        int i = 0;
        Reserva aux;
        while(reservaIterator.hasNext()) {
            aux = reservaIterator.next();
            fila[0] = aux.getAvion().getCategoria();
            fila[1] = convertirBooleanAString(aux.getAvion().tieneWifi());
            fila[2] = convertirBooleanAString(aux.getAvion().tieneCatering());
            fila[3] = aux.calcularCosto();
            model.addRow(fila);
            i++;
        }
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

    public void limpiarTabla() {
        model.setRowCount(0);
    }

    public void botonConfirmarClick(MouseEvent e) {
        this.dispose();
        ReservaExitosa reservaExitosa = new ReservaExitosa(usuarioLogueado);
        reservaExitosa.setVisible(true);
    }

    public void botonCancelarClick() {
        this.dispose();
        MenuUsuario menuUsuario = new MenuUsuario(usuarioLogueado);
        menuUsuario.setVisible(true);
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Pepe", "Gomez", "35123456", 29, "pepegomez@gmail.com", "123456");
        AgregarAvionAdmin agregarAvionAdmin = new AgregarAvionAdmin(usuario);
        agregarAvionAdmin.setVisible(true);
    }*/
}
