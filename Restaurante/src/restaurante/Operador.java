/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
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
    private final int IVA = 19;
    private final List<TipoComida> categorias = new ArrayList<>();
    private final TipoComida vegetariana = new TipoComida();
    private final TipoComida noVegetariana = new TipoComida();
    private final TipoComida rapida = new TipoComida();
    private int categoriaPadre = 0, categoriaHijo = 0, cantidadPlatos = 0;
    private double precioBase = 0, precioTotal = 0, descuento = 0, iva = 0;

    public Operador() {
        Comida a = new Comida("Sopas de Vegetales", 10000);
        vegetariana.comidas.add(a);
        Comida b = new Comida("Ensaladas", 25000);
        vegetariana.comidas.add(b);
        Comida c = new Comida("Jugos", 5000);
        vegetariana.comidas.add(c);
        vegetariana.nombre = "Vegetariana";
        vegetariana.tieneDescuento = true;
        vegetariana.descuento = 20;

        categorias.add(vegetariana);

        Comida d = new Comida("Bandeja de Carne", 30000);
        noVegetariana.comidas.add(d);
        Comida e = new Comida("Bandeja de Pollo", 28000);
        noVegetariana.comidas.add(e);
        noVegetariana.nombre = "No Vegetariana";
        noVegetariana.tieneDescuento = true;
        noVegetariana.descuento = 10;

        categorias.add(noVegetariana);

        Comida f = new Comida("Perros Calientes", 5000);
        rapida.comidas.add(f);
        Comida g = new Comida("Hamburguesas", 7000);
        rapida.comidas.add(g);
        rapida.nombre = "Rapida";
        rapida.tieneDescuento = false;

        categorias.add(rapida);
    }

    public void _start() {
        imprimir("Bienvenidos a Restaurantes Gómez\n¿Que desea comer?");

        imprimir("");
        for (int i = 0; i < categorias.size(); i++) {
            imprimir("" + (i + 1) + ". " + categorias.get(i).nombre + ".");
        }

        imprimir("");
        imprimir("Digite el menu que quiere probar.");
        categoriaPadre = _entrada.nextInt();

        imprimir("");
        imprimir("Platos del menú " + categorias.get(categoriaPadre).nombre + ".");

        for (int i = 0; i < categorias.get(categoriaPadre).comidas.size(); i++) {
            imprimir("" + (i + 1) + ". " + categorias.get(categoriaPadre).comidas.get(i).nombre + ".");
        }
        imprimir("");

        imprimir("Introduzca el número de plato que quiere probar.");
        categoriaHijo = _entrada.nextInt();

        imprimir("Introduzca la cantidad de platos que va a ordenar.");
        cantidadPlatos = _entrada.nextInt();

        _procesar();
    }

    private void _procesar() {
        imprimir("");
        imprimir("Se procesara su orden.");

        for (int i = 0; i < cantidadPlatos; i++) {
            precioBase += categorias.get(categoriaPadre).comidas.get((categoriaHijo - 1)).valor;
        }

        if (categorias.get(categoriaPadre).tieneDescuento) {
            iva = ((precioBase * IVA) / 100);
            descuento = ((precioTotal * categorias.get(categoriaPadre).descuento) / 100);
            precioTotal = (precioBase + iva) - descuento;
        } else {
            iva = ((precioBase * IVA) / 100);
            precioTotal = (precioBase + iva) - descuento;
        }

        imprimir("Plato Ordenado: " + categorias.get(categoriaPadre).comidas.get((categoriaHijo - 1)).nombre);
        imprimir("Cantidad Ordenada: " + cantidadPlatos);
        imprimir("Precio Bruto: $" + precioBase);
        imprimir("IVA: $" + iva);

        if (categorias.get(categoriaPadre).tieneDescuento) {
            imprimir("Descuento: $" + descuento);
        }

        imprimir("Precio Total: $" + precioTotal);

    }

    private static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    private static void limpiar() {
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
