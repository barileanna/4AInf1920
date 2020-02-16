package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class Thread4 extends Thread {
    private Buffer buffer;

    public Thread4(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        buffer.setY(buffer.getX()+buffer.getA());
        System.out.println("Y2 = "+ buffer.getY());
    }
}
