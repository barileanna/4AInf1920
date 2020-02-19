package it.itis.cuneo;
/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class GrafoPrecedenza {

    public static void main(String[] args) {
        Buffer c1 = new Buffer();
        c1.setA(5);
        c1.setB(4);

        Thread1 th1 = new Thread1(c1);
        Thread2 th2 = new Thread2(c1);
        Thread3 th3 = new Thread3(c1);

        th1.start();
        th2.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th3.start();
        try {
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Il risultato dell'espressione è: "+c1.getZ() + "\n");
    }
}