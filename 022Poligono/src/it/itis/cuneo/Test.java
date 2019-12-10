package it.itis.cuneo;

public class Test {

    public static void main(String[] args) {
        Quadrato quadrato = new Quadrato();
        Triangolo triangolo = new Triangolo();
        Rettangolo rettangolo = new Rettangolo();

        quadrato.carica();
        triangolo.carica();
        rettangolo.carica();

        System.out.println("Quadrato: ");
        System.out.println("Area: " + quadrato.area() + " Perimetro: " + quadrato.perimetro());
        System.out.println("Triangolo: ");
        System.out.println("Area: " + triangolo.area() + " Perimetro: " + triangolo.perimetro());
        System.out.println("Rettangolo: ");
        System.out.println("Area: " + rettangolo.area() + " Perimetro: " + rettangolo.perimetro());
    }
}
