package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Avion {

    private int id;
    private CategoriaAvion categoria;
    private int capacidadCombustible;
    private int costoPorKilometro;
    private int capacidadPasajeros;
    private int velocidadMaxima;
    private Propulsion propulsion;
    private boolean wifi;
    private boolean catering;
    private int tarifa;
    private List<Calendar> fechasReservado = new ArrayList<Calendar>();;

    public Avion(int id, CategoriaAvion categoria, int capacidadCombustible, int costoPorKilometro, int capacidadPasajeros, int velocidadMaxima, Propulsion propulsion, boolean wifi, boolean catering, int tarifa) {
        this.id = id;
        this.categoria = categoria;
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKilometro = costoPorKilometro;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
        this.wifi = wifi;
        this.catering = catering;
        this.tarifa = tarifa;
        //fechasReservado = new ArrayList<Calendar>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoriaAvion getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAvion categoria) {
        this.categoria = categoria;
    }

    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public int getCostoPorKilometro() {
        return costoPorKilometro;
    }

    public void setCostoPorKilometro(int costoPorKilometro) {
        this.costoPorKilometro = costoPorKilometro;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }

    public boolean tieneWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean tieneCatering() {
        return catering;
    }

    public void setCatering(boolean catering) {
        this.catering = catering;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public List<Calendar> getFechasReservado() {
        return fechasReservado;
    }

    public void setFechasReservado(List<Calendar> fechasReservado) {
        this.fechasReservado = fechasReservado;
    }

    public void aniadirFechaReserva(Calendar fecha) {
        fechasReservado.add(fecha);
    }

    public void eliminarFechaReserva(Calendar fecha) {
        Iterator<Calendar> iteradorFechas = fechasReservado.iterator();
        boolean fechaEncontrada = false;
        Calendar aux;
        while (iteradorFechas.hasNext() && !fechaEncontrada) {
            aux = iteradorFechas.next();
            if(compararFechas(aux, fecha)) {
                fechasReservado.remove(aux);
                fechaEncontrada = true;
            }
        }
    }

    public boolean estaDiponibleFecha(Calendar fecha) {
        boolean disponible = true;
        if(fechasReservado != null) {
            Iterator<Calendar> iteradorFechas = fechasReservado.iterator();
            Calendar aux;
            while (iteradorFechas.hasNext() && disponible) {
                aux = iteradorFechas.next();
                if(compararFechas(aux, fecha)) {
                    disponible = false;
                }
            }
        }
        return disponible;
    }

    public boolean compararFechas(Calendar fecha1, Calendar fecha2) {
        if (fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR) && fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH) && fecha1.get(Calendar.DATE) == fecha2.get(Calendar.DATE)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", capacidadCombustible=" + capacidadCombustible +
                ", costoPorKilometro=" + costoPorKilometro +
                ", capacidadPasajeros=" + capacidadPasajeros +
                ", velocidadMaxima=" + velocidadMaxima +
                ", propulsion=" + propulsion +
                ", wifi=" + wifi +
                ", catering=" + catering +
                ", tarifa=" + tarifa +
                ", fechasReservado=" + fechasReservado +
                '}';
    }
}
