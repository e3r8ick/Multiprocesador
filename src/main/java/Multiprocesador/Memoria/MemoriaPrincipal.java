/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Memoria;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author e3r8ick
 */
public class MemoriaPrincipal implements Memoria{
    
    private int[] mem;
    private int tamano;
    
    public MemoriaPrincipal(int tamano){
        this.tamano = tamano;
        mem = new int[tamano];
        for(int i =0; i < tamano; i++){
            mem[i] = 0;
        }
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

    @Override
    public void printMemoria() {
        System.out.println("Memoria:");
       for(int i = 0; i < tamano; i++){
           System.out.println("Posicion "+i+": "+mem[i]);
       }
        System.out.println("");
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public void guardarMemoria() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("outputs/Memoria.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < tamano; i++)
                pw.println(mem[i]);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
