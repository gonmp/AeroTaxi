package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registro extends JFrame {

    private JPanel panelInicial;
    JTextField cajaTextoNuevoDni;
    JPasswordField cajaTextoNuevaContrasenia;
    JPasswordField cajaTextoConfirmarContrasenia;
    JTextField cajaTextoNombre;
    JTextField cajaTextoApellido;
    JTextField cajaTextoEdad;
    JTextField cajaTextoEmail;

    JLabel etiquetaError;

    List<JTextField> cajasTexto;

    control.Registro registro;

    public Registro() {

        registro = new control.Registro();

        this.setBounds(100, 60, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentesRegistro();

        cajasTexto = new ArrayList<JTextField>();
        crearArregloCajaTexto();
        
    }

    private void iniciarComponentesRegistro(){

        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarCajasTexto();
        colocarRadioBotones();

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);
    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Registro de usuario :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaDni = new JLabel("DNI :");
        etiquetaDni.setBounds(15, 60, 400, 50);
        etiquetaDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaDni);

        JLabel etiquetaContraseña = new JLabel("Contraseña :");
        etiquetaContraseña.setBounds(15, 120, 400, 50);
        etiquetaContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaContraseña);

        JLabel etiquetaRepetirContraseña = new JLabel("Repetir Contraseña :");
        etiquetaRepetirContraseña.setBounds(15, 180, 400, 50);
        etiquetaRepetirContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaRepetirContraseña);

        JLabel etiquetaNombre = new JLabel("Nombre :");
        etiquetaNombre.setBounds(430, 60, 400, 50);
        etiquetaNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaNombre);

        JLabel etiquetaApellido = new JLabel("Apellido :");
        etiquetaApellido.setBounds(430, 120, 400, 50);
        etiquetaApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaApellido);

        JLabel etiquetaEdad = new JLabel("Edad :");
        etiquetaEdad.setBounds(430, 180, 400, 50);
        etiquetaEdad.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaEdad);

        JLabel etiquetaEmail = new JLabel("Correo :");
        etiquetaEmail.setBounds(430, 240, 400, 50);
        etiquetaEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaEmail);

        etiquetaError = new JLabel("");
        etiquetaError.setBounds(280, 300, 400, 50);
        etiquetaError.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaError.setForeground(Color.RED);
        panelInicial.add(etiquetaError);
    }

    private void colocarBotones(){

        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBounds(90, 400, 120, 40);
        botonRegistrar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonRegistrarClick(e);
            }
        });
        panelInicial.add(botonRegistrar);

        JButton botonLogin = new JButton("Ya estoy registrado");
        botonLogin.setBounds(280, 400, 200, 40);
        botonLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonLoginClick(e);
            }
        });
        panelInicial.add(botonLogin);

        JButton botonSalir = new JButton("Salir");
        botonSalir.setBounds(565, 400, 120, 40);
        botonSalir.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonSalirClick(e);
            }
        });
        panelInicial.add(botonSalir);
    }

    private void colocarCajasTexto(){

        cajaTextoNuevoDni = new JTextField();
        cajaTextoNuevoDni.setBounds(200, 60, 180, 40);
        panelInicial.add(cajaTextoNuevoDni);

        cajaTextoNuevaContrasenia = new JPasswordField();
        cajaTextoNuevaContrasenia.setBounds(200, 120, 180, 40);
        panelInicial.add(cajaTextoNuevaContrasenia);

        cajaTextoConfirmarContrasenia = new JPasswordField();
        cajaTextoConfirmarContrasenia.setBounds(200, 180, 180, 40);
        panelInicial.add(cajaTextoConfirmarContrasenia);

        cajaTextoNombre = new JTextField();
        cajaTextoNombre.setBounds(520, 60, 200, 40);
        panelInicial.add(cajaTextoNombre);

        cajaTextoApellido = new JTextField();
        cajaTextoApellido.setBounds(520, 120, 200, 40);
        panelInicial.add(cajaTextoApellido);

        cajaTextoEdad = new JTextField();
        cajaTextoEdad.setBounds(520, 180, 200, 40);
        panelInicial.add(cajaTextoEdad);

        cajaTextoEmail = new JTextField();
        cajaTextoEmail.setBounds(520, 240, 200, 40);
        panelInicial.add(cajaTextoEmail);

    }

    private void colocarRadioBotones(){

        JRadioButton radioBotonAdmin = new JRadioButton("Juro que no soy un robot");
        radioBotonAdmin.setBounds(15, 240, 200, 40);
        panelInicial.add(radioBotonAdmin);

        JRadioButton radioBotonTerminos = new JRadioButton("Acepto terminos y condiciones");
        radioBotonTerminos.setBounds(15, 300, 200, 40);
        panelInicial.add(radioBotonTerminos);
    }

    public void crearArregloCajaTexto() {
        cajasTexto.add(cajaTextoNombre);
        cajasTexto.add(cajaTextoApellido);
        cajasTexto.add(cajaTextoNuevaContrasenia);
        cajasTexto.add(cajaTextoConfirmarContrasenia);
        cajasTexto.add(cajaTextoEdad);
        cajasTexto.add(cajaTextoEmail);
        cajasTexto.add(cajaTextoNuevoDni);
    }

    public static void main(String[] args) {
        Registro ventania2 = new Registro();
        ventania2.setVisible(true);
    }

    public void botonLoginClick(MouseEvent e) {
        this.dispose();
        Login ventana = new Login();
        ventana.setVisible(true);
    }

    public void botonRegistrarClick(MouseEvent e) {
        //Debemos chequear que todos los campos esten completos
        if(hayCamposVacios()) {
            etiquetaError.setText("Todos los campos deben estar completos");
            return;
        }

        //Debemos chequear que en todos los campos se haya ingresado informacion acorde a lo solicitado
        if(!comprobarEmail()) {
            etiquetaError.setText("Debe ingresar un email valido");
            return;
        }

        if(!comprobarEdad()) {
            etiquetaError.setText("La edad ingresada debe ser un número");
            return;
        }

        if(!comprobarContrasenias()) {
            etiquetaError.setText("Las contraseñas no coinciden");
            return;
        }

        //Debemos verificar que el usuario no exista
        if(registro.verificarUsuarioExistente(cajaTextoNuevoDni.getText())) {
            etiquetaError.setText("El usuario ya existe, aprete login para loguearse");
            return;
        }

        //Debemos crear el usuario y almacenarlo
        registro.registrar(cajaTextoNombre.getText(), cajaTextoApellido.getText(), cajaTextoNuevoDni.getText(), Integer.parseInt(cajaTextoEdad.getText()), cajaTextoEmail.getText(), cajaTextoNuevaContrasenia.getText());
    }

    public void botonSalirClick(MouseEvent e) {
        System.exit(0);
    }

    public void comprobarCamposVacios() {
        if(hayCamposVacios()) {
            etiquetaError.setText("Todos los campos deben estar completos");
        }
    }

    public boolean hayCamposVacios() {
        boolean camposVacios = false;
        Iterator<JTextField> iterador = cajasTexto.iterator();
        JTextField aux;
        while(iterador.hasNext() && !camposVacios) {
            aux = iterador.next();
            if(aux.getText().equals("")) {
                camposVacios = true;
            }
        }
        return  camposVacios;
    }

    public boolean comprobarEmail() {
        boolean esEmail = true;
        String email = cajaTextoEmail.getText();
        Integer posArroba = email.indexOf('@');
        Integer posCom = email.indexOf(".com");
        if(posArroba.equals(-1) || posCom.equals(-1)) {
            esEmail = false;
        }
        return esEmail;
    }

    public boolean comprobarEdad() {
        boolean esNumero = true;
        try {
            int edad = Integer.parseInt(cajaTextoEdad.getText());
        } catch (NumberFormatException numberFormat) {
            esNumero = false;
        }
        return esNumero;
    }

    public boolean comprobarContrasenias() {
        boolean contraseniasIguales = false;
        if(cajaTextoNuevaContrasenia.getText().equals(cajaTextoConfirmarContrasenia.getText())) {
            contraseniasIguales = true;
        }
        return contraseniasIguales;
    }
}
