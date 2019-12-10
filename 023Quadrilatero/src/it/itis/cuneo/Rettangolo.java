package it.itis.cuneo;

public class Rettangolo implements Quadrilatero {
    private double base;
    private double altezza;

    public Rettangolo() {
    }

    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public double perimetro() {
        double perimetro = (this.base + this.altezza) * 2;
        return perimetro;
    }

    @Override
    public void carica(){
        System.out.println("Dati rettangolo: ");
        System.out.println("Lunghezza base: ");
        this.setBase(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Lunghezza altezza: ");
        this.setAltezza(InputOutputUtility.leggiNumeroDouble());
    }
}
