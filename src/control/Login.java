package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import modelos.Usuario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Login {

    private Gson gson;
    private GestorArchivoUsuarios gestorArchivoUsuarios = new GestorArchivoUsuarios();

    public Login() {
        gson = new Gson();
    }

    public Usuario buscarUsuario(String dni) {
        Usuario usuarioBuscado = gestorArchivoUsuarios.buscarUsuario(dni);
        return usuarioBuscado;
    }

    public boolean comprobarConstrasenia(Usuario usuario, String contrasenia) {
        return usuario.getContrasenia().equals(contrasenia);
    }

    /*public Usuario loguearUsuario() {

    }*/

    public static void main(String[] args) {
        Usuario usuarioALoguear;
        Login login = new Login();
        usuarioALoguear = login.buscarUsuario("78945611");

        if(usuarioALoguear != null) {
            if(login.comprobarConstrasenia(usuarioALoguear, "123456")) {
                System.out.println(usuarioALoguear.toString());
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
}
