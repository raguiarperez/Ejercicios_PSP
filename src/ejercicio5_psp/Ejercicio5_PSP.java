/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5_psp;

import java.util.ArrayList;

/**
 *
 * @author dam2
 */
public class Ejercicio5_PSP extends Thread{


    Thread child;
    String nome;

    public Ejercicio5_PSP(String nome) {
        this(nome, null);
    }

    // constructor que crea un thread  con otro thread hijo, el padre esperara al hijo para finalizar su codigo
    public Ejercicio5_PSP(String nome, Thread child) {
        this.nome  = nome;
        this.child = child;
    }

    @Override
    public void run() {
        if (child != null) {
            try {
                child.join();//esperamos al hijo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hola soy el hilo " + nome);
    }
    
    
    private static void usandoJoin() {
        Ejercicio5_PSP threadB = new Ejercicio5_PSP("B");
        Ejercicio5_PSP threadA = new Ejercicio5_PSP("A", threadB);//thread con un hijo quien debe terminar primero

        threadA.start();
        threadB.start();
    }

    private static void usandoPrioridades() {
        Ejercicio5_PSP threadB = new Ejercicio5_PSP("B");
        Ejercicio5_PSP threadA = new Ejercicio5_PSP("A");
        threadB.setPriority(MAX_PRIORITY);

        startByPrio(threadA, threadB);
    }

    private static void startByPrio(Thread... threads) {//Ordenamos los threads en base a su prioridad para ser iniciados en orden de prioridad
        ArrayList<Thread> list = new ArrayList<>();
        for (int i = 10; i >= 1; i--) {
            for (Thread thread : threads) {
                if (thread.getPriority() == i) {
                    list.add(thread);
                }
            }
        }
        for (Thread thread : list) {
            thread.start();
        }
    }
            public static void main(String[] args) {
        usandoJoin();
        usandoPrioridades();

  
} 
    

}

