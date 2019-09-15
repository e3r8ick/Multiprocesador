/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Procesamiento;

import Multiprocesador.Comunicacion.Controlador;
import Multiprocesador.Memoria.Cache;
import java.util.Queue;

/**
 *
 * @author e3r8ick
 */
public class Procesador extends Thread {

    private int idProcesador;
    private Queue<Integer> instrucciones;
    private Controlador controlador;
    private Cache cache;
    private Cpu cpu;

    public Procesador(int idProcesador, Queue<Integer> instrucciones){
        this.idProcesador = idProcesador;
        this.instrucciones = instrucciones;
    }
    
    public void procesarInstruccion(){
        //tomamos la instruccion top
        int top = instrucciones.remove();
        
        switch (top) {
        //leer
            case 0:
                
        //ecribir
            case 1:
                
        //procesar
            case 2:
                esperar(1);
        }
    }

    @Override
    public void run() {
        procesarInstruccion();
    }

    private void esperar(int segundos) {
            try {
                    Thread.sleep(segundos * 1000);
            } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
            }
    }  

    /**
     * @return the idProcesador
     */
    public int getIdProcesador() {
        return idProcesador;
    }

    /**
     * @param idProcesador the idProcesador to set
     */
    public void setIdProcesador(int idProcesador) {
        this.idProcesador = idProcesador;
    }

    /**
     * @return the instrucciones
     */
    public Queue<Integer> getInstrucciones() {
        return instrucciones;
    }

    /**
     * @param instrucciones the instrucciones to set
     */
    public void setInstrucciones(Queue<Integer> instrucciones) {
        this.instrucciones = instrucciones;
    }

    /**
     * @return the controlador
     */
    public Controlador getControlador() {
        return controlador;
    }

    /**
     * @return the cache
     */
    public Cache getCache() {
        return cache;
    }

    /**
     * @param cache the cache to set
     */
    public void setCache(Cache cache) {
        this.cache = cache;
    }

    /**
     * @return the cpu
     */
    public Cpu getCpu() {
        return cpu;
    }

    /**
     * @param cpu the cpu to set
     */
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }
}
