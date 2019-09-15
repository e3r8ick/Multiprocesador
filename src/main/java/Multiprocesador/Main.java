/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador;

import Multiprocesador.Procesamiento.Procesador;
import java.util.LinkedList; 
import java.util.Queue; 

/**
 *
 * @author e3r8ick
 */
public class Main {
    
    //funcion de probabilidad binomial
    public static int probabilidadBinomial (int n, double p){
    int x=0;
    int i = 1;
    double ui;
    while (i<=n){
        ui = Math.random();
        if (ui <= p){
          x++;
         }
        i++;
    }
    return x;
  }


    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
            //inicialización de las instrucciones par que tenga algo cuando empieza
            Queue<Integer> instruiccionesProcesador1 = new LinkedList<>();
            Queue<Integer> instruiccionesProcesador2 = new LinkedList<>(); 
            Queue<Integer> instruiccionesProcesador3 = new LinkedList<>(); 
            Queue<Integer> instruiccionesProcesador4 = new LinkedList<>(); 
            
            //calculo binomial para cada procesador
            for (int i=0; i<=5; i++){
                instruiccionesProcesador1.add(probabilidadBinomial(3,0.50));
                instruiccionesProcesador2.add(probabilidadBinomial(3,0.70));
                instruiccionesProcesador3.add(probabilidadBinomial(3,0.2));
                instruiccionesProcesador4.add(probabilidadBinomial(3,0.90));
            }

            // Tiempo inicial de referencia
            long initialTime = System.currentTimeMillis();
            Procesador cajera1 = new Procesador(1, cliente1, initialTime,instruiccionesProcesador1);
            Procesador cajera2 = new Procesador(2, cliente1, initialTime,instruiccionesProcesador2);
            Procesador cajera3 = new Procesador(3, cliente1, initialTime,instruiccionesProcesador3);
            Procesador cajera4 = new Procesador(4, cliente1, initialTime,instruiccionesProcesador4);

            cajera1.start();
            cajera2.start();            
            cajera3.start();
            cajera4.start();


	}
} 
