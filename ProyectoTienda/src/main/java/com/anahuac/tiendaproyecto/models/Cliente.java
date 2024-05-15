package main.java.com.anahuac.tiendaproyecto.models;

public class Cliente extends Usuario {

    public Cliente(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    // Override a la clase string, getNombre heredado
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                ", usuario='" + getUsuario() + '\'' +
                '}';
    }
}
