package com.sistemadeportes.modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public List<ItemDeportivo> listar() {
        List<ItemDeportivo> lista = new ArrayList<>();
        String sql = "SELECT * FROM items_deportivos";
        try (Connection con = ConexionBD.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                ItemDeportivo item = new ItemDeportivo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("posicion"),
                    rs.getDouble("valor"),
                    rs.getString("deporte")
                );
                lista.add(item);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public void agregar(ItemDeportivo item) {
        String sql = "INSERT INTO items_deportivos (nombre, posicion, valor, deporte) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, item.getNombre());
            ps.setString(2, item.getPosicion());
            ps.setDouble(3, item.getValor());
            ps.setString(4, item.getDeporte());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM items_deportivos WHERE id = ?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void actualizar(ItemDeportivo item) {
        String sql = "UPDATE items_deportivos SET nombre=?, posicion=?, valor=?, deporte=? WHERE id=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, item.getNombre());
            ps.setString(2, item.getPosicion());
            ps.setDouble(3, item.getValor());
            ps.setString(4, item.getDeporte());
            ps.setInt(5, item.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
}