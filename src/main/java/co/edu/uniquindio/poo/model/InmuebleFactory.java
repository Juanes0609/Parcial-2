package co.edu.uniquindio.poo.model;

public class InmuebleFactory {
    // ----------- Patrón Factory -----------
    public static Inmueble crearInmueble(String tipo, String ciudad, int habitaciones, int numPisos, double precio) {
        return new Inmueble.Builder()
                .tipo(tipo)
                .ciudad(ciudad)
                .habitaciones(habitaciones)
                .numPisos(numPisos)
                .precio(precio)
                .build();
    }
}
