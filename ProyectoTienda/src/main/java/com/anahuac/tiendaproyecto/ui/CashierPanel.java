package main.java.com.anahuac.tiendaproyecto.ui;

import main.java.com.anahuac.tiendaproyecto.MainFrame;
import main.java.com.anahuac.tiendaproyecto.controllers.ProductoController;
import main.java.com.anahuac.tiendaproyecto.controllers.UsuarioController;
import main.java.com.anahuac.tiendaproyecto.models.Cajero;
import main.java.com.anahuac.tiendaproyecto.models.Producto;
import main.java.com.anahuac.tiendaproyecto.models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.Map;


public class CashierPanel extends JPanel {
    private ProductoController productoController;
    private UsuarioController usuarioController;

    public CashierPanel(MainFrame mainFrame) {
    	// Llamar a los controladores
        this.productoController = new ProductoController();
        this.usuarioController = new UsuarioController();

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(7, 2));

        panel.add(new JLabel("Código del Producto:"));
        JTextField codigoField = new JTextField();
        panel.add(codigoField);

        panel.add(new JLabel("Nombre del Producto:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Precio del Producto:"));
        JTextField precioField = new JTextField();
        panel.add(precioField);

        JButton addButton = new JButton("Agregar Producto");
        panel.add(addButton);

        JButton deleteButton = new JButton("Eliminar Producto");
        panel.add(deleteButton);

        JButton viewUsersButton = new JButton("Ver Usuarios");
        panel.add(viewUsersButton);

        JButton viewCashiersButton = new JButton("Ver Cajeros");
        panel.add(viewCashiersButton);

        JButton backButton = new JButton("Volver al Inicio");
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);

        // Añadir y borrar
        // Settear acciones
        addButton.addActionListener(e -> {
            String codigo = codigoField.getText().trim();
            String nombre = nombreField.getText().trim();
            double precio;

            try {
                precio = Double.parseDouble(precioField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número.");
                return;
            }

            if (codigo.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos del producto son obligatorios.");
                return;
            }

            try {
                Producto producto = new Producto(codigo, nombre, precio);
                productoController.agregarProducto(producto);
                JOptionPane.showMessageDialog(this, "Producto agregado exitosamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar producto: " + ex.getMessage());
            }
        });

        deleteButton.addActionListener(e -> {
            String codigo = codigoField.getText().trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El código del producto es obligatorio.");
                return;
            }

            try {
                productoController.eliminarProducto(codigo);
                JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar producto: " + ex.getMessage());
            }
        });

        // Función de cajeros para ver usuarios registrados
        // 
        viewUsersButton.addActionListener(e -> {
            StringBuilder usersList = new StringBuilder("Usuarios registrados:\n");

            Map<String, Usuario> usuarios = usuarioController.listarUsuarios();
            usuarios.forEach((key, usuario) -> usersList.append(usuario.toString()).append("\n"));
            // "->" lambda para código limpio

            JOptionPane.showMessageDialog(this, usersList.toString());
        });

        viewCashiersButton.addActionListener(e -> {
            StringBuilder cashiersList = new StringBuilder("Cajeros registrados:\n");

            Map<String, Usuario> usuarios = usuarioController.listarUsuarios();
            // Comprobar privilegio
            usuarios.forEach((key, usuario) -> {
                if (usuario instanceof Cajero) {
                    cashiersList.append(usuario.toString()).append("\n");
                }
            });

            JOptionPane.showMessageDialog(this, cashiersList.toString());
        });

        backButton.addActionListener(e -> mainFrame.showLoginPanel());
    }
}
