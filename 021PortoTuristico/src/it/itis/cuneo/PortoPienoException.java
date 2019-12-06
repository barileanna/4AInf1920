package it.itis.cuneo;

public class PortoPienoException extends Exception {
    private int codice;
    private String descrizione;

    public PortoPienoException(int codice, String descrizione) {
        super();
        this.setCodice(codice);
        this.setDescrizione(descrizione);
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
        return "PortoPienoException{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
