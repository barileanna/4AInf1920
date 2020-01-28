package it.itis.cuneo;

import java.util.Arrays;

public class Quartiere {
    InputOutputUtility t;
    public static final int MAX_AB=10;
    private Abitazione[] elencoAbitazioni;
    private static int cntAbitazioni;

    public Quartiere() {
    }

    public Quartiere(int cntAbitazioni) {
        this.cntAbitazioni = cntAbitazioni;
        elencoAbitazioni = new Abitazione[MAX_AB];
        t = new InputOutputUtility();
    }

    public Quartiere(Abitazione[] vAbitazioni, int cntAbitazioni) {
        this.elencoAbitazioni = vAbitazioni;
        this.cntAbitazioni = cntAbitazioni;
    }

    public Abitazione[] getvAbitazioni() {
        return elencoAbitazioni;
    }

    public void setvAbitazioni(Abitazione[] vAbitazioni) {
        this.elencoAbitazioni = vAbitazioni;
    }

    public int getCntAbitazioni() {
        return cntAbitazioni;
    }

    public void setCntAbitazioni(int cntAbitazioni) {
        this.cntAbitazioni = cntAbitazioni;
    }

    public void addAbitazione() throws QuartierePienoException{
        if(cntAbitazioni+1 > MAX_AB){
            throw new QuartierePienoException(1,"Troppe Abitazioni!");
        }
        Abitazione.caricaAbitazione(elencoAbitazioni,cntAbitazioni,t);
        cntAbitazioni++;
    }

    public int cercaPerStanze(int nStanze){
        int posizione = -1;

        for(int contatore = 0;contatore<cntAbitazioni;contatore++){
            if(elencoAbitazioni[contatore].getnStanze() == nStanze){
                posizione = contatore;
            }
        }
        return posizione;
    }

    public void removeAbitazione(int posizione){
        for(int contatore=posizione;contatore<cntAbitazioni;contatore++){
            elencoAbitazioni[contatore] = elencoAbitazioni[contatore+1];
        }
        cntAbitazioni--;
    }
    public String toString() {
        String s = "";

        for(int cnt = 0; cnt < cntAbitazioni; cnt++) {
            Abitazione nave = elencoAbitazioni[cnt];

            if (nave.getTipo() == 0) {
                s= s + "cntNave: " +cnt+ " " + ( (Villa) nave ).toString() + "\n";
            }
            else {
                s= s + "cntNave: " +cnt+ " " + ( (Appartamento) nave ).toString() + "\n";
            }
        }

        return s;
    }
}
