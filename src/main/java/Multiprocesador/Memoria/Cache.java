/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Memoria;

/**
 *
 * @author e3r8ick
 */
public class Cache implements Memoria{
    
    private int[] mem;
    
    public Cache(int tamano){
        mem = new int[tamano];
    }
    
    @Override
    public void escribir(int posicion, int dato) {
        mem[posicion] = dato;
    }

    @Override
    public int leer(int posicion) {
        return mem[posicion];
    }

    /**
     * @return the mem
     */
    public int[] getMem() {
        return mem;
    }

    /**
     * @param mem the mem to set
     */
    public void setMem(int[] mem) {
        this.mem = mem;
    }
}
