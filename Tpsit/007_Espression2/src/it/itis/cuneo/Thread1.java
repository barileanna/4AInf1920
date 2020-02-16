package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class Thread1 extends Thread{
    private Buffer buffer;

    public Thread1(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        buffer.setX(buffer.getB()*4);
        System.out.println("X1 = "+ buffer.getX());
    }
}
