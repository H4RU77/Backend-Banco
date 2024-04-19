package org.example;

public class ListaSE<T> {
    private NodoSE<T> cabeza;
    private int tamano;

    public ListaSE(){
        this.tamano=0;

    }

    public int tamanio() {
        /*int tamanio = 0;
        NodoSE<T> nodoActual = cabeza;
        if(nodoActual.getSiguiente()!=null){
            nodoActual=nodoActual.getSiguiente();
        }
        while (nodoActual != null) {
            tamanio++;
            if (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            } else {
                break;
            }
        }
        */
        return tamano;
    }

    public boolean EsVacia(){
        if(cabeza==null){
            return true;
        }else{
            return false;
        }
    }
    public NodoSE<T> Obtener(int pos){

        if(pos<tamano && pos>=0){
            int contador=0; NodoSE<T> nodoActual;
            nodoActual=cabeza;
            while(contador<pos){
                nodoActual = nodoActual.getSiguiente();
                contador++;
            }

            return nodoActual;
        }else{
            System.out.println("Posición inválida");
            return null;
        }
    }
    public void Agregar(NodoSE<T> nuevoNodo){
        if(EsVacia()){
            cabeza = nuevoNodo;
        }else{
            NodoSE<T> ultimoNodo=cabeza;
            while(ultimoNodo.getSiguiente()!=null){
                ultimoNodo = ultimoNodo.getSiguiente();
            }
            ultimoNodo.setSiguiente(nuevoNodo);

        }
        System.out.println("Se agregó exitosamente.");
        tamano++;

    }
    public void Eliminar(int pos){

        if(pos<tamano && pos>=0){
            if(pos==0){
                cabeza= cabeza.getSiguiente(); //solo queda la cabeza apuntando a null
            }else{
                NodoSE<T> nodoAnterior = cabeza;
                for(int i=0;i<pos;i++){
                    nodoAnterior=nodoAnterior.getSiguiente();
                }
                NodoSE<T> nodoAEliminar = nodoAnterior.getSiguiente(); //el siguiente a nodo Anterior es el que se va a eliminar
                nodoAnterior.setSiguiente(nodoAEliminar.getSiguiente()); //apuntar el anterior al nodo que sigue despues del nodo a eliminar
                nodoAEliminar.setSiguiente(null);//terminar de desconectar el nodo
            }
            tamano--;


        }
        else{
            System.out.println("Posición inválida");
        }
    }
    public void Eliminar(NodoSE nodoAEliminar) {
        if (cabeza == null) {
            return;
        }
        //si el nodo a eliminar es la cabeza
        if (cabeza.equals(nodoAEliminar)) {
            cabeza = cabeza.getSiguiente(); // Elimina la cabeza
            tamano--;
            return;

        }

        // encontrar el nodo anterior al nodo a eliminar
        NodoSE nodoAnterior = cabeza;
        while (nodoAnterior.getSiguiente() != null && !nodoAnterior.getSiguiente().equals(nodoAEliminar)) {
            nodoAnterior = nodoAnterior.getSiguiente();
        }

        // Verificar si se encontró el nodo a eliminar
        if (nodoAnterior.getSiguiente() != null) {
            // El nodo a eliminar está en medio o al final de la lista
            NodoSE nodoSiguiente = nodoAnterior.getSiguiente().getSiguiente();
            nodoAnterior.setSiguiente(nodoSiguiente); // Elimina el nodo
            tamano--;
        } else {
            System.out.println("La cuenta a eliminar no está en la lista.");
        }
    }

}
