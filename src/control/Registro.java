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

    private Gson gson;
    private GestorArchivoUsuarios gestorArchivoUsuarios = new GestorArchivoUsuarios();

    public Registro() {
        gson = new Gson();
    }

    public boolean verificarUsuarioExistente(String dni) {
        boolean existeUsuario = false;
        if(gestorArchivoUsuarios.buscarUsuario(dni) != null) {
            existeUsuario = true;
        }
        return  existeUsuario;
    }

    public Usuario crearUsuario(String nombre, String apellido, String dni, int edad, String email, String contrasenia) {

        Usuario nuevoUsuario = new Usuario(nombre, apellido, dni, edad, email, contrasenia);
        return nuevoUsuario;
    }

    public void registrarUsuario(Usuario usuario){
        gestorArchivoUsuarios.agregarUsuario(usuario);
    }

    public void registrar(String nombre, String apellido, String dni, int edad, String email, String contrasenia) {
        registrarUsuario(crearUsuario(nombre, apellido, dni, edad, email, contrasenia));
    }


    public static void main(String[] args) {

        Registro registro = new Registro();
        Usuario nuevoUsuario = registro.crearUsuario("Gonzalo", "Perelstein", "78945611", 29, "gonzaperelsteinl@gmail.com", "123456");
        registro.registrarUsuario(nuevoUsuario);
        //Usuario nuevoUsuarionew = new Usuario("Juan", "Perelstein", "35971937", 29, "gmperelstein@gmail.com", "123456");

    }
}
