package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import modelos.Avion;
import modelos.CategoriaAvion;
import modelos.Propulsion;
import modelos.Usuario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class GestorArchivoAviones {
    public ArrayList<Avion> aviones = new ArrayList<Avion>();;
    private Gson gson;

    public GestorArchivoAviones() {
        gson = new Gson();
        leerAviones();
    }

    public Avion buscarAvion(int id) {
        Avion avionBuscado = null;
        Iterator<Avion> iteradorAviones = aviones.iterator();
        Avion aux;
        while(iteradorAviones.hasNext() && avionBuscado == null) {
            aux = iteradorAviones.next();
            if(aux.getId() == id) {
                avionBuscado = aux;
            }
        }
        return avionBuscado;
    }

    public void reemplazarAvion(int index, Avion nuevoAvion) {
        aviones.set(index, nuevoAvion);
        try (FileWriter writer = new FileWriter(ArchivoDatos.archivoAviones)) {
            gson.toJson(aviones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerAviones() {
        final Type tipoListaAviones = new TypeToken<List<Avion>>(){}.getType();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(ArchivoDatos.archivoAviones));
            aviones = gson.fromJson(jsonReader, tipoListaAviones);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void agregarAvion(Avion avion){
        aviones.add(avion);
        try (FileWriter writer = new FileWriter(ArchivoDatos.archivoAviones)) {
            gson.toJson(aviones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(ArrayList<Avion> aviones) {
        this.aviones = aviones;
    }

    public ArrayList<Avion> filtrarAviones(int cantidadDePasajeros, Calendar fecha) {
        ArrayList<Avion> avionesDisponibles = new ArrayList<Avion>();
        Iterator<Avion> iteratorAviones = aviones.iterator();
        Avion aux;
        while(iteratorAviones.hasNext()) {
            aux = iteratorAviones.next();
            if(aux.estaDiponibleFecha(fecha) && aux.getCapacidadPasajeros() >= cantidadDePasajeros) {
                avionesDisponibles.add(aux);
            }
        }
        return avionesDisponibles;
    }

    public ArrayList<Avion> filtrarAviones(int cantidadDePasajeros, Calendar fecha, CategoriaAvion categoria) {
        ArrayList<Avion> avionesDisponibles = new ArrayList<Avion>();
        Iterator<Avion> iteratorAviones = aviones.iterator();
        Avion aux;
        while(iteratorAviones.hasNext()) {
            aux = iteratorAviones.next();
            if(aux.estaDiponibleFecha(fecha) && aux.getCategoria().equals(categoria) && aux.getCapacidadPasajeros() >= cantidadDePasajeros) {
                avionesDisponibles.add(aux);
            }
        }
        return avionesDisponibles;
    }

    public void agregarFechaReserva(Avion avion, Calendar fecha) {
        Iterator<Avion> iteradorAviones = aviones.iterator();
        Avion aux;
        int i = 0;
        while(iteradorAviones.hasNext()) {
            aux = iteradorAviones.next();
            if(aux.equals(avion)) {
                aux.aniadirFechaReserva(fecha);
                reemplazarAvion(i, aux);
            }
            i++;
        }
    }

    public void eliminarFechaReserva(Avion avion, Calendar fecha) {
        Iterator<Avion> iteradorAviones = aviones.iterator();
        Avion aux;
        int i = 0;
        while(iteradorAviones.hasNext()) {
            aux = iteradorAviones.next();
            if(aux.equals(avion)) {
                aux.eliminarFechaReserva(fecha);
                reemplazarAvion(i, aux);
            }
            i++;
        }
    }

    public int devolverUltimosId(){
        int ultimoId = 1;
        Iterator<Avion> iteradorAvion = aviones.iterator();
        Avion aux;
        while(iteradorAvion.hasNext()) {
            aux = iteradorAvion.next();
            ultimoId = aux.getId();
        }
        return  ultimoId;
    }

    public static void main(String[] args) {
        Avion avion1 = new Avion(1, CategoriaAvion.BRONZE, 200, 150, 5, 200, Propulsion.MOTOR_A_HELICE, false, false, 3000);
        Avion avion2 = new Avion(2, CategoriaAvion.SILVER, 350, 200, 8, 250, Propulsion.MOTOR_A_PISTONES, false, false, 4000);
        Avion avion3 = new Avion(3, CategoriaAvion.GOLD, 250, 175, 7, 200, Propulsion.MOTOR_A_HELICE, false, false, 6000);
        Avion avion4 = new Avion(4, CategoriaAvion.BRONZE, 200, 150, 5, 200, Propulsion.MOTOR_A_HELICE, false, false, 3000);

        GestorArchivoAviones gestorArchivoAviones = new GestorArchivoAviones();

        gestorArchivoAviones.agregarAvion(avion1);
        gestorArchivoAviones.agregarAvion(avion2);
        gestorArchivoAviones.agregarAvion(avion3);
        gestorArchivoAviones.agregarAvion(avion4);
    }
}
