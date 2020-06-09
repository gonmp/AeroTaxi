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

    public final static String nombreArchivo = "Usuarios.json";
    private Gson gson;
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();;

    public Login() {
        gson = new Gson();
        leerUsuarios();
    }

    public Usuario buscarUsuario(String dni) {
        Usuario usuarioBuscado = null;
        Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
        Usuario aux;
        while(iteradorUsuarios.hasNext() && usuarioBuscado == null) {
            aux = iteradorUsuarios.next();
            if(aux.getDni().equals(dni)) {
                usuarioBuscado = aux;
            }
        }
        return usuarioBuscado;
    }

    public boolean comprobarConstrasenia(Usuario usuario, String contrasenia) {
        return usuario.getContrasenia().equals(contrasenia);
    }

    /*public Usuario loguearUsuario() {

    }*/

    public void leerUsuarios() {
        final Type tipoListaUsuarios = new TypeToken<List<Usuario>>(){}.getType();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(nombreArchivo));
            usuarios = gson.fromJson(jsonReader, tipoListaUsuarios);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
