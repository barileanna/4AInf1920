package it.itis.cuneo;

public class Bottiglia {
    private String marchio;
    private float capacita;
    private float prezzo;

    public Bottiglia(){}

    public Bottiglia(String marchio, float capacita, float prezzo) {
        this.marchio = new String(marchio);
        this.capacita = capacita;
        this.prezzo = prezzo;
    }

    public Bottiglia (Bottiglia bottiglia){
        this.marchio = bottiglia.getMarchio();
        this.capacita = bottiglia.getCapacita();
        this.prezzo = bottiglia.getPrezzo();
    }

    public void setMarchio(String marchio) {
        this.marchio = new String (marchio);
    }

    public String getMarchio() {
        return marchio;
    }

    public void setCapacita(float capacita) {
        this.capacita = capacita;
    }

    public float getCapacita() {
        return capacita;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public boolean equals (Bottiglia bottiglia){
        boolean bEquals = false;
        if(marchio != null && marchio.equals(bottiglia.getMarchio()) &&
                capacita!= 0 && capacita == bottiglia.getCapacita() &&
                prezzo != 0 && prezzo == bottiglia.getPrezzo()){

            bEquals = true;
        }
        return bEquals;
    }

}
