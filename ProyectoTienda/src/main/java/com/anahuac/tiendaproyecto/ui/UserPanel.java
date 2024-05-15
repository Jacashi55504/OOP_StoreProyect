package main.java.com.anahuac.tiendaproyecto.ui;

import main.java.com.anahuac.tiendaproyecto.MainFrame;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    public UserPanel(MainFrame mainFrame) {
    	// Al tratarse de un sistema enfocado más al cajero no se han añadido más implementaciones
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenido, Cliente");
        add(label, BorderLayout.CENTER);

        JButton backButton = new JButton("Volver al Inicio");
        add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(e -> mainFrame.showLoginPanel());
    }
}
