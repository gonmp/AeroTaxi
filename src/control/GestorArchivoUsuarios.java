package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        gson = new GsonBuilder().setPrettyPrinting().create();
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

    public int buscarIndexUsuario(String dni) {
        Integer index = -1;
        Iterator<Usuario> iteradorUsuarios = usuarios.iterator();
        Usuario aux;
        int contador = 0;
        while(iteradorUsuarios.hasNext() && index.equals(-1)) {
            aux = iteradorUsuarios.next();
            contador++;
            if(aux.getDni().equals(dni)) {
                index = contador - 1;
            }
        }
        return index;
    }

    public void reemplazarUsuario(int index, Usuario nuevoUsuario) {
        usuarios.set(index, nuevoUsuario);
        try (FileWriter writer = new FileWriter(ArchivoDatos.archivoUsuarios)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public int devolverUltimosId(){
        int ultimoId = 1;
        Iterator<Usuario> iteradorUsuario = usuarios.iterator();
        Usuario aux;
        while(iteradorUsuario.hasNext()) {
            aux = iteradorUsuario.next();
            ultimoId = aux.getId();
        }
        return  ultimoId;
    }

}
