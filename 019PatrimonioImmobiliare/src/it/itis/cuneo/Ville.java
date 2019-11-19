package it.itis.cuneo;

import java.util.Objects;

public class Ville extends Abitazioni {
    private int nPiani;
    private double superficieGiardino;
    private boolean piscina;

    public Ville() {
    }

    public Ville (int nStanze, double superficie, String indirizzo, String citta, int nPiani, double superficieGiardino, boolean piscina) {
        super(nStanze, superficie, indirizzo, citta);
        this.nPiani = nPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }

    public Ville(Ville ville){
        super(ville.getnStanze(), ville.getSuperficie(), ville.getIndirizzo(),ville.getCitta());
        this.nPiani = ville.getnPiani();
        this.superficieGiardino = ville.getSuperficieGiardino();
        this.piscina = ville.isPiscina();
    }

    public int getnPiani() {
        return nPiani;
    }

    public void setnPiani(int nPiani) {
        this.nPiani = nPiani;
    }

    public double getSuperficieGiardino() {
        return superficieGiardino;
    }

    public void setSuperficieGiardino(double superficieGiardino) {
        this.superficieGiardino = superficieGiardino;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }



    public String toString() {
        String s = new String(super.toString() + " Numero piani: " +nPiani+" Superficie giardino: "+superficieGiardino+" Piscina: "+piscina);
        return s;
    }


    public boolean equals(Ville ville) {
        boolean equals=false;
        if(super.equals(ville) && this.nPiani== ville.getnPiani() && this.superficieGiardino==ville.getSuperficieGiardino() && this.piscina==ville.isPiscina())
        {
            equals=true;
        }
        return equals;
    }

    public void carica(){
        super.caricaAbitazione();
        System.out.println("Numero di piani: ");
        this.setnPiani(InputOutputUtility.leggiNumero());
        System.out.println("Superficie giardino: ");
        this.setSuperficieGiardino(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Piscina: ");
        this.setPiscina(InputOutputUtility.leggiBoolean());
    }
}
