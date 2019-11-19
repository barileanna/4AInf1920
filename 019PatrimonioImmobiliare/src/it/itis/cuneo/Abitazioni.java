package it.itis.cuneo;

import java.util.Objects;

public class Abitazioni {
    private int nStanze;
    private double superficie;
    private String indirizzo;
    private String citta;

    public Abitazioni(){

    }

    public Abitazioni(int nStanze, double superficie, String indirizzo, String citta){
        super();
        this.nStanze = nStanze;
        this.superficie = superficie;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public int getnStanze() {
        return nStanze;
    }

    public void setnStanze(int nStanze) {
        this.nStanze = nStanze;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }


    public String toString() {
        return "Abitazioni{" +
                "nStanze=" + nStanze +
                ", superficie=" + superficie +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }

    public boolean equals(Abitazioni abitazione) {
        boolean equals = false;
        if(nStanze == abitazione.getnStanze() &&
        superficie == abitazione.getSuperficie() &&
        indirizzo.equals(abitazione.getIndirizzo()) &&
        citta.equals(abitazione.getCitta())){
            equals = true;
        }
        return equals;
    }

    public void caricaAbitazione(){
        System.out.println("Numero stanze: ");
        this.setnStanze(InputOutputUtility.leggiNumero());
        System.out.println("Superficie: ");
        this.setSuperficie(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Indirizzo: ");
        this.setIndirizzo(InputOutputUtility.leggiNome());
        System.out.println("Città: ");
        this.setCitta(InputOutputUtility.leggiNome());
    }
}
