package gui;

import control.DatosUsuario;
import control.Registro;
import modelos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModificarPerfil extends JFrame {

    private JPanel panelInicial;
    private Usuario usuarioLogueado;
    private DatosUsuario datosUsuario;
    private Registro registro;
    private JLabel etiquetaError;

    JTextField cajaTextoNuevoDni;
    JTextField cajaTextoNuevoNombre;
    JTextField cajaTextoNuevoApellido;
    JTextField cajaTextoNuevaEdad;
    JTextField cajaTextoNuevoCorreo;

    private List<JTextField> cajasTexto;

    public ModificarPerfil(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        datosUsuario = new DatosUsuario();

        registro = new Registro();

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

    }

    private void colocarPanel(){

        panelInicial = new JPanel();
        panelInicial.setLayout(null);
        this.getContentPane().add(panelInicial);
    }

    private void colocarEtiquetas(){

        JLabel titulo = new JLabel("Datos a modificar :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

        JLabel etiquetaModDni = new JLabel("Nuevo DNI :");
        etiquetaModDni.setBounds(15, 60, 400, 50);
        etiquetaModDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModDni);

        JLabel etiquetaModNombre = new JLabel("Nuevo nombre :");
        etiquetaModNombre.setBounds(15, 110, 400, 50);
        etiquetaModNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModNombre);

        JLabel etiquetaModApellido = new JLabel("Nuevo Apellido :");
        etiquetaModApellido.setBounds(15, 160, 400, 50);
        etiquetaModApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModApellido);

        JLabel etiquetaModEdad = new JLabel("Nueva edad :");
        etiquetaModEdad.setBounds(15, 210, 400, 50);
        etiquetaModEdad.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModEdad);

        JLabel etiquetaModEmail = new JLabel("Nuevo correo :");
        etiquetaModEmail.setBounds(15, 260, 400, 50);
        etiquetaModEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        panelInicial.add(etiquetaModEmail);

        etiquetaError = new JLabel("");
        etiquetaError.setBounds(500, 350, 400, 50);
        etiquetaError.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        etiquetaError.setForeground(Color.RED);
        panelInicial.add(etiquetaError);
    }

    private void colocarCajasTexto(){

        cajaTextoNuevoDni = new JTextField();
        cajaTextoNuevoDni.setBounds(220, 65, 200, 35);
        cajaTextoNuevoDni.setText(usuarioLogueado.getDni());
        panelInicial.add(cajaTextoNuevoDni);

        cajaTextoNuevoNombre = new JTextField();
        cajaTextoNuevoNombre.setBounds(220, 115, 200, 35);
        cajaTextoNuevoNombre.setText(usuarioLogueado.getNombre());
        panelInicial.add(cajaTextoNuevoNombre);

        cajaTextoNuevoApellido = new JTextField();
        cajaTextoNuevoApellido.setBounds(220, 165, 200, 35);
        cajaTextoNuevoApellido.setText(usuarioLogueado.getApellido());
        panelInicial.add(cajaTextoNuevoApellido);

        cajaTextoNuevaEdad = new JTextField();
        cajaTextoNuevaEdad.setBounds(220, 215, 200, 35);
        cajaTextoNuevaEdad.setText(String.valueOf(usuarioLogueado.getEdad()));
        panelInicial.add(cajaTextoNuevaEdad);

        cajaTextoNuevoCorreo = new JTextField();
        cajaTextoNuevoCorreo.setBounds(220, 266, 200, 35);
        cajaTextoNuevoCorreo.setText(usuarioLogueado.getEmail());
        panelInicial.add(cajaTextoNuevoCorreo);

    }

    private void colocarRadioBotones(){

        JRadioButton radioBotonAdmin = new JRadioButton("Juro que no soy un robot");
        radioBotonAdmin.setBounds(15, 330, 200, 40);
        panelInicial.add(radioBotonAdmin);
    }

    private void colocarBotones(){

        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(500, 400, 120, 40);
        botonConfirmar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonConfirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonConfirmarClick(e);
            }
        });
        panelInicial.add(botonConfirmar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(645, 400, 120, 40);
        botonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonCancelarClick(e);
            }
        });
        panelInicial.add(botonCancelar);

    }

    public void crearArregloCajaTexto() {
        cajasTexto.add(cajaTextoNuevoNombre);
        cajasTexto.add(cajaTextoNuevoApellido);
        cajasTexto.add(cajaTextoNuevaEdad);
        cajasTexto.add(cajaTextoNuevoCorreo);
        cajasTexto.add(cajaTextoNuevoDni);
    }

    public void botonConfirmarClick(MouseEvent e) {
        if(hayCamposVacios()) {
            etiquetaError.setText("Todos los campos deben estar completos");
            return;
        }


        if(!comprobarEmail()) {
            etiquetaError.setText("Debe ingresar un email valido");
            return;
        }

        if(!comprobarEdad()) {
            etiquetaError.setText("La edad ingresada debe ser un número");
            return;
        }

        //Debemos verificar que el usuario no exista
        if(!cajaTextoNuevoDni.getText().equals(usuarioLogueado.getDni())) {
            if(registro.verificarUsuarioExistente(cajaTextoNuevoDni.getText())) {
                etiquetaError.setText("El usuario ya existe, aprete login para loguearse");
                return;
            }
        }

        //Debemos crear el usuario y almacenarlo
        Usuario usuarioModificado = datosUsuario.modificarUsuario(usuarioLogueado, cajaTextoNuevoNombre.getText(), cajaTextoNuevoApellido.getText(), cajaTextoNuevoDni.getText(), Integer.parseInt(cajaTextoNuevaEdad.getText()), cajaTextoNuevoCorreo.getText());
        this.dispose();
        MenuUsuario menuUsuario = new MenuUsuario(usuarioModificado);
        menuUsuario.setVisible(true);
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
        String email = cajaTextoNuevoCorreo.getText();
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
            int edad = Integer.parseInt(cajaTextoNuevaEdad.getText());
        } catch (NumberFormatException numberFormat) {
            esNumero = false;
        }
        return esNumero;
    }

    public void botonCancelarClick(MouseEvent e) {
        this.dispose();
        PerfilUsuario perfilUsuario = new PerfilUsuario(usuarioLogueado);
        perfilUsuario.setVisible(true);
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Gonza", "Perez", "35789456", 45, "hola@gmail.com", "123456");
        ModificarPerfil modificarPerfil = new ModificarPerfil(usuario);
        modificarPerfil.setVisible(true);
    }

}
