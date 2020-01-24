package it.itis.cuneo;

public class Brano {
    private int idBrano;
    private String titolo;
    private int durata;
    private String autore;

    public Brano() {
    }

    public Brano(int idBrano, String titolo, int durata, String autore) {
        this.idBrano = idBrano;
        this.titolo = titolo;
        this.durata = durata;
        this.autore = autore;
    }

    public Brano(Brano brano){
        this.idBrano = brano.getIdBrano();
        this.titolo = brano.getTitolo();
        this.durata = brano.getDurata();
        this.autore = brano.getAutore();
    }

    public int getIdBrano() {
        return idBrano;
    }

    public void setIdBrano(int idBrano) {
        this.idBrano = idBrano;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Brano[" +
                "idBrano=" + idBrano + ", titolo='" + titolo + '\'' +
                ", durata='" + durata + '\'' + ", autore='" + autore + '\'' + ']';
    }

    public String toRowCSV() {
        return "Brano" + Libreria.SEPARATOR + idBrano + Libreria.SEPARATOR + titolo + Libreria.SEPARATOR
                + autore + Libreria.SEPARATOR + durata + "\n";
    }

    public Brano caricaBrano() {
        idBrano = InputOutputUtility.leggiNumero("Inserire il codice del brano: ");
        titolo = InputOutputUtility.leggiNome("Inserire titolo del brano: ");
        autore = InputOutputUtility.leggiNome("Inserisci autore del brano: ");
        durata = InputOutputUtility.leggiNumero("Inserisci durata brano (in secondi): ");
        Brano brano = new Brano(idBrano, titolo, durata, autore);
        return brano;
    }
}
