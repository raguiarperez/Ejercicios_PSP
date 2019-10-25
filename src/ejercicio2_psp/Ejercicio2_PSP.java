
package ejercicio2_psp;

/**
 * @author dam2
 */
public class Ejercicio2_PSP extends Thread {

    public Ejercicio2_PSP(String str) {
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
        Ejercicio2_PSP Pepe= new Ejercicio2_PSP("Pepe");
        Ejercicio2_PSP Juan= new Ejercicio2_PSP("Juan");
        Ejercicio2_PSP Rafa= new Ejercicio2_PSP("Rafa");
        Ejercicio2_PSP Javi= new Ejercicio2_PSP("Javi");
        
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