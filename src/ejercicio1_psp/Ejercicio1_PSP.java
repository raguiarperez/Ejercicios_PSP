
package ejercicio1_psp;

/**
 * @author Rafaguiarp
 */
public class Ejercicio1_PSP extends Thread{

    public Ejercicio1_PSP(String str) {
        super(str);
    }

    public void run(){
        for (int i=0;i<10;i++){
            System.out.println(i+" "+getName());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Termina hilo de "+getName());
    }
    public static void main (String [] args) {
        new Ejercicio1_PSP("Pepe").start();
        new Ejercicio1_PSP("Juan").start();
        System.out.println("Termina hilo principal");
    }
}
