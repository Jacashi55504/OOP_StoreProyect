package main.java.com.anahuac.tiendaproyecto.controllers;

import java.util.Map;

import main.java.com.anahuac.tiendaproyecto.models.Producto;
import main.java.com.anahuac.tiendaproyecto.repositories.ProductoRepository;


// Controllador de producto, lo mismo que usuario.
public class ProductoController {
    private ProductoRepository productoRepository;

    public ProductoController() {
        this.productoRepository = new ProductoRepository();
    }

    public void agregarProducto(Producto producto) {
        try {
            productoRepository.agregarProducto(producto);
            System.out.println("Producto agregado: " + producto.toString());
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
    }

    public Producto buscarProducto(String codigo) {
        try {
            return productoRepository.buscarProducto(codigo);
        } catch (Exception e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
            return null;
        }
    }

    public void actualizarProducto(Producto producto) {
        try {
            productoRepository.actualizarProducto(producto);
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(String codigo) {
        try {
            productoRepository.eliminarProducto(codigo);
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

    public Map<String, Producto> listarProductos() {
        return productoRepository.listarProductos();
    }
}
