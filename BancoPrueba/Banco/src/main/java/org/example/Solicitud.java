package org.example;

public class Solicitud {
    private int n_identidad;
    private double cant_depositar;
    private String nombre;
    private Solicitud siguienteSolicitud;

    public Solicitud(int n_identidad, double cant_depositar, String nombre) {
        this.n_identidad = n_identidad;
        this.cant_depositar = cant_depositar;
        this.nombre = nombre;
        this.siguienteSolicitud = null;
    }

    public int getN_identidad() {
        return n_identidad;
    }

    public void setN_identidad(int n_identidad) {
        this.n_identidad = n_identidad;
    }

    public double getCant_depositar() {
        return cant_depositar;
    }

    public void setCant_depositar(double cant_depositar) {
        this.cant_depositar = cant_depositar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Solicitud getSiguienteSolicitud() {
        return siguienteSolicitud;
    }

    public void setSiguienteSolicitud(Solicitud siguienteSolicitud) {
        this.siguienteSolicitud = siguienteSolicitud;
    }
}
