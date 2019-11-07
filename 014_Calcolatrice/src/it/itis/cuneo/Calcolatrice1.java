package it.itis.cuneo;

import java.text.ParseException;

public class Calcolatrice1 {

    public Calcolatrice1(){}

    public int somma(int uno, int due){

        return (uno+due);
    }

    public int sottrazione(int uno, int due){
        return uno-due;
    }

    public int moltiplicazione(int uno, int due){

        return uno*due;
    }

    public float divisione(int uno, int due){

        return (float)uno/due;
    }

    public static void main(String[] args) {
        int x1;
        int x2;

        x1 = InputOutputUtility.leggiNumero("Inserisci numero uno");
        x2 = InputOutputUtility.leggiNumero("Inserisci numero due");

        Calcolatrice calc = new Calcolatrice();


        int somma = calc.somma(x1,x2);
        int sottrazione = calc.sottrazione(x1,x2);
        int moltiplicazione = calc.moltiplicazione(x1,x2);
        float divisione = calc.divisione(x1,x2);

        System.out.println("SOMMA: "+somma);
        System.out.println("SOTTRAZIONE: "+sottrazione);
        System.out.println("MOLTIPLICAZIONE: "+moltiplicazione);
        System.out.println("DIVIZIONE: "+divisione);
    }
}
