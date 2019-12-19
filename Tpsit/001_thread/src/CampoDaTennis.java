/**
 * Created by inf.barilea1810 on 12/12/2019.
 */
/* tutti i programmi in java sono thread*/
/*jvm = processo multithread*/
    /* se estendo un thread devo sempre implementare un metodo run (o intefaccia runnable)*/
public class CampoDaTennis {

    private long punteggio1, punteggio2;

    public long getPunteggio1() {
        return punteggio1;
    }

    public void setPunteggio1(long punteggio1) {
        this.punteggio1 = punteggio1;
    }

    public long getPunteggio2() {
        return punteggio2;
    }

    public void setPunteggio2(long punteggio2) {
        this.punteggio2 = punteggio2;
    }

    public static void main(String[] args) {
        CampoDaTennis cdt = new CampoDaTennis();
        Giocatore giocatore1 = new Giocatore("giocatore1",cdt);
        giocatore1.start();
        Giocatore giocatore2 = new Giocatore("giocatore2",cdt);
        giocatore2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("punteggio1: "+cdt.getPunteggio1());
        System.out.println("punteggio2: "+cdt.getPunteggio2());


    }
}
