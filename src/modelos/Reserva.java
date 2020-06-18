package modelos;

import java.util.Calendar;

public class Reserva {
    Calendar fecha;
    int pasajeros;
    Ciudad origen;
    Ciudad destino;
    int costoDeVuelo;
    int distancia;
    Avion avion;


    public int calcularCosto() {
        return distancia
    }

    /*public int calcularDistancia() {
        int distancia;
        if(this.origen == Ciudad.BUENOS_AIRES) {
            if(this.destino == Ciudad.CORDOBA) {
                distancia = 695;
            } else if(this.destino == Ciudad.SANTIAGO) {
                distancia = 1400;
            } else if(this.destino == Ciudad.MONTEVIDEO) {
                distancia =
            }
        }
    }*/
}
