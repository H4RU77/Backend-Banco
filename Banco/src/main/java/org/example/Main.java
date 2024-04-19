package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        ListaSE<Solicitud> solicitudes = new ListaSE<>();
        ListaSE<Cuenta> cuentas = new ListaSE<>();

        // Agregar algunas solicitudes y cuentas
        solicitudes.Agregar(new NodoSE<>(new Solicitud(1, 1000.0, "Cliente 1")));
        solicitudes.Agregar(new NodoSE<>(new Solicitud(2, 2000.0, "Cliente 2")));
        System.out.println("Agregar algunas solicitudes: ");
        for (int i = 0; i < solicitudes.tamanio(); i++) {
            System.out.println("No. de identidad: "+solicitudes.Obtener(i).getSolicitud().getN_identidad()+", Saldo: "+solicitudes.Obtener(i).getSolicitud().getCant_depositar());
        }



        cuentas.Agregar(new NodoSE<>(new Cuenta(1, 50000.0, 0)));
        cuentas.Agregar(new NodoSE<>(new Cuenta(2, 2000000.0, 1)));
        System.out.println("Agregar algunas cuentas: ");
        for (int i = 0; i < cuentas.tamanio(); i++) {
            System.out.println("No. de identidad: "+cuentas.Obtener(i).getCuenta().getN_identidad()+", Saldo: "+cuentas.Obtener(i).getCuenta().getSaldo_actual());
        }

        // Crear instancia del Banco
        Banco banco = new Banco(solicitudes, cuentas);

        // Verificar una cuenta

        int indiceCuenta = banco.VerificarCuenta(new NodoSE<>(new Cuenta(7, 30000.0, 2 )));
        System.out.println("Verificar cuenta con los datos: "+"No. de identidad: 7, "+"Saldo actual: 30000.0");
        System.out.println("Índice de la cuenta verificada: " + indiceCuenta);

        // Atender todas las solicitudes
        banco.AtenderTodasLasSolicitudes();
        System.out.println("Cuentas actualizadas");
        for (int i = 0; i < cuentas.tamanio(); i++) {
            System.out.println("No. de identidad: "+cuentas.Obtener(i).getCuenta().getN_identidad()+", Saldo: "+cuentas.Obtener(i).getCuenta().getSaldo_actual());
        }

        // Dar de baja a los millonarios
        ListaSE<Cuenta> listaMillonarios = banco.DarBajaAMillonarios();

        // Imprimir cuentas de millonarios
        System.out.println("Cuentas de millonarios:");
        for (int i = 0; i < listaMillonarios.tamanio(); i++) {
            System.out.println("No. de identidad: "+listaMillonarios.Obtener(i).getCuenta().getN_identidad()+", Saldo actual: "+listaMillonarios.Obtener(i).getCuenta().getSaldo_actual());
        }
    }

}