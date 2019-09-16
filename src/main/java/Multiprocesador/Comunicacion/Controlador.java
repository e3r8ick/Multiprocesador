/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Comunicacion;

import Multiprocesador.Procesamiento.Cpu;

/**
 *
 * @author e3r8ick
 */
public class Controlador {
    
    private int idControlador;
    private Bus bus;
    
    public Controlador(int idControlador, Bus bus){
        this.idControlador = idControlador;
        this.bus = bus;
    }
    
    public int escribirMemoria(Cpu cpu, int dato, int direccion) throws InterruptedException{
        System.out.println("Controlador Escribiendo en direccion "+direccion+" para Procesador "+cpu.getId());
        bus.getRequest().add(new Request(1,cpu.getId(), direccion));
        return bus.procesarTopRequest();
    }
    
    public int leerMemoria(Cpu cpu, int direccion) throws InterruptedException{
        System.out.println("Controlador Leyendo en direccion "+direccion+" para Procesador"+cpu.getId());
        bus.getRequest().add(new Request(0,cpu.getId(), direccion));
        return bus.procesarTopRequest();
    }
    /**
     * @return the idControlador
     */
    public int getIdControlador() {
        return idControlador;
    }

    /**
     * @param idControlador the idControlador to set
     */
    public void setIdControlador(int idControlador) {
        this.idControlador = idControlador;
    }

    /**
     * @return the bus
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * @param bus the bus to set
     */
    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
