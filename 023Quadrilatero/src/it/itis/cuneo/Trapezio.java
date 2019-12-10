package it.itis.cuneo;

public class Trapezio implements Quadrilatero {
    private double baseMaggiore;
    private double baseMinore;
    private double latoObliquo1;
    private double latoObliquo2;

    public Trapezio() {
    }

    public Trapezio(double baseMaggiore, double baseMinore, double latoObliquo1, double latoObliquo2) {
        this.baseMaggiore = baseMaggiore;
        this.baseMinore = baseMinore;
        this.latoObliquo1 = latoObliquo1;
        this.latoObliquo2 = latoObliquo2;
    }

    public double getBaseMaggiore() {
        return baseMaggiore;
    }

    public void setBaseMaggiore(double baseMaggiore) {
        this.baseMaggiore = baseMaggiore;
    }

    public double getBaseMinore() {
        return baseMinore;
    }

    public void setBaseMinore(double baseMinore) {
        this.baseMinore = baseMinore;
    }

    public double getLatoObliquo1() {
        return latoObliquo1;
    }

    public void setLatoObliquo1(double latoObliquo1) {
        this.latoObliquo1 = latoObliquo1;
    }

    public double getLatoObliquo2() {
        return latoObliquo2;
    }

    public void setLatoObliquo2(double latoObliquo2) {
        this.latoObliquo2 = latoObliquo2;
    }

    @Override
    public double perimetro() {
        double perimetro = this.baseMaggiore + this.baseMinore + this.latoObliquo1 + this.latoObliquo2;
        return perimetro;
    }

    @Override
    public void carica(){
        System.out.println("Dati TRAPEZIO: ");
        System.out.println("Base maggiore: ");
        this.setBaseMaggiore(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Base minore: ");
        this.setBaseMinore(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Lato obliquo: ");
        this.setLatoObliquo1(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Lato obliquo: ");
        this.setLatoObliquo2(InputOutputUtility.leggiNumeroDouble());
    }
}
