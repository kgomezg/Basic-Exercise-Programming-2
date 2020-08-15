/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colectivo;

import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.07
 * @desc
 */
public class Operador {

    private static final int PRECIOVIAJE = 10000, FLETEVIAJE = 2000;
    private int cantidadPersonasColectivo = 0, cantidadPersonasHotel = 0;
    private Scanner _entrada = new Scanner(System.in);

    public void _start() {

        imprimir("Escriba la cantidad de personas que pueden viajar en el colectivo.");
        cantidadPersonasColectivo = _entrada.nextInt();

        imprimir("Escriba la cantidad de personas que van al hotel.");
        cantidadPersonasHotel = _entrada.nextInt();

        imprimir("Se procesara la información");

        _procesar();
    }

    private void _procesar() {
        imprimir("");
        int cantidadViajes = Math.round(cantidadPersonasHotel / cantidadPersonasColectivo), cantidadTotalViaje = (cantidadPersonasHotel * PRECIOVIAJE), cantidadTotalFleteViaje = (cantidadPersonasHotel * FLETEVIAJE);

        imprimir("Cantidad de viajes: " + cantidadViajes);

        imprimir("Cantidad total que pagan los turistas: " + cantidadTotalViaje);

        imprimir("Cantidad total que paga el conductor: " + cantidadTotalFleteViaje);

    }

    private void imprimir(String mensaje) {
        System.out.println(mensaje);
    }
}
