package org.example;

public class ListaDeSolicitudes {
    private Solicitud cabeza;
    private int tamano;

    public ListaDeSolicitudes(){
        this.tamano=0;
    }

    public boolean EsVacia(){
        if(cabeza==null){
            return true;
        }else{
            return false;
        }
    }
    public int tamanio() {
        int tamanio = 0;
        Solicitud solicitudActual = cabeza;
        if(solicitudActual.getSiguienteSolicitud()!=null){
            solicitudActual=solicitudActual.getSiguienteSolicitud();
        }
        while (solicitudActual != null) {
            tamanio++;
            if (solicitudActual.getSiguienteSolicitud() != null) {
                solicitudActual = solicitudActual.getSiguienteSolicitud();
            } else {
                break;
            }
        }
        return tamanio;
    }
    public Solicitud ObtenerSolicitud(int pos){
        if(pos<tamano && pos>=0){
            int contador=0; Solicitud solicitudActual;
            solicitudActual=cabeza;
            while(contador<pos){
                solicitudActual = solicitudActual.getSiguienteSolicitud();
                contador++;
            }

            return solicitudActual;
        }else{
            System.out.println("Posición inválida");
            return null;
        }
    }
    public void AgregarSolicitud(Solicitud nuevaSolicitud){

        if(EsVacia()){
            cabeza = nuevaSolicitud;
        }else{
            Solicitud ultimaSolicitud=cabeza;
            while(ultimaSolicitud.getSiguienteSolicitud()!=null){
                ultimaSolicitud = ultimaSolicitud.getSiguienteSolicitud();
            }
            ultimaSolicitud.setSiguienteSolicitud(nuevaSolicitud);

        }
        System.out.println("Solicitud del número de identidad "+nuevaSolicitud.getN_identidad()+" creada exitosamente.");

    }
    public void EliminarSolicitud(int pos){

        if(pos<tamano && pos>=0){
            if(pos==0){
                cabeza= cabeza.getSiguienteSolicitud(); //solo queda la cabeza apuntando a null
            }else{
                Solicitud solicitudAnterior = cabeza;
                for(int i=0;i<pos;i++){
                    solicitudAnterior=solicitudAnterior.getSiguienteSolicitud();
                }
                Solicitud solicitudAEliminar = solicitudAnterior.getSiguienteSolicitud(); //el siguiente a nodo Anterior es el que se va a eliminar
                solicitudAnterior.setSiguienteSolicitud(solicitudAEliminar.getSiguienteSolicitud()); //apuntar el anterior al nodo que sigue despues del nodo a eliminar
                solicitudAEliminar.setSiguienteSolicitud(null);//terminar de desconectar el nodo
            }

        }
        else{
            System.out.println("Posición inválida");
        }



    }
}
