/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Comunicacion;

import Multiprocesador.Memoria.Memoria;
import java.util.Queue;

/**
 *
 * @author e3r8ick
 */
public class Bus {
    
    private int idBus;
    private Queue<Request> request;
    private Memoria memoria;

    
    public Bus(int idBus,Queue<Request> request, Memoria memoria){
        this.idBus = idBus;
        this.request = request;
        this.memoria = memoria;
    }
    
    private void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getCause());
            Thread.currentThread().interrupt();
        }
    }
    
    public synchronized int procesarTopRequest() throws InterruptedException{
        //tomamos el top y lo removemos
        Request top = request.remove();
        int returnValue = 0;
        
        switch (top.getOperacion()) {
        //leer
            case 0:
                esperar(3);
                returnValue = memoria.leer(top.getDireccion());
        //ecribir
            case 1:
                esperar(3);
                memoria.escribir(top.getDireccion(), top.getIdProcesador());
                returnValue = top.getIdProcesador();
        }
        return returnValue;
    }

    /**
     * @return the idBus
     */
    public int getIdBus() {
        return idBus;
    }

    /**
     * @param idBus the idBus to set
     */
    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    /**
     * @return the request
     */
    public Queue<Request> getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Queue<Request> request) {
        this.request = request;
    }

    /**
     * @return the memoria
     */
    public Memoria getMemoria() {
        return memoria;
    }

    /**
     * @param memoria the memoria to set
     */
    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }
    
}
