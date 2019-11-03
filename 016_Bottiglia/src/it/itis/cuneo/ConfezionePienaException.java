package it.itis.cuneo;

public class ConfezionePienaException extends Exception{
    private int codice;
    private String descrizione;

    public ConfezionePienaException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Confezione piena{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
