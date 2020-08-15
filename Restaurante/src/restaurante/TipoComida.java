/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.11
 * @desc 
 */
public class TipoComida {

    public List<Comida> comidas = new ArrayList<Comida>();
    public String nombre = "";
    public Boolean tieneDescuento = false;
    public int descuento = 0;
}
