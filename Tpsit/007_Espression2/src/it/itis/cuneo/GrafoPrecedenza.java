package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class GrafoPrecedenza {

    public static void main(String[] args) {
        Buffer c1 = new Buffer();
        Buffer c2 = new Buffer();

        c1.setA(5);
        c2.setA(5);
        c1.setB(4);
        c2.setB(4);

        Thread1 th1 = new Thread1(c1);
        Thread2 th2 = new Thread2(c1);
        Thread3 th3 = new Thread3(c2);
        Thread4 th4 = new Thread4(c2);
        Thread5 th5 = new Thread5(c1,c2);

        th1.start();
        th3.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th2.start();
        th4.start();
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th5.start();
        try {
            th5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Il risultato dell'espressione è: "+c1.getZ() + "\n");
    }
}
