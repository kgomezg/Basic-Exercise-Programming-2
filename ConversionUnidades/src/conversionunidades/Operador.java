/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversionunidades;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.07
 * @desc
 */
public class Operador {

    private static final double PULGADAPIES = 0.0833, PULGADACENTIMETROS = 2.54, PULGADALEGUA = 190080.02, PULGADAYARDA = 36;
    private String unidadMedida = "";
    private final List<String> parametros;
    private final Scanner _entrada = new Scanner(System.in);

    private final String unidades = "P,C,L,Y";
    private String inicial = "";
    private double valorConvertir = 0, pulgadas = 0;

    public Operador() {
        parametros = Arrays.asList(unidades.split(","));
    }

    public void _start() {

        if (unidadMedida.equals("")) {
            imprimir("Escriba la unidad de medida (‘P’ para pie, ‘C’ para centímetro, ‘L’ para legua, y ‘Y’ para yarda).");
            unidadMedida = _entrada.next().toUpperCase();
        } else if (!parametros.contains(unidadMedida)) {
            imprimir("Escriba la unidad de medida (‘P’ para pie, ‘C’ para centímetro, ‘L’ para legua, y ‘Y’ para yarda).");
            unidadMedida = _entrada.next().toUpperCase();
        }

        if (valorConvertir == 0) {
            imprimir("Escriba el valor a convertir (Recuerde usar las comas).");
            valorConvertir = _entrada.nextDouble();
        }

        if ((!unidadMedida.equals("") && parametros.contains(unidadMedida)) && valorConvertir != 0) {

            _procesar();
        }

    }

    private void _procesar() {
        limpiar();

        switch (unidadMedida) {
            case "P" -> {
                pulgadas = (valorConvertir / PULGADAPIES);
                inicial = "P";
            }
            case "C" -> {
                pulgadas = (valorConvertir / PULGADACENTIMETROS);
                inicial = "C";
            }
            case "L" -> {
                pulgadas = (valorConvertir * PULGADALEGUA);
                inicial = "L";
            }
            case "Y" -> {
                pulgadas = (valorConvertir * PULGADAYARDA);
                inicial = "Y";
            }
            default -> {
                unidadMedida = "";
                valorConvertir = 0;
                limpiar();

                _start();
            }
        }

        imprimir("Se procesara la información");
        imprimir("Unidad Medida: " + inicial + ", Valor Ingresado: " + valorConvertir);
        imprimir("Pulgadas: " + pulgadas);
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
