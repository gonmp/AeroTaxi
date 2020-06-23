package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import modelos.Avion;
import modelos.Reserva;
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

public class GestorArchivoReservas {
    public ArrayList<Reserva> reservas = new ArrayList<Reserva>();;
    private Gson gson;

    public GestorArchivoReservas() {
        gson = new GsonBuilder().setPrettyPrinting().create();
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
        int ultimoId = 0;
        Iterator<Reserva> iteradorReservas = reservas.iterator();
        Reserva aux;
        while(iteradorReservas.hasNext()) {
            aux = iteradorReservas.next();
            ultimoId = aux.getId();
        }
        return  ultimoId;
    }

    public ArrayList<Reserva> filtrarReservaDeUsuario(Usuario usuario) {
        List<Reserva> reservasDeUsuario = new ArrayList<Reserva>();
        Iterator<Reserva> iteradorReservas = reservas.iterator();
        Reserva aux;
        while(iteradorReservas.hasNext()) {
            aux = iteradorReservas.next();
            if(aux.getUsuario().equals(usuario)) {
                reservasDeUsuario.add(aux);
            }
        }
        return (ArrayList<Reserva>) reservasDeUsuario;
    }

    public ArrayList<Reserva> filtrarReservaPorFecha(Calendar fecha) {
        List<Reserva> reservasPorFecha = new ArrayList<Reserva>();
        Iterator<Reserva> iteradorReservas = reservas.iterator();
        Reserva aux;
        while(iteradorReservas.hasNext()) {
            aux = iteradorReservas.next();
            if(compararFechas(aux.getFecha(), fecha)) {
                reservasPorFecha.add(aux);
            }
        }
        return (ArrayList<Reserva>) reservasPorFecha;
    }

    public boolean compararFechas(Calendar fecha1, Calendar fecha2) {
        if (fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR) && fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH) && fecha1.get(Calendar.DATE) == fecha2.get(Calendar.DATE)) {
            return true;
        }
        return false;
    }
}
