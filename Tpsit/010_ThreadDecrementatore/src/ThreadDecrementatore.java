public class ThreadDecrementatore extends Thread{

    private int totale;
    private int n;
    private Sync sync;

    public ThreadDecrementatore() {
    }

    public ThreadDecrementatore(Sync sync, int n) {
        this.n = n;
        this.sync = sync;
    }

    public int getTotale() {
        return totale;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }

    @Override
    public void run() {
        while(sync.contatore >= 1){
            System.out.println("Thread "+n+": --> Contatore Prima: "+sync.contatore);
            totale  ++;
            sync.decrementaContatore();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+n+": --> Contatore Dopo: "+sync.contatore);
        }
        System.out.println("Totale thread "+n+": "+totale);
    }
}
