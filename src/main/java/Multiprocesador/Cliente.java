/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador;

import java.util.Queue; 

/**
 *
 * @author e3r8ick
 */
public class Cliente {
    
    private String nombre;
    private Queue<Integer> carroCompra;
    
    public Cliente(String nombre,Queue<Integer> carroCompra){
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the carroCompra
     */
    public Queue<Integer> getCarroCompra() {
        return carroCompra;
    }

    /**
     * @param carroCompra the carroCompra to set
     */
    public void setCarroCompra(Queue<Integer> carroCompra) {
        this.carroCompra = carroCompra;
    }
}