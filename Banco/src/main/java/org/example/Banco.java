package org.example;

public class Banco {
    private ListaSE<Solicitud> solicitudes;
    private ListaSE<Cuenta> cuentas;


    public void adicionarCuenta(Cuenta c){
        cuentas.Agregar(new NodoSE<Cuenta>(c));
    }
    public void eliminarCuenta(NodoSE<Cuenta> c){

        cuentas.Eliminar(c);
    }

    public Banco(ListaSE<Solicitud> solicitudes, ListaSE<Cuenta> cuentas) {
        this.solicitudes = solicitudes;
        this.cuentas = cuentas;

    }

    public ListaSE<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ListaSE<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void setCuentas(ListaSE<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public ListaSE<Cuenta> getCuentas(){
        return cuentas;
    }



    public int VerificarCuenta(NodoSE<Solicitud> s) { //regresa indice de la cuenta
        // Buscar si existe una cuenta para la solicitud
        for (int i = 0; i < cuentas.tamanio(); i++)
            if (cuentas.Obtener(i).getCuenta().getN_identidad() == s.getSolicitud().getN_identidad())
                return i;


        //si no existe la cuenta, crear y agregarla a la lista de cuentas
        NodoSE<Cuenta> nuevaCuenta = new NodoSE<>(new Cuenta(s.getSolicitud().getN_identidad(),s.getSolicitud().getCant_depositar(), cuentas.tamanio()-1));
        cuentas.Agregar(nuevaCuenta);
        return (cuentas.tamanio() - 1); //posición de la nueva cuenta
    }
    public void AtenderTodasLasSolicitudes() {
        for (int i=0;i<solicitudes.tamanio();i++) {
            int tamanioIni= cuentas.tamanio();
            int posicionCuenta = VerificarCuenta(solicitudes.Obtener(i));
            if(tamanioIni==cuentas.tamanio()){
                double cantidad = solicitudes.Obtener(i).getSolicitud().getCant_depositar();
                cuentas.Obtener(posicionCuenta).getCuenta().adicionarSaldo_actual(cantidad);
            }// Agregar el saldo a la cuenta
        }
        //eliminar solicitudes*
        for(int i=0;i<solicitudes.tamanio();i++){
            solicitudes.Eliminar(i);
        }
        // Borrar todas las solicitudes
    }

    public ListaSE<Cuenta> DarBajaAMillonarios() {
        ListaSE<Cuenta> listaDeMillonarios=new ListaSE<Cuenta>(); // crear nueva lista de cuentas para los millonarios

        for(int i=0;i<cuentas.tamanio();i++){
            Cuenta cuentaActual= cuentas.Obtener(i).getCuenta();
            if(cuentaActual.getSaldo_actual()>1_000_000){
                listaDeMillonarios.Agregar(new NodoSE<Cuenta>(cuentaActual)); //agregando a lista de millonarios
                cuentas.Eliminar(i); //borrar a millonario de la lista

            }
        }
        return listaDeMillonarios;
    }
}
