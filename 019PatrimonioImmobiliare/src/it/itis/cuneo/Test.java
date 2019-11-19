package it.itis.cuneo;

import java.util.SortedMap;

public class Test {
    public static void main(String[] args) {
        InputOutputUtility t;
        Ville ab1 = new Ville();
        Ville ab2= new Ville();
        Appartamenti ab3 = new Appartamenti();
        Appartamenti ab4 = new Appartamenti();

        System.out.println("Abitazioni: ");
        ab1.carica();
        System.out.println("\n");
        ab2.carica();
        System.out.println("\n");
        ab3.carica();
        System.out.println("\n");
        ab4.carica();
        System.out.println("\n");

        System.out.println("Abitazione 1:"+ab1.toString());
        System.out.println("Abitazione 2:"+ab2.toString());
        System.out.println("Abitazione 3:"+ab3.toString());
        System.out.println("Abitazione 4:"+ab4.toString());

        System.out.println("Abitazione 1 e Abitazione 2 sono uguali? ->" + ab1.equals(ab2));
        System.out.println("Abitazione 3 e Abitazione 4 sono uguali? ->" + ab3.equals(ab4));
    }
}
