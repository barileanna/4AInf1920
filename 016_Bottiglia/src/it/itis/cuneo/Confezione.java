package it.itis.cuneo;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.SQLOutput;
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
        marchio = InputOutputUtility.leggiNome("Inserire il marchio: ");
        capacita = InputOutputUtility.leggiNumeroFloat("Inserire la capacità della bottiglia: ");
        prezzo = InputOutputUtility.leggiNumeroFloat("Inserire il prezzo della bottiglia: ");
        Bottiglia bottiglia1 = new Bottiglia(marchio,capacita,prezzo);

        Confezione confezione = new Confezione();

        try{
            confezione.addBottle(bottiglia1);
            confezione.addBottle(bottiglia1);
            confezione.addBottle(bottiglia1);
            confezione.addBottle(bottiglia1);
            confezione.addBottle(bottiglia1);
            confezione.addBottle(bottiglia1);
            confezione.addBottle(bottiglia1);
        }
        catch(ConfezionePienaException confezionePiena){
            confezionePiena.printStackTrace();
            System.err.println(confezionePiena.toString());
        }
    }

}
