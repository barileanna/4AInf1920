package it.itis.cuneo;

public class Numero extends Thread {
    private int numero;
    int num;
    int cnt;

    public Numero() {
    }

    public Numero(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        num = numero;
        cnt = 1;
        while(numero >= num/2 ){
            int delay = (int) Math.round((Math.random() * (1000 - 500))+ 500);
            try {
                this.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(numero%cnt == 0){
                numero = numero/cnt;
                System.out.println(num +" : "+ "fattore primo: " + cnt + "\t" + numero);
            }
            cnt++;
        }
        System.out.println(num + ": ha terminato");
    }
}
