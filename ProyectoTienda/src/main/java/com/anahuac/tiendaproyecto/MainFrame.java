package main.java.com.anahuac.tiendaproyecto;

import main.java.com.anahuac.tiendaproyecto.controllers.UsuarioController;
import main.java.com.anahuac.tiendaproyecto.models.Cajero;
import main.java.com.anahuac.tiendaproyecto.models.Cliente;
import main.java.com.anahuac.tiendaproyecto.models.Usuario;
import main.java.com.anahuac.tiendaproyecto.ui.CashierPanel;
import main.java.com.anahuac.tiendaproyecto.ui.LoginPanel;
import main.java.com.anahuac.tiendaproyecto.ui.RegisterPanel;
import main.java.com.anahuac.tiendaproyecto.ui.UserPanel;

import javax.swing.*;
import java.awt.*;

// UI principal y main class, el sistema de tienda completo
public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private UsuarioController usuarioController;

    public MainFrame() {
        usuarioController = new UsuarioController();

        setTitle("Sistema de Tienda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Dividir los paneles
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        LoginPanel loginPanel = new LoginPanel(this, usuarioController);
        RegisterPanel registerPanel = new RegisterPanel(this, usuarioController);
        UserPanel userPanel = new UserPanel(this); // Asegurarse que se pueda volver a la instancia del frame
        CashierPanel cashierPanel = new CashierPanel(this, usuarioController);

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registerPanel, "Register");
        mainPanel.add(userPanel, "User");
        mainPanel.add(cashierPanel, "Cashier");

        add(mainPanel);
        showLoginPanel();
    }

    // Helper función.
    public void showLoginPanel() {
        cardLayout.show(mainPanel, "Login");
    }

    public void showRegisterPanel() {
        cardLayout.show(mainPanel, "Register");
    }

    public void showUserPanel() {
        cardLayout.show(mainPanel, "User");
    }

    public void showCashierPanel() {
        cardLayout.show(mainPanel, "Cashier");
    }

    public void login(String usuario, String contrasena) {
    	// Mostrar el panel correspondiente
        Usuario user = usuarioController.buscarUsuario(usuario);
        if (user != null && user.getContrasena().equals(contrasena)) {
            if (user instanceof Cajero) {
                showCashierPanel();
            } else if (user instanceof Cliente) {
                showUserPanel();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }

    public static void main(String[] args) { // Main class para java
        SwingUtilities.invokeLater(() -> { // Buena práctica
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
