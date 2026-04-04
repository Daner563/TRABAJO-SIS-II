package model;
import java.sql.*;
import java.util.*;

public class JugadorDAO {

    public void agregar(Jugador j){
        try(Connection con = ConexionBD.getConexion()){
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO items_deportivos(nombre, posicion, valor, deporte) VALUES(?,?,?,?)");
            ps.setString(1, j.getNombre());
            ps.setString(2, j.getPosicion());
            ps.setDouble(3, j.getValor());
            ps.setString(4, j.getDeporte());
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }

    public List<Jugador> listar(){
        List<Jugador> lista = new ArrayList<>();
        try(Connection con = ConexionBD.getConexion()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM items_deportivos");
            while(rs.next()){
                lista.add(new Jugador(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("posicion"),
                    rs.getDouble("valor"),
                    rs.getString("deporte")
                ));
            }
        }catch(Exception e){e.printStackTrace();}
        return lista;
    }

    public void eliminar(int id){
        try(Connection con = ConexionBD.getConexion()){
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM items_deportivos WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }
}

