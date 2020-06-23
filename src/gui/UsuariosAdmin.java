package gui;

import control.DatosUsuario;
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

public class UsuariosAdmin extends JFrame {

    private JPanel panelInicial;
    private JTable listadoUsuarios;
    private JButton botonModificar;
    private JButton botonHacerAdmin;
    private Usuario usuarioSeleccionado;
    private Usuario usuarioLogueado;
    private List<Usuario> usuarios;
    private DatosUsuario datosUsuario;
    //private List<Reserva> todasLasReservas;
    private DefaultTableModel model;

    public UsuariosAdmin(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        //todasLasReservas = new ArrayList<Reserva>();
        datosUsuario = new DatosUsuario();
        this.setBounds(100, 60, 1200, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aerotaxis PepePotamo");
        iniciarComponentes();
        usuarios = new ArrayList<Usuario>();
        completarUsuarios();
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Id");
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        model.addColumn("Email");
        model.addColumn("Contraseña");
        model.addColumn("Es admin");

        listadoUsuarios.setModel(model);
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

        JLabel titulo = new JLabel("Usuarios :");
        titulo.setBounds(15, 1, 400, 50);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        panelInicial.add(titulo);

    }
    private void colocarBotones(){

        botonModificar = new JButton("Modificar usuario");
        botonModificar.setBounds(350, 400, 200, 40);
        botonModificar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonModificar.setEnabled(false);
        botonModificar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(usuarioSeleccionado != null) {
                    botonModificarClick(e);
                }
            }
        });
        panelInicial.add(botonModificar);

        botonHacerAdmin = new JButton("Hacer admin");
        botonHacerAdmin.setBounds(570, 400, 170, 40);
        botonHacerAdmin.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        botonHacerAdmin.setEnabled(false);
        botonHacerAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(usuarioSeleccionado != null) {
                    botonHacerAdminClick();
                }
            }
        });
        panelInicial.add(botonHacerAdmin);

        JButton botonAtras = new JButton("Atras");
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

        listadoUsuarios = new JTable();
        listadoUsuarios.setBounds(0, 0, 1100, 180);
        listadoUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = listadoUsuarios.rowAtPoint(e.getPoint());
                usuarioSeleccionado = usuarios.get(seleccion);
                System.out.println(usuarioSeleccionado.toString());
                if(usuarioSeleccionado != null) {
                    botonModificar.setEnabled(true);
                    botonHacerAdmin.setEnabled(true);
                }
            }
        });
        JScrollPane barraDeDesplazamiento = new JScrollPane(listadoUsuarios, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barraDeDesplazamiento.setBounds(43, 80, 1100, 280);
        panelInicial.add(barraDeDesplazamiento);

    }

    public void completarUsuarios() {
        usuarios = datosUsuario.listarTodosLosUsuarios();
    }

    public void modificarJTable() {
        usuarioSeleccionado = null;
    }

    public void agregarFilaJTable() {
        limpiarTabla();
        Object fila[] = new Object[8];
        DateFormat date = DateFormat.getDateInstance();
        Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
        Usuario aux;
        int i = 0;
        while(iteradorUsuarios.hasNext()) {
            aux = iteradorUsuarios.next();
            fila[0] = aux.getId();
            fila[1] = aux.getDni();
            fila[2] = aux.getNombre();
            fila[3] = aux.getApellido();
            fila[4] = aux.getEdad();
            fila[5] = aux.getEmail();
            fila[6] = aux.getContrasenia();
            fila[7] = convertirBooleanAString(aux.isAdmin());
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

    public void botonModificarClick(MouseEvent e) {
        this.dispose();
        ModificarPerfilAdmin modificarPerfilAdmin = new ModificarPerfilAdmin(usuarioLogueado, usuarioSeleccionado);
        modificarPerfilAdmin.setVisible(true);
    }

    public void botonHacerAdminClick() {
        datosUsuario.hacerAdmin(usuarioSeleccionado);
        this.dispose();
        TransformadoEnAdminExito transformadoEnAdminExito = new TransformadoEnAdminExito(usuarioLogueado);
        transformadoEnAdminExito.setVisible(true);
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
        UsuariosAdmin usuariosAdmin = new UsuariosAdmin(usuario);
        usuariosAdmin.setVisible(true);
    }
}
