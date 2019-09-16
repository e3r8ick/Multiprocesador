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
public class Multiprocesador extends Thread {

    private Procesador[] procesadores;
    private Clock clock;
    
    public Multiprocesador(Procesador[] procesadores){
        this.procesadores = procesadores;
        clock = new Clock();
    }
    
    @Override
    public void run(){
        while(true){
            if(clock.isClock()){
                System.out.println("Clock en True");
                notifyAll();
            }
            else{
                System.out.println("Clock en False");
                clock.cambioFlanco();
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Multiprocesador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
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
