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
import java.util.Iterator;
import java.util.List;

public class GestorArchivoUsuarios {

    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();;
    private Gson gson;

    public GestorArchivoUsuarios() {
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

    public void leerUsuarios() {
        final Type tipoListaUsuarios = new TypeToken<List<Usuario>>(){}.getType();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(ArchivoDatos.archivoUsuarios));
            usuarios = gson.fromJson(jsonReader, tipoListaUsuarios);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
        try (FileWriter writer = new FileWriter(ArchivoDatos.archivoUsuarios)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
