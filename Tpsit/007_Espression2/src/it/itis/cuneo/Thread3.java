package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class Thread3 extends Thread  {
    private Buffer buffer;

    public Thread3(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        buffer.setX(buffer.getB()*5);
        System.out.println("X2 = "+ buffer.getX());
    }
}
