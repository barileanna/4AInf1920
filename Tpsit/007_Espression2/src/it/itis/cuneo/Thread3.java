package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 13/02/2020.
 */
public class Thread3 extends Thread {

    Buffer buffer;

    public Thread3(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        buffer.setZ(buffer.getY()*buffer.getX());
        System.out.println("Z = "+ buffer.getZ());
    }
}
