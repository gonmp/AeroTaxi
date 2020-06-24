package control;

import modelos.CategoriaAvion;
import modelos.Reserva;
import modelos.Usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatosUsuario {

    private GestorArchivoUsuarios gestorArchivoUsuarios;
    private ReservarVuelo reservarVuelo;

    public DatosUsuario() {
        gestorArchivoUsuarios = new GestorArchivoUsuarios();
        reservarVuelo = new ReservarVuelo();
    }

    public Usuario modificarUsuario(Usuario usuarioModificar, String nombre, String apellido, String dni, int edad, String email) {
        Usuario nuevoUsuario = new Usuario(usuarioModificar.getId(), nombre, apellido, dni, edad, email, usuarioModificar.getContrasenia());
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), nuevoUsuario);

        return nuevoUsuario;
    }

    public Usuario modificarContrasenia(Usuario usuarioModificar, String nuevaContrasenia) {
        Usuario nuevoUsuario = new Usuario(usuarioModificar.getId(), usuarioModificar.getNombre(), usuarioModificar.getApellido(), usuarioModificar.getDni(), usuarioModificar.getEdad(), usuarioModificar.getEmail(), nuevaContrasenia);
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), nuevoUsuario);

        return nuevoUsuario;
    }

    public void hacerAdmin(Usuario usuarioModificar) {
        usuarioModificar.setAdmin(true);
        gestorArchivoUsuarios.reemplazarUsuario(gestorArchivoUsuarios.buscarIndexUsuario(usuarioModificar.getDni()), usuarioModificar);

    }

    public int totalGastado(Usuario usuario) {
        int totalGastado = 0;
        List<Reserva> reservas = reservarVuelo.listarTodasLasReservas();
        Iterator<Reserva> iteradorReserva = reservas.iterator();
        Reserva aux;
        while(iteradorReserva.hasNext()) {
            aux = iteradorReserva.next();
            if(aux.getUsuario().equals(usuario)) {
                totalGastado = totalGastado + aux.getCostoDeVuelo();
            }
        }
        return totalGastado;
    }

    public CategoriaAvion categoriaMasUtilizada(Usuario usuario){
        int cantidadGold = catidadReservasUsuarioPorCategoria(usuario, CategoriaAvion.GOLD);
        int cantidadSilver = catidadReservasUsuarioPorCategoria(usuario, CategoriaAvion.SILVER);
        int cantidadBronze = catidadReservasUsuarioPorCategoria(usuario, CategoriaAvion.BRONZE);
        if(cantidadGold == 0 && cantidadSilver == 0 && cantidadBronze == 0) {
            return null;
        }
        int cantidadMayor = compararTresEnteros(cantidadGold, cantidadSilver, cantidadBronze);
        if(cantidadMayor == 1) {
            return CategoriaAvion.GOLD;
        } else if(cantidadMayor == 0) {
            return CategoriaAvion.SILVER;
        } else {
            return CategoriaAvion.BRONZE;
        }
    }

    public int catidadReservasUsuarioPorCategoria(Usuario usuario, CategoriaAvion categoria) {
        int catidadDeCategoria = 0;
        List<Reserva> reservas = reservarVuelo.listarTodasLasReservas();
        Iterator<Reserva> iteradorReserva = reservas.iterator();
        Reserva aux;
        while(iteradorReserva.hasNext()) {
            aux = iteradorReserva.next();
            if(aux.getUsuario().equals(usuario) && aux.getAvion().getCategoria().equals(categoria)) {
                catidadDeCategoria++;
            }
        }
        return catidadDeCategoria;
    }

    public int compararTresEnteros(int a, int b, int c) {
        if(a > b) {
            if(a > c) {
                return 1;
            } else {
                return -1;
            }
        } else if(b > c) {
            return 0;
        } else {
            return -1;
        }
    }

    public ArrayList<Usuario> listarTodosLosUsuarios() {
        return gestorArchivoUsuarios.getUsuarios();
    }
}
