import java.lang.*;
import java.lang.Thread;

/**
 * Created by inf.barilea1810 on 23/01/2020.
 */
public class Random extends Thread{
    public int numeroRandom;
    public int numero;

    public Random(){
        super();
        this.numero = 0;
    }

    public Random(int numeroRandom){
        this.numeroRandom = numeroRandom;
        this.numero = 0;
    }

    public int getNumeroRandom() {
        return numeroRandom;
    }

    public void setNumeroRandom(int numeroRandom) {
        this.numeroRandom = numeroRandom;
    }

    @Override
    public void run() {
            numeroRandom = (int) Math.random() * 2;
            numero = numero + numeroRandom;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        Thread thr1 = new Thread();
        Thread thr2 = new Thread();

        thr1.start();
        thr2.start();

        if(thr1>10){
            System.out.println("Thread 1: VITTORIA");
        }
        if(thr2>10) {

        }
    }
}
