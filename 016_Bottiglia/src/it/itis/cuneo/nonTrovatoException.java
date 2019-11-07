package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 04/11/2019.
 */

public class nonTrovatoException extends Exception{
    private int codice;
    private String descrizione;

    public nonTrovatoException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Valore{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
