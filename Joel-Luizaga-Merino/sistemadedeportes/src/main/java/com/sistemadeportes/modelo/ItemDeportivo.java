package com.sistemadeportes.modelo;

public class ItemDeportivo {
    private int id;
     private String nombre;
     private String posicion;
     private double valor;
     private String deporte;

     public ItemDeportivo() {}

   
    public ItemDeportivo(int id, String nombre, String posicion, double valor, String deporte) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.valor = valor;
        this.deporte = deporte;
    }
    public int getId() {
        return id;
    }

     public void setId(int id) {
         this.id = id;
     }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    @Override
    public String toString() {
        return nombre + " - " + posicion + " - " + deporte;
    }


}
