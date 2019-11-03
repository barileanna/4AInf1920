package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 21/09/2019.
 */
public class Numero {
    //Attributo
    private int valore;

    //Metodi

    //costruttore
    public Numero(int valore){

        //inizializzazione dello stato
        this.valore = valore;
    }

    //set del valore
    public void setValore(int valore){
        //settare il valore
        this.valore = valore;
    }

    //get del valore
    public int getValore(){
        //getting del valore
        return this.valore;
    }

    //come se questo metodo fosse esterno alla classe(c'è static)
    public static void main(String args[]){

        //variabile che deve recuperare il valore inserito
        int x;

        Numero numero = new Numero(5);

        //prendo il valore impostato e lo memorizzo in x
        x = numero.getValore();
        System.out.println(x);
    }
}

