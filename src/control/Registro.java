package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import modelos.Usuario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Registro {

    public final static String nombreArchivo = "Usuarios.json";
    private Gson gson;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();;

    public Registro() {
        gson = new Gson();
    }

    public boolean verificarUsuarioExistente(String dni) {
        return true;
    }

    public Usuario crearUsuario(String nombre, String apellido, String dni, int edad, String email, String contrasenia) {

        Usuario nuevoUsuario = new Usuario(nombre, apellido, dni, edad, email, contrasenia);
        return nuevoUsuario;
    }

    public void registrarUsuario(Usuario usuario){
        leerUsuarios();
        usuarios.add(usuario);
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }*/

    public void leerUsuarios() {
        final Type tipoListaUsuarios = new TypeToken<List<Usuario>>(){}.getType();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(nombreArchivo));
            List<Usuario> usuariosJson = gson.fromJson(jsonReader, tipoListaUsuarios);
            if(usuariosJson == null) {
                usuarios = new ArrayList<Usuario>();
            } else {
                for(Usuario usuario : usuariosJson) {
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Registro registro = new Registro();
        Usuario nuevoUsuario = registro.crearUsuario("Gonzalo", "Perelstein", "78945611", 29, "gonzaperelsteinl@gmail.com", "123456");
        registro.registrarUsuario(nuevoUsuario);
        //Usuario nuevoUsuarionew = new Usuario("Juan", "Perelstein", "35971937", 29, "gmperelstein@gmail.com", "123456");

    }
}
