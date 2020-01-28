package it.itis.cuneo;

public class QuartierePienoException extends Exception  {
    private int codice;
    private String descrizione;

    public QuartierePienoException() {
    }

    public QuartierePienoException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "QuartierePienoException{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
