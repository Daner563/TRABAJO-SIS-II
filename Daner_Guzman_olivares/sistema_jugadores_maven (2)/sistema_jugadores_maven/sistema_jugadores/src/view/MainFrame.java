package view;

import controller.JugadorController;
import model.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MainFrame extends JFrame {

    JugadorController controller = new JugadorController();
    DefaultTableModel model = new DefaultTableModel(
        new String[]{"ID","Nombre","Posicion","Valor","Deporte"}, 0);
    JTable table = new JTable(model);

    public MainFrame(){
        setTitle("Sistema Jugadores");
        setSize(700, 400);
        setLayout(null);

        JTextField nombre = new JTextField(); nombre.setBounds(20,20,100,25);
        JTextField posicion = new JTextField(); posicion.setBounds(130,20,100,25);
        JTextField valor = new JTextField(); valor.setBounds(240,20,80,25);
        JTextField deporte = new JTextField(); deporte.setBounds(330,20,100,25);

        JLabel lNombre = new JLabel("Nombre"); lNombre.setBounds(20,50,100,20);
        JLabel lPosicion = new JLabel("Posicion"); lPosicion.setBounds(130,50,100,20);
        JLabel lValor = new JLabel("Valor"); lValor.setBounds(240,50,80,20);
        JLabel lDeporte = new JLabel("Deporte"); lDeporte.setBounds(330,50,100,20);

        JButton add = new JButton("Agregar"); add.setBounds(450,20,100,25);
        JButton del = new JButton("Eliminar"); del.setBounds(450,60,100,25);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20,80,640,260);

        add(nombre); add(posicion); add(valor); add(deporte);
        add(lNombre); add(lPosicion); add(lValor); add(lDeporte);
        add(add); add(del); add(sp);

        add.addActionListener(e -> {
            try {
                controller.agregar(
                    nombre.getText(),
                    posicion.getText(),
                    Double.parseDouble(valor.getText()),
                    deporte.getText()
                );
                load();
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "El valor debe ser un número.");
            }
        });

        del.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row != -1){
                controller.eliminar((int)model.getValueAt(row, 0));
                load();
            }
        });

        load();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void load(){
        model.setRowCount(0);
        List<Jugador> lista = controller.listar();
        for(Jugador j : lista){
            model.addRow(new Object[]{
                j.getId(),
                j.getNombre(),
                j.getPosicion(),
                j.getValor(),
                j.getDeporte()
            });
        }
    }
}
