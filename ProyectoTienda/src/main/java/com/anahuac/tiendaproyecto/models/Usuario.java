package main.java.com.anahuac.tiendaproyecto.models;

// Clase abstracta que será heredada por las clases 
public abstract class Usuario {
    private String nombre;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String usuario, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Imprimir el usuario de manera limpia 
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
