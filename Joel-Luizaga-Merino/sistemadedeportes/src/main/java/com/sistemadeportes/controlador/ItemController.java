package com.sistemadeportes.controlador;
import com.sistemadeportes.modelo.ItemDAO;
import com.sistemadeportes.modelo.ItemDeportivo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ItemController {

    private ItemDAO dao = new ItemDAO();

    public boolean existe(String nombre) {
        for (ItemDeportivo item : dao.listar()) {
            if (item.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
     public void agregar(String nombre, String posicion, double valor, String deporte) {
        ItemDeportivo item = new ItemDeportivo(0, nombre, posicion, valor, deporte);
        dao.agregar(item);
    }
    public void eliminar(int id) {
        dao.eliminar(id);
    }
    public void actualizar(int id, String nombre, String posicion, double valor, String deporte) {
        ItemDeportivo item = new ItemDeportivo(id, nombre, posicion, valor, deporte);
        dao.actualizar(item);
    }
    public void listar(JTable tabla) {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Posición", "Valor", "Deporte"}, 0
        );
        for (ItemDeportivo item : dao.listar()) {
            model.addRow(new Object[]{
                item.getId(),
                item.getNombre(),
                item.getPosicion(),
                item.getValor(),
                item.getDeporte()
            });
        }
        tabla.setModel(model);
    }
}