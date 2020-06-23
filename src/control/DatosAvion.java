package control;

import modelos.Avion;
import modelos.CategoriaAvion;
import modelos.Propulsion;
import modelos.Usuario;

import java.util.ArrayList;

public class DatosAvion {
    private GestorArchivoAviones gestorArchivoAviones;

    public DatosAvion() {
        gestorArchivoAviones = new GestorArchivoAviones();
    }

    public void agregarAvion(CategoriaAvion categoria, int capacidadCombustible, int costoPorKilometro, int capacidadPasajeros, int velocidadMaxima, Propulsion propulsion, boolean wifi, boolean catering) {
        gestorArchivoAviones.agregarAvion(crearAvion(categoria, capacidadCombustible, costoPorKilometro, capacidadPasajeros, velocidadMaxima, propulsion, wifi, catering));
    }

    public Avion crearAvion(CategoriaAvion categoria, int capacidadCombustible, int costoPorKilometro, int capacidadPasajeros, int velocidadMaxima, Propulsion propulsion, boolean wifi, boolean catering) {
        int id = gestorArchivoAviones.devolverUltimosId() + 1;
        Avion nuevoAvion = new Avion(id, categoria, capacidadCombustible, costoPorKilometro, capacidadPasajeros, velocidadMaxima, propulsion, wifi, catering);
        return nuevoAvion;
    }

    public ArrayList<Avion> listarTodosLosAviones() {
        return gestorArchivoAviones.getAviones();
    }

    public void eleminarAvion(Avion avion) {
        //gestorArchivoAviones.e
    }
}
