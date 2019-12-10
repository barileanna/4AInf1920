package it.itis.cuneo;

public class Quadrato implements Poligono {
    private double lato;

    public Quadrato() {
    }

    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    @Override
    public double area(){
        double area = this.lato * this.lato;
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = this.lato * 4;
        return perimetro;
    }

    @Override
    public void carica(){
        System.out.println("Dati quadrato: ");
        System.out.println("Lunghezza lato: ");
        this.setLato(InputOutputUtility.leggiNumeroDouble());
    }
}
