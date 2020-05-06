public class Main {

    public static void main(String[] args) {
        int contatore = 20;
        Sync sync = new Sync();
        ThreadDecrementatore th1 = new ThreadDecrementatore(sync,1);
        ThreadDecrementatore th2 = new ThreadDecrementatore(sync,2);
        ThreadDecrementatore th3 = new ThreadDecrementatore(sync,3);
        th1.start();
        th2.start();
        th3.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Contatore: " + sync.contatore);
    }
}
