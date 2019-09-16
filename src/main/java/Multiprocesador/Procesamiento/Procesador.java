/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Procesamiento;

import Multiprocesador.Comunicacion.Controlador;
import Multiprocesador.Memoria.Cache;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e3r8ick
 */
public class Procesador extends Thread {

    private int idProcesador;
    private Queue<Instruccion> instrucciones;
    private Controlador controlador;
    private Cache cache;
    private Cpu cpu;

    public Procesador(int idProcesador, Queue<Instruccion> instrucciones, 
            Controlador controlador, Cache cache, Cpu cpu){
        this.idProcesador = idProcesador;
        this.instrucciones = instrucciones;
        this.cache = cache;
        this.controlador = controlador;
        this.cpu = cpu;
    }
    
    public void procesarInstruccion() throws InterruptedException{
        while(instrucciones.size() !=0){
            //tomamos la instruccion top
            Instruccion top = instrucciones.remove();
            int returnValue = 0;

            switch (top.getOperacion()) {
            //leer
                case 0:
                   System.out.println("Procesador "+idProcesador+" Leyendo en direccion "+top.getDireccion());
                   int asociatividad = 0;
                   switch(controlador.leerMemoria(cpu, top.getDireccion())){
                       case 9:
                           asociatividad = 1;
                       case 10:
                           asociatividad = 2;
                       case 11:
                           asociatividad = 3;
                       case 12:
                           asociatividad = 4;
                       case 13:
                           asociatividad = 5;
                       case 14:
                           asociatividad = 6;
                       case 15:
                           asociatividad = 7;
                   }
                   cache.escribir(asociatividad, idProcesador);
            //ecribir
                case 1:
                    System.out.println("Procesador "+idProcesador+" Escribibiendo en direccion "+top.getDireccion());
                    returnValue = controlador.escribirMemoria(cpu, idProcesador, top.getDireccion());
            //procesar
                case 2:
                    System.out.println("Procesador "+idProcesador+" Procesando en direccion "+top.getDireccion());
                    esperar(1);
            }
        }
    }

    @Override
    public void run() {
        try {
            procesarInstruccion();
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void esperar(int segundos) {
            try {
                    Thread.sleep(segundos * 1000);
            } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
            }
    }  
    
    public void guardarInstrucciones(){
        Queue<Instruccion> instruccionesC = instrucciones;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("outputs/Instrucciones"+idProcesador+".txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < instrucciones.size(); i++){
                Instruccion top = instruccionesC.remove();
                pw.println("Instruccion: "+top.getOperacion()+" Direccion: "+top.getDireccion());
            }
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
    public Queue<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    /**
     * @param instrucciones the instrucciones to set
     */
    public void setInstrucciones(Queue<Instruccion> instrucciones) {
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
