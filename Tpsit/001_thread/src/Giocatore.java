/**
 * Created by inf.barilea1810 on 12/12/2019.
 */
//estende un thread
public class Giocatore extends Thread {

    public static final int MIN = 2;
    public static final int MAX = 6;
    private CampoDaTennis campoDaTennis;
    private String name;

    public Giocatore(String nome, CampoDaTennis campoDaTennis){
        this.name = nome;
        this.campoDaTennis = campoDaTennis;
    }

    @Override
    public void run() {
        /*(Math.random() * (MAX-MIN) --> numeri tra 0 e 4, sommando MIN ottengo numeri tra 2 e 4*/
        /*Math.random() --> genera numeri tra 1 e 0*/
        long estrazione = Math.round((Math.random() * (MAX-MIN))+ MIN);
        System.err.println(name + ": " +estrazione);
        if(name.equals("giocatore1"))
            campoDaTennis.setPunteggio1(estrazione);
        else
            campoDaTennis.setPunteggio2(estrazione);
    }
}
