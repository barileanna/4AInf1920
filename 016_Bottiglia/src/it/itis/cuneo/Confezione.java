package it.itis.cuneo;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

public class Confezione {
    public static final int MAX_BOTTLE = 6;
    private Bottiglia[] vBottiglia;
    private int cntBott;

    public Confezione(){
        //costruttore di array
        vBottiglia = new Bottiglia[MAX_BOTTLE];
        cntBott = 0;
    }

    public static int getMaxBottle() {
        return MAX_BOTTLE;
    }


    public void setvBottiglia(Bottiglia[] vBottiglia) {
        this.vBottiglia = vBottiglia;
    }

    public Bottiglia[] getvBottiglia() {
        return vBottiglia;
    }

    public void setCntBott(int cntBott) {
        this.cntBott = cntBott;
    }

    public int getCntBott() {
        return cntBott;
    }

    public void addBottle(Bottiglia bottiglia) throws ConfezionePienaException {
        if(cntBott+1 > MAX_BOTTLE){
            throw new ConfezionePienaException(1,"Troppe bottiglie!!!");
        }
        else{
            vBottiglia[cntBott] = bottiglia;
            cntBott++;
        }
    }

    public int serchBottle(Bottiglia bottiglia) throws nonTrovatoException{
        int c=0;
        boolean trovato=false;
        while(c<cntBott && trovato==false) {

            if (vBottiglia[c].equals(bottiglia)) {
                trovato = true;
            }
            else{
                c++;
            }
        }
        if(trovato==false){
            throw new nonTrovatoException (1,"Bottiglia non trovata");
        }
        return c;
    }

    public void removeBottle(int i) {
        int c = i;
        while(c<cntBott-1)
        {
            vBottiglia[c] = vBottiglia[c+1];
            c++;
        }
        cntBott--;

    }

    public void modifyBottle(int x) {
        vBottiglia[x].setMarchio("Aranciata");
        vBottiglia[x].setCapacita(1.5);
        vBottiglia[x].setPrezzo(1.2);
    }

    @Override
    public String toString() {
        return "Confezione{" +
                "vBottiglia=" + Arrays.toString(vBottiglia) +
                ", cntBott=" + cntBott +
                '}';
    }

    public static void main(String[] args) {
        String marchio;
        float capacita;
        float prezzo;

        //bottiglia uno
       /* marchio = InputOutputUtility.leggiNome("Inserire il marchio: ");
        capacita = InputOutputUtility.leggiNumeroFloat("Inserire la capacità della bottiglia: ");
        prezzo = InputOutputUtility.leggiNumeroFloat("Inserire il prezzo della bottiglia: ");
        Bottiglia bottiglia1 = new Bottiglia(marchio,capacita,prezzo);
        */



        Confezione confezione = new Confezione();
        Bottiglia bottiglia1 = new Bottiglia("Sant'Anna", 1.5, 0.35);
        Bottiglia bottiglia2 = new Bottiglia("Panna", 1.5, 0.32);
        Bottiglia bottiglia3 = new Bottiglia("Coca-Cola", 1.5, 1.8);
        Bottiglia bottiglia4 = new Bottiglia("Fanta", 1.5, 1.2);
        Bottiglia bottiglia5 = new Bottiglia("Sprite", 1.5, 1.2);
        Bottiglia bottiglia6 = new Bottiglia("Estathe", 1.5, 1.3);

        try{
            confezione.addBottle(bottiglia1);
            confezione.addBottle(bottiglia2);
            confezione.addBottle(bottiglia3);
            confezione.addBottle(bottiglia4);
            confezione.addBottle(bottiglia5);
            confezione.addBottle(bottiglia6);
            int i = confezione.serchBottle(bottiglia2);
            confezione.removeBottle(i);
        }
        catch(ConfezionePienaException confezionePiena){
            confezionePiena.printStackTrace();
            System.err.println(confezionePiena.toString());
        } catch (nonTrovatoException e) {
            e.printStackTrace();
            System.err.println(e.toString());
        }

        for(int i=0; i<confezione.getCntBott();i++)
        {
            System.out.println(confezione.vBottiglia[i].toString());
        }
    }

}
