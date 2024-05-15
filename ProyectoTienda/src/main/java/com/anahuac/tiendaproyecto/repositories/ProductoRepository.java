package main.java.com.anahuac.tiendaproyecto.repositories;

import java.util.HashMap;
import java.util.Map;

import main.java.com.anahuac.tiendaproyecto.models.Producto;

// Repositorio para producto, lo mismo que usuario, full CRUD

public class ProductoRepository {
    private Map<String, Producto> productos;

    public ProductoRepository() {
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) throws Exception {
        if (productos.containsKey(producto.getCodigo())) {
            throw new Exception("El producto ya existe");
        }
        productos.put(producto.getCodigo(), producto);
    }

    public Producto buscarProducto(String codigo) throws Exception {
        if (!productos.containsKey(codigo)) {
            throw new Exception("Producto no encontrado");
        }
        return productos.get(codigo);
    }

    public void actualizarProducto(Producto producto) throws Exception {
        if (!productos.containsKey(producto.getCodigo())) {
            throw new Exception("Producto no encontrado");
        }
        productos.put(producto.getCodigo(), producto);
    }

    public void eliminarProducto(String codigo) throws Exception {
        if (!productos.containsKey(codigo)) {
            throw new Exception("Producto no encontrado");
        }
        productos.remove(codigo); // Eliminar del hash dependiendo de la instancia de producto
    }

    public Map<String, Producto> listarProductos() {
        return productos;
    }
}
