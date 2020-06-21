package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class Reserva {
    int id;
    Calendar fecha;
    int pasajeros;
    Ciudad origen;
    Ciudad destino;
    int costoDeVuelo;
    int distancia;
    Usuario usuario;
    Avion avion;

    public Reserva(int id, int anio, int mes, int dia, int hora, int pasajeros, Ciudad origen, Ciudad destino, Usuario usuario, Avion avion) {
        this.id = id;
        this.fecha = Calendar.getInstance();
        fecha.set(anio, mes, dia, hora, 0, 0);
        this.pasajeros = pasajeros;
        this.origen = origen;
        this.destino = destino;
        this.usuario = usuario;
        this.avion = avion;
        this.distancia = calcularDistancia();
        this.costoDeVuelo = calcularCosto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public int getCostoDeVuelo() {
        return costoDeVuelo;
    }

    public void setCostoDeVuelo(int costoDeVuelo) {
        this.costoDeVuelo = costoDeVuelo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public int calcularCosto() {
        return distancia * avion.getCostoPorKilometro() + pasajeros * 3500 + avion.getTarifa();
    }

    public int calcularDistancia() {
        int distancia = -1;
        List<Ciudad> origenDestino = new ArrayList<>();
        origenDestino.add(origen);
        origenDestino.add(destino);
        origenDestino.sort(new Comparator<Ciudad>() {
            @Override
            public int compare(Ciudad o1, Ciudad o2) {
                return o1.compareTo(o2);
            }
        });
        if(origenDestino.get(0) == Ciudad.BUENOS_AIRES) {
            if(origenDestino.get(1) == Ciudad.CORDOBA) {
                distancia = 695;
            } else if(origenDestino.get(1) == Ciudad.SANTIAGO) {
                distancia = 1400;
            } else if(origenDestino.get(1) == Ciudad.MONTEVIDEO) {
                distancia = 950;
            }
        } else if(origenDestino.get(0) == Ciudad.CORDOBA) {
            if(origenDestino.get(1) == Ciudad.MONTEVIDEO) {
                distancia = 1190;
            } else if(origenDestino.get(1) == Ciudad.SANTIAGO) {
                distancia = 1050;
            }
        } else if(origenDestino.get(0) == Ciudad.MONTEVIDEO) {
            distancia = 2100;
        }

        return distancia;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Reserva)) {
            return false;
        }
        Reserva reserva = (Reserva) o;
        return reserva.getId() == id;
    }

    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", pasajeros=" + pasajeros +
                ", origen=" + origen +
                ", destino=" + destino +
                ", costoDeVuelo=" + costoDeVuelo +
                ", distancia=" + distancia +
                ", usuario=" + usuario +
                ", avion=" + avion +
                '}';
    }
}
