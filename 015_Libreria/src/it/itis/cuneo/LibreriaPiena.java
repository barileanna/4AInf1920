package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 30/10/2019.
 */

//extends (come se fosse il cognome), la classe è della famiglia Exception
    //throws
    //E' un'eccezione, se faccio l'extend di Exception posso fare una throw new
    //externds è throwable -> rilanciabili
    //se ho un throw devo fare una catch
public class LibreriaPiena extends Exception {
    private int codice;
    private String descrizione;

    public LibreriaPiena(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "LibreriaPiena{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
