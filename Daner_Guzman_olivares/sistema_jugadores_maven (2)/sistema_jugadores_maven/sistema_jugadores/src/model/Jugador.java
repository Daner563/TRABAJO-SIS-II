package model;

public class Jugador {
    int id;
    String nombre;
    String posicion;
    double valor;
    String deporte;

    public Jugador(int id, String nombre, String posicion, double valor, String deporte) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.valor = valor;
        this.deporte = deporte;
    }

    public int getId(){return id;}
    public String getNombre(){return nombre;}
    public String getPosicion(){return posicion;}
    public double getValor(){return valor;}
    public String getDeporte(){return deporte;}
}