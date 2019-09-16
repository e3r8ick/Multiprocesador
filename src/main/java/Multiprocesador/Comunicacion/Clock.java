/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Comunicacion;

/**
 *
 * @author e3r8ick
 */
public class Clock {
    
    private boolean clock;
    
    public Clock(){
        clock = true;
    }
    
    public boolean cambioFlanco(){
        if(clock){
            clock = false;
        }
        else{
            clock = true;
        }
        return clock;
    }

    /**
     * @return the clock
     */
    public boolean isClock() {
        return clock;
    }

    /**
     * @param clock the clock to set
     */
    public void setClock(boolean clock) {
        this.clock = clock;
    }
    
}
