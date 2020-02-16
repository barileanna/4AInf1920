package it.itis.cuneo;

public class Thread1 extends Thread {
    private int numero;
    private int fattoriale;

    public Thread1() {
    }

    public Thread1(int num) {
        this.numero = num;
        this.fattoriale = num;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getFattoriale() {
        return fattoriale;
    }

    public void setFattoriale(int fattoriale) {
        this.fattoriale = fattoriale;
    }

    public void run(){
        if(this.fattoriale > 1) {

            Thread1 thread1 = new Thread1(this.numero - 1);
            thread1.start();
            try {
                thread1.join();

                System.out.println("Fattoriale[" + thread1.numero + "]: " + thread1.fattoriale);
                this.fattoriale = this.numero * thread1.getFattoriale();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
