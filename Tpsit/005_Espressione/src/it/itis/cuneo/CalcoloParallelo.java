package it.itis.cuneo;

public class CalcoloParallelo {
    public static void main(String[] args) {
        double a, b;
        a = 2;
        b = 3;
        System.out.println("Devo calcolare: [4*(a-2)+5]*[2*(b-3)+4]\n");
        Buffer parziali = new Buffer(a,b);
        Operazione1 thr1 = new Operazione1(parziali);
        Operazione2 thr2 = new Operazione2(parziali);
        Operazione3 thr3 = new Operazione3(parziali);

        thr1.start();
        thr2.start();

        try{
            thr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Errore thr1");
        }try{
            thr1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Errore thr2");
        }

        thr3.start();
        try{
            thr3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Errore thr3");
        }
    }

}
