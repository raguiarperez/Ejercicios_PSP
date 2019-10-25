/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3_psp;

/**
 *
 * @author dam2
 */
public class Ejercicio3_PSP extends Thread{

    public Ejercicio3_PSP(String str) {
        super(str);
    }

    public void run(){
        for (int i=0;i<5;i++){
            System.out.println(i+" "+getName());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Termina hilo de "+getName());
    }
    public static void main (String [] args) throws InterruptedException {
        Ejercicio3_PSP Pepe= new Ejercicio3_PSP("Pepe");
        Ejercicio3_PSP Juan= new Ejercicio3_PSP("Juan");
        Ejercicio3_PSP Rafa= new Ejercicio3_PSP("Rafa");
        Ejercicio3_PSP Javi= new Ejercicio3_PSP("Javi");
        
        //START
        Pepe.start();
        Juan.start();
        Rafa.start();
        Javi.start();
        
        //JOIN
        Pepe.join();
        Juan.join();
        Rafa.join();
        Javi.join();
        
        System.out.println("Termina hilo principal");
    }
}