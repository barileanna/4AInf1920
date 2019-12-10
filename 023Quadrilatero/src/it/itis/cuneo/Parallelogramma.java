package it.itis.cuneo;

public class Parallelogramma implements Quadrilatero {
    private double base;
    private double latoCorto;

    public Parallelogramma() {
    }

    public Parallelogramma(double base, double latoCorto) {
        this.base = base;
        this.latoCorto = latoCorto;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getLatoCorto() {
        return latoCorto;
    }

    public void setLatoCorto(double latoCorto) {
        this.latoCorto = latoCorto;
    }

    @Override
    public double perimetro() {
        double perimetro = (this.latoCorto + this.base) * 2;
        return perimetro;
    }

    @Override
    public void carica(){
        System.out.println("Dati PARALLELOGRAMMA: ");
        System.out.println("Base: ");
        this.setBase(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Secondo lato: ");
        this.setLatoCorto(InputOutputUtility.leggiNumeroDouble());
    }
}
