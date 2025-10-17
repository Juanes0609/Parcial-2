package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Patrón: Singleton + Facade.
 */
public class InmuebleService {

    // Instancia única (Singleton)
    private static InmuebleService instance;

    // Lista de inmuebles almacenados
    private final List<Inmueble> inmuebles = new ArrayList<>();

    private InmuebleService() {}

    public static InmuebleService getInstance() {
        if (instance == null) {
            instance = new InmuebleService();
        }
        return instance;
    }

    public void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }

    public List<Inmueble> obtenerInmuebles() {
        return inmuebles;
    }

    public void eliminarInmueble(Inmueble inmueble) {
        inmuebles.remove(inmueble);
    }
}
