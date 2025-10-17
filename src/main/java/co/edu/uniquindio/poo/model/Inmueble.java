package co.edu.uniquindio.poo.model;

public class Inmueble {
        private String tipo;
        private String ciudad;
        private int habitaciones;
        private int numPisos;
        private double precio;
    
        private Inmueble(Builder builder) {
            this.ciudad = builder.ciudad;
            this.tipo = builder.tipo;
            this.habitaciones = builder.habitaciones;
            this.numPisos = builder.numPisos;
            this.precio = builder.precio;
        }
    
        public static class Builder {
            private String tipo;
            private String ciudad;
            private int habitaciones;
            private int numPisos;
            private double precio;
    
            public Builder ciudad(String ciudad) {
                this.ciudad = ciudad;
                return this;
            }
    
            public Builder habitaciones(int habitaciones) {
                this.habitaciones = habitaciones;
                return this;
            }
    
            public Builder numPisos(int numPisos) {
                this.numPisos = numPisos;
                return this;
            }
            
            public Builder precio (double precio) {
                this.precio = precio;
                return this;
            }

            public Builder tipo(String tipo) {
                this.tipo = tipo;
                return this;
            }

            public Inmueble build() {
                return new Inmueble(this);
            }

        }
    
        public String getCiudad() {
            return ciudad;
        }
    
        public int getHabitaciones() {
            return habitaciones;
        }
    
        public int getNumPisos() {
            return numPisos;
        }

        public double getPrecio() {
            return precio;
        }

        public String getTipo() {
            return tipo;
        }

        @Override
        public String toString() {
            return tipo + " " + ciudad + " " + habitaciones + " "
                    + numPisos + " " + precio;
        }

        
        
    
        
}
