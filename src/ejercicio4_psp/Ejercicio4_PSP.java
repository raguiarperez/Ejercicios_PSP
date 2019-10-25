/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4_psp;

import java.util.Scanner;

/**
 *
 * @author dam2
 */
public class Ejercicio4_PSP extends Thread {

    //sm = 0 suma pares
    //sm = 1 suma inpares
    //sm = 2 suma terminaciones 2 y 3
    
    private int sm = 0;

    //constructor que determina la suma a realizar
    public Ejercicio4_PSP(int sw) {
        this.sm = sw;
    }

    @Override
    public void run() {
        int sum = 0;
        switch (sm) {
            case 0:
                for (int i = 1; i < 1000; i++) {
                    if (i % 2 == 0)
                        sum += i;
                }
                break;
            case 1:
                for (int i = 1; i < 1000; i++) {
                    if (i % 2 != 0)
                        sum += i;
                }
                break;
            case 2:
                for (int i = 1; i < 1000; i++) {
                    String parsed = Integer.toString(i);
                    if (parsed.endsWith("2") || parsed.endsWith("3")) {
                        sum += i;
                    }
                }
                break;
        }
        System.out.println("Thread " + sm + " sum: " + sum);
    }

    public static void main(String[] args) {
        Ejercicio4_PSP pares = new Ejercicio4_PSP(0);
        Ejercicio4_PSP inpares = new Ejercicio4_PSP(1);
        Ejercicio4_PSP dosytres = new Ejercicio4_PSP(2);

        pares.start();
        inpares.start();
        dosytres.start();
    }
}
 