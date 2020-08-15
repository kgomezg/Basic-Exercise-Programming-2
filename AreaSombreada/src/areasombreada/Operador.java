/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areasombreada;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.11
 * @desc
 */
public class Operador {

    private final double PI = Math.PI;
    private double radio = 0;
    private Scanner _entrada = new Scanner(System.in);

    public void _start() {
        imprimir("Digite el radio del circulo inscrito");
        radio = Double.parseDouble(_entrada.nextLine());

        _procesar();
    }

    private void _procesar() {
        double respuesta = (PI * Math.pow(radio, 2)) - (2 * (Math.pow(radio, 2)));

        imprimir("Área sombreada : " + respuesta + " cm²");
    }

    private static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    public static void limpiar() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        } catch (AWTException e) {
            imprimir(e.getMessage());
        }
    }

}
