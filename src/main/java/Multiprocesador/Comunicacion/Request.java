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
public class Request {
    
    private int operacion;
    private int idProcesador;//0 = leer 
                             //1 = escribir
    private int direccion;

    
    public Request(int operacion, int idProcesador, int direccion){
        this.idProcesador =  idProcesador;
        this.operacion = operacion;
        this.direccion = direccion;
    }

    /**
     * @return the operacion
     */
    public int getOperacion() {
        return operacion;
    }

    /**dark
     * @param operacion the operacion to set
     */
    public void setOperacion(int operacion) {
        this.operacion = operacion;
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
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
}
