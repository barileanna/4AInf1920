public class Sync {

    public int contatore=20;
    public Sync() {
    }

    public int getContatore() {
        return contatore;
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    public synchronized void decrementaContatore(){
        contatore --;

    }
}
