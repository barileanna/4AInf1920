package it.itis.cuneo;

public class Buffer {
    public double x, y, z, a, b;

    public Buffer(){
        x = 0; y = 0; z = 0; a = 0; b = 0;
    }

    public Buffer(double aa, double bb){
        x = 0; y = 0; z = 0;
        a = aa;
        b = bb;
        System.out.println("I parametri valgono: a = "+a+" b = "+b+"\n");
    }
}
