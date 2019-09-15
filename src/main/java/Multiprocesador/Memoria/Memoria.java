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
public interface Memoria {
    
    public void escribir(int posicion, int dato);
    public int leer(int posicion);

}
