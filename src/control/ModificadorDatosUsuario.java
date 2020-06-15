package control;

import modelos.Usuario;

public class ModificadorDatosUsuario {

    public Usuario usuarioModificar;
    private GestorArchivoUsuarios gestorArchivoUsuarios = new GestorArchivoUsuarios();

    public ModificadorDatosUsuario(Usuario usuarioModificar) {
        this.usuarioModificar = usuarioModificar;
    }

    public Usuario ModificarUsuario(String nombre, String apellido, String dni, int edad, String email) {
        Usuario nuevoUsuario = new Usuario(nombre, apellido, dni, edad, email, usuarioModificar.getContrasenia());
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), nuevoUsuario);

        return nuevoUsuario;
    }

}
