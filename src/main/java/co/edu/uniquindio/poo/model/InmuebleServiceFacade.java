package co.edu.uniquindio.poo.model;

import java.util.List;

public class InmuebleServiceFacade {

    private final InmuebleService service = InmuebleService.getInstance();

    // ----------- Patrón Facade -----------
     // 🔨 Patrón FACADE + BUILDER
     public void crearInmueble(String tipo, String ciudad, int habitaciones, int numPisos, double precio) {
        Inmueble nuevo = new Inmueble.Builder()
                .tipo(tipo)
                .ciudad(ciudad)
                .habitaciones(habitaciones)
                .numPisos(numPisos)
                .precio(precio)
                .build();

        service.agregarInmueble(nuevo);
    }

    public void eliminarInmueble(Inmueble inmueble) {
        service.eliminarInmueble(inmueble);
    }

    public List<Inmueble> listadoInmuebles() {
        return service.obtenerInmuebles();
    }
}
