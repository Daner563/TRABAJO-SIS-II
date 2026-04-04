package com.sistemadeportes.vista;
import com.sistemadeportes.controlador.ItemController;
import javax.swing.*;
import java.awt.*;

public class VentanaTabla extends JFrame {

    private ItemController controller = new ItemController();
    private JFrame parent;
    private JTable tabla = new JTable();

    public VentanaTabla(JFrame parent) {
        this.parent = parent;
        setTitle("Tabla de items");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        controller.listar(tabla);
    }

    private void initComponents() {
        JButton btnRegresar = new JButton("Regresar");

        btnRegresar.addActionListener(e -> {
            parent.setVisible(true);
            dispose();
        });

        JPanel panelSur = new JPanel();
        panelSur.add(btnRegresar);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);
    }
}