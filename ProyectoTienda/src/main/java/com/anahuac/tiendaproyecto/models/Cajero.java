package main.java.com.anahuac.tiendaproyecto.models;

public class Cajero extends Usuario {

    public Cajero(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "nombre='" + getNombre() + '\'' +
                ", usuario='" + getUsuario() + '\'' +
                '}';
    }
}
