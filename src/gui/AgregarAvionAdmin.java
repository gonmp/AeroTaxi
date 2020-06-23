package gui;

import control.DatosAvion;
import control.ReservarVuelo;
import modelos.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    private JPanel contentPane;
    private JTextField cajaCombustible;
    private JTextField cajaKilometros;
    private JTextField cajaVelocidad;
    private JLabel etiquetaError;
    private JComboBox listaCategorias;
    private JComboBox listaPropulsion;
    private JComboBox listaWifi;
    private JComboBox listaCatering;
    private JSpinner spinnerPasajeros;

    private List<JTextField> cajasDeTexto;

    private String[] categorias = {"Gold", "Silver", "Bronze"};
    private String[] propulsiones = {"Motor a hélice", "Motor a pistones", "Motor a reacción"};
    private String[] booleano = {"SI", "NO"};

    private DatosAvion datosAvion;

    private Usuario usuarioLogueado;

    public AgregarAvionAdmin(Usuario usuarioLogueado) {
        datosAvion = new DatosAvion();

        this.usuarioLogueado = usuarioLogueado;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 597, 811);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentes();

        cajasDeTexto = new ArrayList<JTextField>();
        crearArregloCajasDeTexto();
    }

    public void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarCajasDeTexto();
        colocarListaDesplegable();
        colocarSpinner();
    }

    public void colocarPanel(){
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    public void colocarEtiquetas() {
        JLabel titulo = new JLabel("Agregar avi\u00F3n");
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        titulo.setBounds(41, 11, 146, 34);
        contentPane.add(titulo);

        JLabel etiquetaCategoria = new JLabel("Categor\u00EDa :");
        etiquetaCategoria.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaCategoria.setBounds(41, 69, 113, 40);
        contentPane.add(etiquetaCategoria);

        JLabel etiquetaCombustible = new JLabel("Capacidad de combustible :");
        etiquetaCombustible.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaCombustible.setBounds(41, 140, 244, 26);
        contentPane.add(etiquetaCombustible);

        JLabel etiquetaKilometros = new JLabel("Costo por kilometro :");
        etiquetaKilometros.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaKilometros.setBounds(42, 198, 201, 34);
        contentPane.add(etiquetaKilometros);

        JLabel etiquetaPasajeros = new JLabel("Capacidad de pasajeros :");
        etiquetaPasajeros.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaPasajeros.setBounds(41, 263, 244, 34);
        contentPane.add(etiquetaPasajeros);

        JLabel etiquetaVelocidad = new JLabel("Velocidad m\u00E1xima (km/h) :");
        etiquetaVelocidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaVelocidad.setBounds(41, 336, 244, 34);
        contentPane.add(etiquetaVelocidad);

        JLabel etiquetaPropulsion = new JLabel("Propulsi\u00F3n :");
        etiquetaPropulsion.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaPropulsion.setBounds(41, 408, 146, 26);
        contentPane.add(etiquetaPropulsion);

        JLabel etiquetaWiFi = new JLabel("Tiene WiFi :");
        etiquetaWiFi.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaWiFi.setBounds(41, 465, 155, 34);
        contentPane.add(etiquetaWiFi);

        JLabel etiquetaCatering = new JLabel("Tiene catering :");
        etiquetaCatering.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaCatering.setBounds(41, 538, 155, 26);
        contentPane.add(etiquetaCatering);

        etiquetaError = new JLabel();
        etiquetaError.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        etiquetaError.setBounds(96, 614, 400, 26);
        etiquetaError.setForeground(Color.RED);
        contentPane.add(etiquetaError);
    }

    public void colocarCajasDeTexto() {
        cajaCombustible = new JTextField();
        cajaCombustible.setBounds(401, 146, 86, 20);
        contentPane.add(cajaCombustible);
        cajaCombustible.setColumns(10);

        cajaKilometros = new JTextField();
        cajaKilometros.setBounds(401, 208, 86, 20);
        contentPane.add(cajaKilometros);
        cajaKilometros.setColumns(10);

        cajaVelocidad = new JTextField();
        cajaVelocidad.setBounds(401, 346, 86, 20);
        contentPane.add(cajaVelocidad);
        cajaVelocidad.setColumns(10);
    }

    public void colocarListaDesplegable() {
        listaCategorias = new JComboBox(categorias);
        listaCategorias.setBounds(401, 82, 86, 20);
        listaCategorias.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                asignarCampoWifi();
                asignarCampoCatering();
            }
        });
        contentPane.add(listaCategorias);

        listaWifi = new JComboBox(booleano);
        listaWifi.setBounds(401, 475, 86, 20);
        contentPane.add(listaWifi);

        listaCatering = new JComboBox(booleano);
        listaCatering.setBounds(401, 544, 86, 20);
        contentPane.add(listaCatering);

        listaPropulsion = new JComboBox(propulsiones);
        listaPropulsion.setBounds(401, 414, 86, 20);
        contentPane.add(listaPropulsion);
    }

    public void colocarBotones() {
        JButton botonAgregarAvion = new JButton("Cargar avi\u00F3n");
        botonAgregarAvion.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAgregarAvion.setBounds(96, 676, 146, 34);
        botonAgregarAvion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAgregarAvionClick();
            }
        });
        contentPane.add(botonAgregarAvion);

        JButton botonAtras = new JButton("Atr\u00E1s");
        botonAtras.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonAtras.setBounds(320, 676, 141, 34);
        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonAtrasClick();
            }
        });
        contentPane.add(botonAtras);
    }

    public void colocarSpinner() {
        SpinnerModel modelo = new SpinnerNumberModel(1, 1, 20, 1);
        spinnerPasajeros = new JSpinner(modelo);
        spinnerPasajeros.setBounds(401, 273, 86, 20);
        contentPane.add(spinnerPasajeros);
    }

    public boolean comprobarCombustible() {
        boolean esNumero = true;
        try {
            int edad = Integer.parseInt(cajaCombustible.getText());
        } catch (NumberFormatException numberFormat) {
            esNumero = false;
        }
        return esNumero;
    }

    public boolean comprobarKilometros() {
        boolean esNumero = true;
        try {
            int edad = Integer.parseInt(cajaKilometros.getText());
        } catch (NumberFormatException numberFormat) {
            esNumero = false;
        }
        return esNumero;
    }

    public boolean comprobarVelocidad() {
        boolean esNumero = true;
        try {
            int edad = Integer.parseInt(cajaVelocidad.getText());
        } catch (NumberFormatException numberFormat) {
            esNumero = false;
        }
        return esNumero;
    }

    public void crearArregloCajasDeTexto() {
        cajasDeTexto.add(cajaCombustible);
        cajasDeTexto.add(cajaKilometros);
        cajasDeTexto.add(cajaVelocidad);
    }

    public boolean hayCamposVacios() {
        boolean camposVacios = false;
        Iterator<JTextField> iterador = cajasDeTexto.iterator();
        JTextField aux;
        while(iterador.hasNext() && !camposVacios) {
            aux = iterador.next();
            if(aux.getText().equals("")) {
                camposVacios = true;
            }
        }
        return  camposVacios;
    }

    public void asignarCampoWifi() {
        if(!listaCategorias.getSelectedItem().equals("Gold")) {
            listaWifi.setSelectedItem(listaWifi.getModel().getElementAt(1));
            listaWifi.setEnabled(false);
        } else {
            listaWifi.setSelectedIndex(0);
            listaWifi.setEnabled(true);
        }
    }

    public void asignarCampoCatering() {
        if(!listaCategorias.getSelectedItem().equals("Gold")) {
            listaCatering.setSelectedItem(listaWifi.getModel().getElementAt(1));
            listaCatering.setEnabled(false);
        } else {
            listaCatering.setSelectedIndex(0);
            listaCatering.setEnabled(true);
        }
    }

    public void botonAgregarAvionClick() {
        if(hayCamposVacios()) {
            etiquetaError.setText("Todos los campos deben estar completos");
            return;
        }

        if(!comprobarCombustible()) {
            etiquetaError.setText("La capacidad de combustible debe ser un número entero");
            return;
        }

        if(!comprobarKilometros()) {
            etiquetaError.setText("El costo por kilometro debe ser un número entero");
            return;
        }

        if(!comprobarVelocidad()) {
            etiquetaError.setText("La velocidad debe ser un número entero");
            return;
        }

        datosAvion.agregarAvion(transformarCategoriaSeleccionada((String) listaCategorias.getSelectedItem()), Integer.parseInt(cajaCombustible.getText()), Integer.parseInt(cajaKilometros.getText()), (Integer) spinnerPasajeros.getValue(), Integer.parseInt(cajaVelocidad.getText()), transformarPropulsionSeleccionada((String) listaPropulsion.getSelectedItem()), convertirStringABooleano((String) listaWifi.getSelectedItem()), convertirStringABooleano((String) listaCatering.getSelectedItem()));
        this.dispose();
        AvionAgregadoExito avionAgregadoExito = new AvionAgregadoExito(usuarioLogueado);
        avionAgregadoExito.setVisible(true);
    }

    public void botonAtrasClick() {
        this.dispose();
        MenuAdmin menuAdmin = new MenuAdmin(usuarioLogueado);
        menuAdmin.setVisible(true);
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

    public Propulsion transformarPropulsionSeleccionada(String propulsionSeleccionada) {
        Propulsion propulsion = null;
        switch (propulsionSeleccionada) {
            case "Motor a hélice":
                propulsion = Propulsion.MOTOR_A_HELICE;
                break;
            case "Motor a pistones":
                propulsion = Propulsion.MOTOR_A_PISTONES;
                break;
            case "Motor a reacción":
                propulsion = Propulsion.MOTOR_A_REACCION;
                break;
        }

        return propulsion;
    }

    public boolean convertirStringABooleano(String dato) {
        boolean booleano = true;
        if(dato.equals("NO")) {
            booleano = false;
        }
        return booleano;
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Pepe", "Gomez", "35123456", 29, "pepegomez@gmail.com", "123456");
        AgregarAvionAdmin agregarAvionAdmin = new AgregarAvionAdmin(usuario);
        agregarAvionAdmin.setVisible(true);
    }
}
