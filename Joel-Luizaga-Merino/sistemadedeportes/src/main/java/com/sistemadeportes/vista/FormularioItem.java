package com.sistemadeportes.vista;
import javax.swing.*;
import java.awt.*;

public class FormularioItem extends JFrame {

    public FormularioItem() {
        setTitle("Sistema de Deportes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));

        JButton btnAgregar = new JButton("Añadir nuevo item");
        JButton btnEliminar = new JButton("Eliminar item");
        JButton btnVisualizar = new JButton("Visualizar tabla");

        btnAgregar.addActionListener(e -> {
            new VentanaAgregar(this).setVisible(true);
            setVisible(false);
        });

        btnEliminar.addActionListener(e -> {
            new VentanaEliminar(this).setVisible(true);
            setVisible(false);
        });

        btnVisualizar.addActionListener(e -> {
            new VentanaTabla(this).setVisible(true);
            setVisible(false);
        });

        panel.add(btnAgregar);
        panel.add(btnEliminar);
        panel.add(btnVisualizar);

        add(panel);
    }
}