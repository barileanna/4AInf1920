package it.itis.cuneo;

public class Test {

    public static void main(String[] args) {
        Trapezio trapezio = new Trapezio();
        Parallelogramma parallelogramma = new Parallelogramma();
        Rettangolo rettangolo = new Rettangolo();

        trapezio.carica();
        parallelogramma.carica();
        rettangolo.carica();

        System.out.println("Trapezio: " + " Perimetro: " + trapezio.perimetro());
        System.out.println("Triangolo: " + " Perimetro: " + parallelogramma.perimetro());
        System.out.println("Rettangolo: " + " Perimetro: " + rettangolo.perimetro());
    }
}
