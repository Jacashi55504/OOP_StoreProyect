package main.java.com.anahuac.tiendaproyecto.ui;

import javax.swing.*;
import java.awt.*;

import main.java.com.anahuac.tiendaproyecto.MainFrame;
import main.java.com.anahuac.tiendaproyecto.controllers.UsuarioController;

// Se escogió la librería swing para trabajar con ui
// Colocamos el JPanel en el Jframe que implementará todos los paneles
public class LoginPanel extends JPanel {
    public LoginPanel(MainFrame mainFrame, UsuarioController usuarioController) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Usuario:"));
        JTextField usuarioField = new JTextField();
        panel.add(usuarioField);

        panel.add(new JLabel("Contraseña:"));
        JPasswordField contrasenaField = new JPasswordField();
        panel.add(contrasenaField);

        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

        JButton registerButton = new JButton("Registrar");
        panel.add(registerButton);

        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> {
            String usuario = usuarioField.getText();
            String contrasena = new String(contrasenaField.getPassword());
            mainFrame.login(usuario, contrasena);
        });

        registerButton.addActionListener(e -> mainFrame.showRegisterPanel());
    }
}
