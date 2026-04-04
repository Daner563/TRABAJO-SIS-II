package com.sistemadeportes.vista;
import com.sistemadeportes.controlador.ItemController;
import javax.swing.*;
import java.awt.*;

public class VentanaEliminar extends JFrame {

    private ItemController controller = new ItemController();
    private JFrame parent;
    private JTextField txtId = new JTextField(10);

    public VentanaEliminar(JFrame parent) {
        this.parent = parent;
        setTitle("Eliminar item");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(new JLabel("ID del item:")); 
        panel.add(txtId);

        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRegresar = new JButton("Regresar");

        btnEliminar.addActionListener(e -> {
            String idStr = txtId.getText().trim();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID.");
                return;
            }
            try {
                int id = Integer.parseInt(idStr);
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de eliminar el item con ID " + id + "?", 
                    "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    controller.eliminar(id);
                    JOptionPane.showMessageDialog(this, "Item eliminado correctamente.");
                    txtId.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un número.");
            }
        });

        btnRegresar.addActionListener(e -> {
            parent.setVisible(true);
            dispose();
        });

        panel.add(btnEliminar);
        panel.add(btnRegresar);

        add(panel);
    }
}