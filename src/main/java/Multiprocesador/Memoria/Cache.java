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
public class Cache implements Memoria{
    
    private Bloque[] mem;
    private int tamano;
    private int idCache;
    
    public Cache(int tamano,int idCache){
        mem = new Bloque[tamano];
        this.idCache = idCache;
        this.tamano = tamano;
        for(int i =0; i < tamano; i++){
            mem[i] = new Bloque(2,0);
        }
    }
    
    @Override
    public void escribir(int posicion, int dato) {
        mem[posicion].setValor(dato);
        mem[posicion].setEstado(1);
    }

    @Override
    public int leer(int posicion) {
        return mem[posicion].getValor();
    }

    /**
     * @return the mem
     */
    public Bloque[] getMem() {
        return mem;
    }

    /**
     * @param mem the mem to set
     */
    public void setMem(Bloque[] mem) {
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
            fichero = new FileWriter("outputs/Cache"+idCache+".txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < tamano; i++)
                pw.println("Valor: "+mem[i].getValor()+" Estado "+mem[i].getEstado());

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

    /**
     * @return the idCache
     */
    public int getIdCache() {
        return idCache;
    }

    /**
     * @param idCache the idCache to set
     */
    public void setIdCache(int idCache) {
        this.idCache = idCache;
    }
}
