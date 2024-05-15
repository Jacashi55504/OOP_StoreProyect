package main.java.com.anahuac.tiendaproyecto.repositories;

import java.util.HashMap;
import java.util.Map;

import main.java.com.anahuac.tiendaproyecto.models.Usuario;

public class UsuarioRepository {
	
	// Utilizar hash map para guardar a los usuarios ya que no hay DB implementada
	// ID : USUARIO
    private Map<String, Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new HashMap<>();
    }

    // Si el usuario no se ha podido agregar arroja la excepción (Error) aunque por lo general será manejada por la capa de arriba
    // Comprobar si el usuario existe 
    public void agregarUsuario(Usuario usuario) throws Exception {
        if (usuarios.containsKey(usuario.getUsuario())) {
            throw new Exception("El usuario ya existe");
        }
        usuarios.put(usuario.getUsuario(), usuario);
    }

    public Usuario buscarUsuario(String usuario) throws Exception {
        if (!usuarios.containsKey(usuario)) {
            throw new Exception("Usuario no encontrado");
        }
        return usuarios.get(usuario);
    }
    
    public void eliminarUsuario(String usuario) throws Exception {
        if (!usuarios.containsKey(usuario)) {
            throw new Exception("Usuario no encontrado");
        }
        usuarios.remove(usuario);
    }

    // Al utilizar map podemos regresar los valores listados
    public Map<String, Usuario> listarUsuarios() {
        return usuarios;
    }
}

