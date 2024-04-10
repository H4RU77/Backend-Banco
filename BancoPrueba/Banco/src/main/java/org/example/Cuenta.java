package org.example;

public class Cuenta {
    private int n_identidad;
    private double saldo_actual;
    private int posicion;
    private Cuenta siguienteCuenta;

    public Cuenta(int n_identidad, double saldo_actual, int posicion) {
        this.n_identidad = n_identidad;
        this.saldo_actual = saldo_actual;
        this.posicion = posicion;
        this.siguienteCuenta = null;
    }

    public int getN_identidad() {
        return n_identidad;
    }

    public void setN_identidad(int n_identidad) {
        this.n_identidad = n_identidad;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }
    public void adicionarSaldo_actual(double saldoAditivo ){
        saldo_actual= saldo_actual+saldoAditivo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Cuenta getSiguienteCuenta() {
        return siguienteCuenta;
    }

    public void setSiguienteCuenta(Cuenta siguienteCuenta) {
        this.siguienteCuenta = siguienteCuenta;
    }
}
