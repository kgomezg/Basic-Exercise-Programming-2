/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impuestosvehiculos;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.11
 * @desc
 */
public class Operador {

    private final Scanner _entrada = new Scanner(System.in);
    private final String tipos = "A,C";
    private final List<String> parametros;
    private double precioBruto = 0;
    private String tipoVehiculo = "";


    public Operador() {
        parametros = Arrays.asList(tipos.split(","));
    }

    public void _start() {

        if (tipoVehiculo.equals("")) {
            imprimir("Digite el tipo de vehículo. ('A' para Automovíl o 'C' para Camioneta).");
            tipoVehiculo = _entrada.next().toUpperCase();
        } else if (!parametros.contains(tipoVehiculo)) {
            imprimir("Digite el tipo de vehículo. ('A' para Automovíl o 'C' para Camioneta).");
            tipoVehiculo = _entrada.next().toUpperCase();
        }

        if (precioBruto == 0) {
            imprimir("Escriba el precio bruto.");
            precioBruto = _entrada.nextDouble();
        }

        if ((!tipoVehiculo.equals("") && parametros.contains(tipoVehiculo)) && precioBruto != 0) {
            _procesar();
        } else {
            tipoVehiculo = (parametros.contains(tipoVehiculo) == true ? tipoVehiculo : "");
            precioBruto = (precioBruto != 0 ? precioBruto : 0);

            _start();
        }

    }

    private void _procesar() {

        imprimir("");
        imprimir("Se procesara la información");

        double impuesto = 0;

        switch (tipoVehiculo) {
            case "A" -> {
                if (precioBruto < 20) {
                    impuesto = 5;
                } else if (precioBruto >= 20 && precioBruto <= 40) {
                    impuesto = precioBruto / 5;
                } else if (precioBruto > 40) {
                    impuesto = 9;
                }
            }
            case "C" -> {
                if (precioBruto >= 80) {
                    impuesto = precioBruto / 2;
                }
            }
            default -> {
                tipoVehiculo = "";
                precioBruto = 0;
                limpiar();

                _start();
            }
        }

        imprimir("Tipo Vehiculo: " + (tipoVehiculo.equals("A") ? "Automovil" : "Camioneta"));
        imprimir("Precio Bruto Ingresado: " + precioBruto);
        imprimir("Impuesto : " + impuesto);
        imprimir("Valor Neto: " + (impuesto + precioBruto));
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
