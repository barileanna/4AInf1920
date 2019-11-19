package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 13/11/2019.
 */
public class Prodotto {
    private int codice;
    private String descrizione;

    public Prodotto(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public Prodotto() {
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
