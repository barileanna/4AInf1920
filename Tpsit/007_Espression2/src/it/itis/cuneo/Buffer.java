package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class Buffer {

    private int a, b;

    private int x, y, z;

    public Buffer() {
        x = 0;
        y = 0;
        z = 0;
        a = 0;
        b = 0;
    }

    public Buffer(int a, int b, int x, int y, int z) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
