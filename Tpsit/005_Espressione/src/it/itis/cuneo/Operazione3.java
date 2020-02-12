package it.itis.cuneo;
/*calcola   y = [4*(a-2)+5]*[2*(b-3)+4]
            y = x * z
 */

public class Operazione3 extends Thread{
    Buffer dati;
    private double x;
    private double z;

    public Operazione3(Buffer d){
        dati = d;
        x = dati.x;
        z = dati.z;
    }

    public void run(){
        dati.y = dati.x * dati.z;
        System.out.println("Ho calcolato y : " + dati.y);
    }
}
