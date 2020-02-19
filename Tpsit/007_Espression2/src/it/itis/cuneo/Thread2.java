package it.itis.cuneo;
/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class Thread2 extends Thread {
    private Buffer buffer;

    public Thread2(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        buffer.setY(buffer.getA()+buffer.getB()*5);
        System.out.println("Y = "+ buffer.getY());
    }
}
