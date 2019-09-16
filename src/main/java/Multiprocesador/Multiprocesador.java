/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador;

import Multiprocesador.Comunicacion.Clock;
import Multiprocesador.Procesamiento.Procesador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e3r8ick
 */
public class Multiprocesador{

    private Procesador[] procesadores;
    private Clock clock;
    
    public Multiprocesador(Procesador[] procesadores, Clock clock){
        this.procesadores = procesadores;
        this.clock = clock;
    }
    

    
    /**
     * @return the procesadores
     */
    public Procesador[] getProcesadores() {
        return procesadores;
    }

    /**
     * @param procesadores the procesadores to set
     */
    public void setProcesadores(Procesador[] procesadores) {
        this.procesadores = procesadores;
    }

    /**
     * @return the clock
     */
    public Clock getClock() {
        return clock;
    }

    /**
     * @param clock the clock to set
     */
    public void setClock(Clock clock) {
        this.clock = clock;
    }    
}
