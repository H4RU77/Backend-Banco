package org.example;

public interface IMetodos<T> {
    public int tamanio();
    public boolean esVacia();
    public T Obtener(int i);
    public void Adicionar(T x);
    public void Insertar(T x, int i);
    public void Eliminar (int i);
    public int Buscar(T x);

}
