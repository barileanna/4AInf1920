package it.itis.cuneo;

public class Calcolatrice {
    private int numeroUno;
    private int numeroDue;

    public Calcolatrice(){}

    public Calcolatrice(int numeroUno, int numeroDue){
        this.numeroUno = numeroUno;
        this.numeroDue = numeroDue;
    }

    public Calcolatrice(Calcolatrice calcolatrice){
        this.numeroUno = calcolatrice.getNumeroUno();
        this.numeroDue = calcolatrice.getNumeroDue();
    }

    public void setNumeroUno(int numeroUno) {
        this.numeroUno = numeroUno;
    }

    public int getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroDue(int numeroDue) {
        this.numeroDue = numeroDue;
    }

    public int getNumeroDue() {
        return numeroDue;
    }

    public int somma(int x1, int x2){
        return (this.numeroUno+this.numeroDue);
    }

    public int sottrazione(int x1, int x2){
        return this.numeroUno-this.numeroDue;
    }

    public int moltiplicazione(int x1, int x2){
        return this.numeroDue*this.numeroUno;
    }

    public float divisione(int x1, int x2){
        return (float)this.numeroUno/this.numeroDue;
    }

    public static void main(String[] args) {
        int x1;
        int x2;

        x1 = InputOutputUtility.leggiNumero("Inserisci numero uno");
        x2 = InputOutputUtility.leggiNumero("Inserisci numero due");


        Calcolatrice datiUno = new Calcolatrice(x1,x2);
        int somma = datiUno.somma(x1, x2);
        int sottrazione = datiUno.sottrazione(x1, x2);
        int moltiplicazione = datiUno.moltiplicazione(x1, x2);
        float divisione = datiUno.divisione(x1, x2);

        System.out.println("SOMMA: "+somma);
        System.out.println("SOTTRAZIONE: "+sottrazione);
        System.out.println("MOLTIPLICAZIONE: "+moltiplicazione);
        System.out.println("DIVIZIONE: "+divisione);

    }
}
