package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 20/11/2019.
 */
public class Test {
    public static void main(String[] args) throws QuartierePienoException {
        Quartiere quartiere = new Quartiere(0);

        quartiere.addAbitazione();
        quartiere.addAbitazione();
        quartiere.addAbitazione();
        int x = quartiere.cercaPerStanze(3);
        quartiere.removeAbitazione(x);

        System.out.println(quartiere.toString());
    }
}
