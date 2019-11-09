package it.itis.cuneo;

import java.sql.Time;

public class Cd {
    private String titolo;
    private String autore;
    private String durata;
    private int numeroBrani;

    public Cd(){
        super();
    }

    public Cd(String titolo, String autore, String durata, int numeroBrani) {
        this.titolo = titolo;
        this.autore = autore;
        this.durata = durata;
        this.numeroBrani = numeroBrani;
    }

    public Cd (Cd cd){
        this.titolo = cd.getTitolo();
        this.autore = cd.getAutore();
        this.durata = cd.getDurata();
        this.numeroBrani = cd.getNumeroBrani();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public int getNumeroBrani() {
        return numeroBrani;
    }

    public void setNumeroBrani(int numeroBrani) {
        this.numeroBrani = numeroBrani;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", durata=" + durata +
                ", numeroBrani=" + numeroBrani +
                '}';
    }

    public int comapreDurata(Cd cd){
        int confronto;

        confronto = Math.abs(Integer.parseInt(this.durata)- Integer.parseInt(cd.getDurata()));
        return confronto;
    }
}
