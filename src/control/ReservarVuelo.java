package control;

import modelos.*;

import java.util.ArrayList;
import java.util.Calendar;

public class ReservarVuelo {
    GestorArchivoReservas gestorArchivoReservas;
    GestorArchivoAviones gestorArchivoAviones;
    //Usuario usuarioLogueado;

    public ReservarVuelo(Usuario usuarioLogueado) {
        gestorArchivoReservas = new GestorArchivoReservas();
        gestorArchivoAviones = new GestorArchivoAviones();
        //this.usuarioLogueado = usuarioLogueado;
    }

    public void reservarVuelo(Reserva reserva) {
        gestorArchivoReservas.agregarReserva(reserva);
        gestorArchivoAviones.agregarFechaReserva(reserva.getAvion(), reserva.getFecha());
    }

    public void eliminarReserva(Reserva reserva) {
        gestorArchivoReservas.eliminarReserva(reserva);
        gestorArchivoAviones.eliminarFechaReserva(reserva.getAvion(), reserva.getFecha());
    }

    public ArrayList<Avion> filtrarAviones( int cantidadDePasajeros, int anio, int mes, int dia) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(anio, mes, dia);
        return gestorArchivoAviones.filtrarAviones(cantidadDePasajeros, fecha);
    }

    public ArrayList<Avion> filtrarAviones( int cantidadDePasajeros, int anio, int mes, int dia, CategoriaAvion categoria) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(anio, mes, dia);
        return gestorArchivoAviones.filtrarAviones(cantidadDePasajeros, fecha, categoria);
    }

    public Reserva crearReserva(int anio, int mes, int dia, int hora, int pasajeros, Ciudad origen, Ciudad destino, Usuario usuario, Avion avion) {
        int id = gestorArchivoReservas.devolverUltimosId() + 1;
        Reserva nuevaReserva = new Reserva(id, anio, mes, dia, hora, pasajeros, origen, destino, usuario, avion);
        return nuevaReserva;
    }
}
