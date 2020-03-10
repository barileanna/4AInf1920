package it.itis.cuneo;

import java.util.Random;

//classe thread
public class Stringa extends Thread {
    public static final int MAX = 3000;
    public static final int MIN = 1000;

    private String str;

    //costruttore vuoto
    public Stringa() {
    }

    //costruttore con parametro
    public Stringa(String str) {
        this.str = str;
    }

    //metodo run
    public void run(){
       /*//ESERCIZIO RISOLVIBILE CON UN MONOTHREAD
        String strRev = "";
        for(int cntStr=str.length()-1;cntStr>=0;cntStr--){
            char ch = str.charAt(cntStr);
            Random rand = new Random();
            int randNum = rand.nextInt((MAX-MIN)+1)+MIN;
            System.out.println(ch + "\t" + "time: "+ randNum);
            strRev+=ch;
        }
        System.out.println("Reverse srting: " + strRev);
        */
        //lunghezza stringa
        int cntStr = str.length()-1;
        //se ci sono caratteri nella stringa
        if(cntStr>=0){
            //carattere
            char ch = str.charAt(cntStr);
            Random rand = new Random();
            //random compreso tra 1000 e 3000
            int randNum = rand.nextInt((MAX-MIN)+1)+MIN;
            System.out.println(ch + "\t" + "time: "+ randNum);
            String newStr = str.substring(0,cntStr);
            //output --> controllo
            //System.out.println("sottostringa: " + newStr);
            //creazione di un nuovo thread(eliminando il carattere già stampato dalla stringa)
            Stringa thr1 = new Stringa(newStr);
            //output --> controllo
            //System.out.println("start");
            thr1.start();
            try {
                //output --> controllo
                //System.out.println("join");
                thr1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
