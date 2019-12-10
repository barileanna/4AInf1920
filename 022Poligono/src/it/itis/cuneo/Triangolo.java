package it.itis.cuneo;

public class Triangolo implements Poligono {
    private double base;
    private double altezza;
    private double lato2;
    private double lato3;

    public Triangolo() {
    }

    public Triangolo(double base, double altezza, double lato2, double lato3) {
        this.base = base;
        this.altezza = altezza;
        this.lato2 = lato2;
        this.lato3 = lato3;
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

    public double getLato2() {
        return lato2;
    }

    public void setLato2(double lato2) {
        this.lato2 = lato2;
    }

    public double getLato3() {
        return lato3;
    }

    public void setLato3(double lato3) {
        this.lato3 = lato3;
    }

    @Override
    public double area() {
        double area = (this.base + this.altezza) / 2;
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = this.base + this.lato2 + this.lato3;
        return perimetro;
    }

    @Override
    public void carica(){
        System.out.println("Dati trinagolo: ");
        System.out.println("Base: ");
        this.setBase(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Altezza: ");
        this.setAltezza(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Lato 2: ");
        this.setLato2(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Lato 3: ");
        this.setLato3(InputOutputUtility.leggiNumeroDouble());
    }
}
