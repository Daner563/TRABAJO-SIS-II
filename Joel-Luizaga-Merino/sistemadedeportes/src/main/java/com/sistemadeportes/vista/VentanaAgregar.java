package com.sistemadeportes.vista;
import com.sistemadeportes.controlador.ItemController;
import javax.swing.*;
import java.awt.*;

public class VentanaAgregar extends JFrame {

    private ItemController controller = new ItemController();
    private JFrame parent;

    private JTextField txtNombre = new JTextField(20);
    private JTextField txtPosicion = new JTextField(20);
    private JTextField txtValor = new JTextField(20);
    private JTextField txtDeporte = new JTextField(20);

    public VentanaAgregar(JFrame parent) {
        this.parent = parent;
        setTitle("Añadir nuevo item");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nombre:")); panel.add(txtNombre);
        panel.add(new JLabel("Posición:")); panel.add(txtPosicion);
        panel.add(new JLabel("Valor:")); panel.add(txtValor);
        panel.add(new JLabel("Deporte:")); panel.add(txtDeporte);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnRegresar = new JButton("Regresar");

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String posicion = txtPosicion.getText().trim();
            String valorStr = txtValor.getText().trim();
            String deporte = txtDeporte.getText().trim();

            if (nombre.isEmpty() || posicion.isEmpty() || valorStr.isEmpty() || deporte.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

            if (controller.existe(nombre)) {
                JOptionPane.showMessageDialog(this, "El item '" + nombre + "' ya existe.");
                return;
            }

            try {
                double valor = Double.parseDouble(valorStr);
                controller.agregar(nombre, posicion, valor, deporte);
                JOptionPane.showMessageDialog(this, "Item agregado correctamente.");
                txtNombre.setText("");
                txtPosicion.setText("");
                txtValor.setText("");
                txtDeporte.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El valor debe ser un número.");
            }
        });

        btnRegresar.addActionListener(e -> {
            parent.setVisible(true);
            dispose();
        });

        panel.add(btnGuardar);
        panel.add(btnRegresar);

        add(panel);
    }
}