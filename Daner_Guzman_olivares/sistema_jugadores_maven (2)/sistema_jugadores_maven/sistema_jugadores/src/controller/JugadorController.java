package controller;
import model.*;
import java.util.*;

public class JugadorController {
    JugadorDAO dao = new JugadorDAO();

    public void agregar(String nombre, String posicion, double valor, String deporte){
        dao.agregar(new Jugador(0, nombre, posicion, valor, deporte));
    }

    public List<Jugador> listar(){
        return dao.listar();
    }

    public void eliminar(int id){
        dao.eliminar(id);
    }
}