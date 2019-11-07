package it.itis.cuneo;

public class Autostrada {
    //attributi
    private Casello caselloInizio;
    private Casello caselloFine;
    private int distanza;

    //metodi
    //costruttore
    public Autostrada(){}

    public Autostrada(Casello caselloInizio, Casello caselloFine, int distanza){
        this.caselloInizio = new Casello(caselloInizio);
        this.caselloFine = new Casello(caselloFine);
        this.distanza = distanza;
    }

    public Autostrada(Autostrada autostrada){
        this.caselloInizio = new Casello(autostrada.getCaselloInizio());
        this.caselloFine = new Casello(autostrada.getCaselloFine());
        this.distanza = distanza;
    }

    public void setCaselloInizio(Casello caselloInizio){
        this.caselloInizio = caselloInizio;
    }

    public Casello getCaselloInizio(){
        return this.caselloInizio;
    }

    public void setCaselloFine(Casello caselloFine){
        this.caselloFine = caselloFine;
    }

    public Casello getCaselloFine(){
        return this.caselloFine;
    }

    public void setDistanza(int distanza){
        this.distanza = distanza;
    }

    public int getDistanza(){
        return this.distanza;
    }

    public static void main(String[] args) {

    }
}
