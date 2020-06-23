package control;

import modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosUsuario {

    private GestorArchivoUsuarios gestorArchivoUsuarios;

    public DatosUsuario() {
        gestorArchivoUsuarios = new GestorArchivoUsuarios();
    }

    public Usuario modificarUsuario(Usuario usuarioModificar, String nombre, String apellido, String dni, int edad, String email) {
        Usuario nuevoUsuario = new Usuario(usuarioModificar.getId(), nombre, apellido, dni, edad, email, usuarioModificar.getContrasenia());
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), nuevoUsuario);

        return nuevoUsuario;
    }

    public Usuario modificarContrasenia(Usuario usuarioModificar, String nuevaContrasenia) {
        Usuario nuevoUsuario = new Usuario(usuarioModificar.getId(), usuarioModificar.getNombre(), usuarioModificar.getApellido(), usuarioModificar.getDni(), usuarioModificar.getEdad(), usuarioModificar.getEmail(), nuevaContrasenia);
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), nuevoUsuario);

        return nuevoUsuario;
    }

    public void hacerAdmin(Usuario usuarioModificar) {
        usuarioModificar.setAdmin(true);
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), usuarioModificar);

    }

    public ArrayList<Usuario> listarTodosLosUsuarios() {
        return gestorArchivoUsuarios.getUsuarios();
    }
}
