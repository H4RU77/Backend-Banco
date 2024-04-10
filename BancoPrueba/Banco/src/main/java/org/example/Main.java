package org.example;

public class Main {
    public static void main(String[] args) {
        ListaSE<Solicitud> solicitudes = new ListaSE<>();
        ListaSE<Cuenta> cuentas = new ListaSE<>();

        // Agregar algunas solicitudes y cuentas
        solicitudes.Agregar(new NodoSE<>(new Solicitud(7, 80000, "Cliente 3")));
        solicitudes.Agregar(new NodoSE<>(new Solicitud(1, 1000.0, "Cliente 1")));
        solicitudes.Agregar(new NodoSE<>(new Solicitud(2, 2000.0, "Cliente 2")));

        System.out.println("Algunas solicitudes: ");
        for (int i = 0; i < solicitudes.tamanio(); i++) {
            System.out.println("N identidad: "+solicitudes.Obtener(i).getSolicitud().getN_identidad()+
                    " Saldo: "+ solicitudes.Obtener(i).getSolicitud().getCant_depositar());
        }

        System.out.println("Algunas cuentas: ");


        cuentas.Agregar(new NodoSE<>(new Cuenta(1, 50000.0, 0)));
        cuentas.Agregar(new NodoSE<>(new Cuenta(2, 2000000.0, 1)));
        for (int i = 0; i < cuentas.tamanio(); i++) {
            System.out.println("N identidad: "+cuentas.Obtener(i).getCuenta().getN_identidad()+
                    " Saldo: "+ cuentas.Obtener(i).getCuenta().getSaldo_actual());
        }

        // Crear instancia del Banco
        Banco banco = new Banco(solicitudes, cuentas);

        // Verificar una cuenta

        //int indiceCuenta= banco.VerificarCuenta(solicitudes.Obtener(2));
       // System.out.println("Índice de la cuenta verificada: "+indiceCuenta );



        // Atender todas las solicitudes
        System.out.println("\nAtender todas las solicitudes");
        banco.AtenderTodasLasSolicitudes();
        System.out.println("Cuentas actualizadas: ");
        for (int i = 0; i < cuentas.tamanio(); i++) {
            System.out.println("N identidad: "+cuentas.Obtener(i).getCuenta().getN_identidad()+
                    " Saldo: "+ cuentas.Obtener(i).getCuenta().getSaldo_actual());
        }
        System.out.println("\nDar de baja a millonarios");

        // Dar de baja a los millonarios
        ListaSE<Cuenta> listaMillonarios = banco.DarBajaAMillonarios();

        System.out.println("Cuentas actualizadas: ");
        for (int i = 0; i < cuentas.tamanio(); i++) {
            System.out.println("N identidad: "+cuentas.Obtener(i).getCuenta().getN_identidad()+
                    " Saldo: "+ cuentas.Obtener(i).getCuenta().getSaldo_actual());
        }


        // Imprimir cuentas de millonarios
        System.out.println("Cuentas de millonarios:");

        for (int i = 0; i < listaMillonarios.tamanio(); i++) {
            System.out.println("N identidad: "+listaMillonarios.Obtener(i).getCuenta().getN_identidad()+
                    " Saldo: "+ listaMillonarios.Obtener(i).getCuenta().getSaldo_actual());
        }




    }

}