package it.itis.cuneo;

import java.util.Objects;

public class Appartamenti extends Abitazioni {
    private int piano;
    private boolean ascensore;
    private int nTerrazzi;

    public Appartamenti(){

    }

    public Appartamenti(int nStanze, double superficie, String indirizzo, String citta, int piano, boolean ascensore, int nTerrazzi){
        super(nStanze,superficie,indirizzo,citta);
        this.piano = piano;
        this.ascensore = ascensore;
        this.nTerrazzi = nTerrazzi;
    }

    public Appartamenti(Appartamenti appartamenti){
        super(appartamenti.getnStanze(), appartamenti.getSuperficie(), appartamenti.getIndirizzo(),appartamenti.getCitta());
        this.piano = appartamenti.getPiano();
        this.ascensore = appartamenti.isAscensore();
        this.nTerrazzi = appartamenti.getnTerrazzi();
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public boolean isAscensore() {
        return ascensore;
    }

    public void setAscensore(boolean ascensore) {
        this.ascensore = ascensore;
    }

    public int getnTerrazzi() {
        return nTerrazzi;
    }

    public void setnTerrazzi(int nTerrazzi) {
        this.nTerrazzi = nTerrazzi;
    }

    public String toString() {
        String s = new String(super.toString() + " Numero piano: " +piano+" Ascensore: "+ascensore+" Numero terrazzi: "+nTerrazzi);
        return s;
    }

    public boolean equals(Appartamenti appartamenti) {
        boolean equals=false;
        if(super.equals(appartamenti) && this.piano== appartamenti.getPiano() && this.nTerrazzi==appartamenti.getnTerrazzi() && this.ascensore==appartamenti.isAscensore())
        {
            equals=true;
        }
        return equals;
    }

    public void carica(){
        super.caricaAbitazione();
        System.out.println("Piano : ");
        this.setPiano(InputOutputUtility.leggiNumero());
        System.out.println("Ascensore: ");
        this.setAscensore(InputOutputUtility.leggiBoolean());
        System.out.println("Numero di terrazzi: ");
        this.setnTerrazzi(InputOutputUtility.leggiNumero());
    }
}
