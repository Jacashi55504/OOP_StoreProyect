package main.java.com.anahuac.tiendaproyecto.ui;

// Importar todo
import javax.swing.*;
import java.awt.*;

import main.java.com.anahuac.tiendaproyecto.MainFrame;
import main.java.com.anahuac.tiendaproyecto.controllers.UsuarioController;
import main.java.com.anahuac.tiendaproyecto.models.Cajero;
import main.java.com.anahuac.tiendaproyecto.models.Cliente;

//Se escogió la librería swing para trabajar con ui
//Colocamos el JPanel en el Jframe que implementará todos los paneles
public class RegisterPanel extends JPanel {
    public RegisterPanel(MainFrame mainFrame, UsuarioController usuarioController) {
        setLayout(new BorderLayout());

        // Grid que quede con los fields
        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Usuario:"));
        JTextField usuarioField = new JTextField();
        panel.add(usuarioField);

        panel.add(new JLabel("Contraseña:"));
        JPasswordField contrasenaField = new JPasswordField();
        panel.add(contrasenaField);

        // Selección del tipo de usuario
        panel.add(new JLabel("Tipo de Usuario:"));
        String[] tipos = {"Cliente", "Cajero"}; // Lista de los tipos de usuarios
        JComboBox<String> tipoCombo = new JComboBox<>(tipos); //JComboBox: "A combination of a text field and a drop-down list."
        panel.add(tipoCombo);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton registerButton = new JButton("Registrar");
        JButton backButton = new JButton("Regresar");
        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);

        panel.add(new JLabel()); // Placeholder para alinear los botones correctamente
        panel.add(buttonPanel);

        add(panel, BorderLayout.CENTER);

        registerButton.addActionListener(e -> {
            String nombre = nombreField.getText().trim();
            String usuario = usuarioField.getText().trim();
            String contrasena = new String(contrasenaField.getPassword()).trim();
            String tipo = (String) tipoCombo.getSelectedItem();

            // Evitar crear usuario nulo
            if (nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

            try {
                if (tipo.equals("Cliente")) {
                    Cliente cliente = new Cliente(nombre, usuario, contrasena);
                    usuarioController.registrarUsuario(cliente);
                } else if (tipo.equals("Cajero")) {
                    Cajero cajero = new Cajero(nombre, usuario, contrasena);
                    usuarioController.registrarUsuario(cajero);
                }
                JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
                mainFrame.showLoginPanel();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar usuario: " + ex.getMessage());
            }
        });
        backButton.addActionListener(e -> mainFrame.showLoginPanel()); // Regresar
    }
}
