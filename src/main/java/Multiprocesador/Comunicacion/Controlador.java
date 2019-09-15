/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Comunicacion;

import Multiprocesador.Memoria.Memoria;
import Multiprocesador.Procesamiento.Cpu;

/**
 *
 * @author e3r8ick
 */
public class Controlador {
    
    private int idControlador;
    
    public Controlador(int idControlador){
        this.idControlador = idControlador;
    }
    
    public void escribirMemoria(Cpu cpu,Memoria memoria){
        
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
}
