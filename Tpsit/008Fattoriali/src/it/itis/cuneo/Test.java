package it.itis.cuneo;

public class Test {
    public static void main(String[] args) {

        Thread1 th1 = new Thread1(5);
        th1.start();
        try{
            th1.join();
            System.out.println("Fattoriale[" + th1.getNumero() + "]: " + th1.getFattoriale());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
