package control;

import modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosUsuario {

    private GestorArchivoUsuarios gestorArchivoUsuarios;

    public DatosUsuario() {
        gestorArchivoUsuarios = new GestorArchivoUsuarios();
    }

    public Usuario ModificarUsuario(Usuario usuarioModificar, String nombre, String apellido, String dni, int edad, String email) {
        Usuario nuevoUsuario = new Usuario(1, nombre, apellido, dni, edad, email, usuarioModificar.getContrasenia());
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), nuevoUsuario);

        return nuevoUsuario;
    }

    public ArrayList<Usuario> listarTodosLosUsuarios() {
        return gestorArchivoUsuarios.getUsuarios();
    }
}
