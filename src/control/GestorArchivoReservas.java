package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import modelos.Avion;
import modelos.Reserva;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestorArchivoReservas {
    public ArrayList<Reserva> reservas = new ArrayList<Reserva>();;
    private Gson gson;

    public GestorArchivoReservas() {
        gson = new Gson();
        leerReservas();
    }

    public Reserva buscarAvion(int id) {
        Reserva reservaBuscada = null;
        Iterator<Reserva> iteradorReservas = reservas.iterator();
        Reserva aux;
        while(iteradorReservas.hasNext() && reservaBuscada == null) {
            aux = iteradorReservas.next();
            if(aux.getId() == id) {
                reservaBuscada = aux;
            }
        }
        return reservaBuscada;
    }

    public void reemplazarReserva(int index, Reserva nuevaReserva) {
        reservas.set(index, nuevaReserva);
        try (FileWriter writer = new FileWriter(ArchivoDatos.archivoVuelos)) {
            gson.toJson(reservas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerReservas() {
        final Type tipoListaReservas = new TypeToken<List<Reserva>>(){}.getType();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(ArchivoDatos.archivoVuelos));
            reservas = gson.fromJson(jsonReader, tipoListaReservas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
        try (FileWriter writer = new FileWriter(ArchivoDatos.archivoVuelos)) {
            gson.toJson(reservas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
        try (FileWriter writer = new FileWriter(ArchivoDatos.archivoVuelos)) {
            gson.toJson(reservas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int devolverUltimosId(){
        int ultimoId = 1;
        Iterator<Reserva> iteradorReservas = reservas.iterator();
        Reserva aux;
        while(iteradorReservas.hasNext()) {
            aux = iteradorReservas.next();
            ultimoId = aux.getId();
        }
        return  ultimoId;
    }
}
