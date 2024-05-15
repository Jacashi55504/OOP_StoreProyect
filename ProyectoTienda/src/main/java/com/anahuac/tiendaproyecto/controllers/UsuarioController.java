package main.java.com.anahuac.tiendaproyecto.controllers;

import java.util.Map;

import main.java.com.anahuac.tiendaproyecto.models.Usuario;
import main.java.com.anahuac.tiendaproyecto.repositories.UsuarioRepository;

// Se ha decidido utilizar una arquitectura de 4 capaz para facilitar el control y la abstracción
// El controller será llamado desde la capa de arriba y se encargará de dirigir el repository.

public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController() {
        this.usuarioRepository = new UsuarioRepository();
    }

    // Agarrar excepciónes 
    public void registrarUsuario(Usuario usuario) {
        try {
            usuarioRepository.agregarUsuario(usuario);
            System.out.println("Usuario agregado: " + usuario.toString());
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    public Usuario buscarUsuario(String usuario) {
        try {
            return usuarioRepository.buscarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
            return null;
        }
    }

    public void eliminarUsuario(String usuario) {
        try {
            usuarioRepository.eliminarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    public Map<String, Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
        // Llamamos a la función en vez de ajustar toda la lógica dentro de la función
        // dando un código mucho más limpio.
    }
}

