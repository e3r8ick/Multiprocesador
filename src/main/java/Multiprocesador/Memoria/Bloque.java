/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador.Memoria;

/**
 *
 * @author e3r8ick
 */
public class Bloque {
    
    private int estado;//0 = Privado
                       //1 = Compartido
                       //2 = Inválido
    private int valor;
    private int etiqueta;
    
    public Bloque(int estado, int valor){
        this.estado = estado;
        this.valor = valor;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the etiqueta
     */
    public int getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
}
