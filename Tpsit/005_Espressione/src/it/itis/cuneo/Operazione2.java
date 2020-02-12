package it.itis.cuneo;
/*calcola   z = 2*(b-3)+4
            z = a*(b-c)+d
 */

public class Operazione2 extends Thread{
    Buffer dati;
    private double a = 2;
    private double c = 3;
    private double d = 4;
    private double b;

    public Operazione2(Buffer d){
        dati = d;
        b = dati.b;
    }

    public void run(){
        dati.z = a*(b-c)+d;
        System.out.println("Ho calcolato z : " + dati.z);
    }
}