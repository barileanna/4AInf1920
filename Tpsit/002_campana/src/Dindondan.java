public class Dindondan {
    public static void main(String[] args) {
        Thread thr1 = new Thread(new Campana("din",3));
        Thread thr2 = new Thread(new Campana("don",3));
        Thread thr3 = new Thread(new Campana("dan",3));
        thr1.start();
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thr2.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thr3.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
