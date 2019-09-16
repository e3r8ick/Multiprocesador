/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiprocesador;

import Multiprocesador.Comunicacion.Bus;
import Multiprocesador.Comunicacion.Clock;
import Multiprocesador.Comunicacion.Controlador;
import Multiprocesador.Comunicacion.Request;
import Multiprocesador.Memoria.Cache;
import Multiprocesador.Memoria.MemoriaPrincipal;
import Multiprocesador.Procesamiento.Cpu;
import Multiprocesador.Procesamiento.Instruccion;
import Multiprocesador.Procesamiento.Procesador;
import java.io.FileWriter;
import java.io.PrintWriter;
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
	public static void main(String[] args) throws InterruptedException {
            //inicialización de las instrucciones par que tenga algo cuando empieza
            Queue<Instruccion> instruiccionesProcesador1 = new LinkedList<>();
            Queue<Instruccion> instruiccionesProcesador2 = new LinkedList<>(); 
            Queue<Instruccion> instruiccionesProcesador3 = new LinkedList<>(); 
            Queue<Instruccion> instruiccionesProcesador4 = new LinkedList<>(); 
            
            //calculo binomial para cada procesador
            for (int i=0; i<=10; i++){
                instruiccionesProcesador1.add(new Instruccion(probabilidadBinomial(2,0.80), (int) (Math.random()*15),1));
                instruiccionesProcesador2.add(new Instruccion(probabilidadBinomial(2,0.10), (int) (Math.random()*15),2));
                instruiccionesProcesador3.add(new Instruccion(probabilidadBinomial(2,0.70), (int) (Math.random()*15),3));
                instruiccionesProcesador4.add(new Instruccion(probabilidadBinomial(2,0.50), (int) (Math.random()*15),4));
            }
        
            //cola de request para el bus
            Queue<Request> requestBus = new LinkedList<>();
            
            //Bus global
            Bus bus = new Bus(1,requestBus,new MemoriaPrincipal(16));
            
            //Clock global
            Clock clock = new Clock();
            
            //creacion de los procesadores
            Procesador procesador1 = new Procesador(1,instruiccionesProcesador1,
                    new Controlador(1,bus),new Cache(8,1),new Cpu(1),clock);
            Procesador procesador2 = new Procesador(2,instruiccionesProcesador2,
                    new Controlador(2,bus),new Cache(8,2),new Cpu(2),clock);
            Procesador procesador3 = new Procesador(3,instruiccionesProcesador3,
                    new Controlador(3,bus),new Cache(8,3),new Cpu(3),clock);
            Procesador procesador4 = new Procesador(4,instruiccionesProcesador4,
                    new Controlador(4,bus),new Cache(8,4),new Cpu(4),clock);
            
            Procesador[] procesadores = {procesador1,
                                         procesador2,
                                         procesador3,
                                         procesador4};
            
            Multiprocesador multiprocesador = new Multiprocesador(procesadores,clock);
            procesador1.guardarInstrucciones();
            procesador2.guardarInstrucciones();            
            procesador3.guardarInstrucciones();
            procesador4.guardarInstrucciones();
            
            procesador1.start();
            procesador2.start();            
            procesador3.start();
            procesador4.start();
            
            for(int i = 0; i<10; i++){
                clock.cambioFlanco();
                System.out.println("Cambiamos a: "+multiprocesador.getClock().isClock());
                multiprocesador.getProcesadores()[0].getControlador().getBus().getMemoria().guardarMemoria();
                multiprocesador.getProcesadores()[0].getCache().guardarMemoria();
                multiprocesador.getProcesadores()[1].getCache().guardarMemoria();
                multiprocesador.getProcesadores()[2].getCache().guardarMemoria();
                multiprocesador.getProcesadores()[3].getCache().guardarMemoria();
                
                Thread.sleep(5000);
            }


	}
} 
