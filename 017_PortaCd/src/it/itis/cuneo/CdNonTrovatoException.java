package it.itis.cuneo;

public class CdNonTrovatoException extends Exception{
    private int codice;
    private String descrizione;

    public CdNonTrovatoException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Cd non torvato{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
