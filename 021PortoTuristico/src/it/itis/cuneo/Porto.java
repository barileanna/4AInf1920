package it.itis.cuneo;

import javax.annotation.processing.FilerException;
import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class Porto {
    private static final int N_MAX=100;
    private Barca[] vBarche;
    private int cntBarche;
    private BufferedReader reader;
    private BufferedWriter writer;

    public Porto(Barca[] vBarche, int cntBarche) {
        this.vBarche = vBarche;
        this.cntBarche = cntBarche;
    }

    public Porto() {
    }

    public Porto(int cntBarche) {
        this.cntBarche = cntBarche;

        //l'istanza di un oggetto contenuto in un altro va realizzata all'interno del costruttore della classe contenitore
        vBarche = new Barca[N_MAX];
    }

    public static int getnMax() {
        return N_MAX;
    }

    public Barca[] getvBarche() {
        return vBarche;
    }

    public void setvBarche(Barca[] vBarche) {
        this.vBarche = vBarche;
    }

    public int getCntBarche() {
        return cntBarche;
    }

    public void setCntBarche(int cntBarche) {
        this.cntBarche = cntBarche;
    }

    public void addBarca() throws PortoPienoException {
        if (cntBarche > N_MAX){
            throw new PortoPienoException(1, "Porto pieno!");
        }
        vBarche[cntBarche] = new Barca();
        System.out.println("\nDati nave: ");
        System.out.println("Tipologia:");
        String tipologia = InputOutputUtility.leggiNome();
        if(tipologia.equals("vela")){

        }

        vBarche[cntBarche].setTipologia(tipologia);
        System.out.println("Nome: ");
        vBarche[cntBarche].setNome(InputOutputUtility.leggiNome());
        System.out.println("Nazionalità: ");
        vBarche[cntBarche].setNazionalita(InputOutputUtility.leggiNome());
        System.out.println("Lunghezza: ");
        vBarche[cntBarche].setLunghezza(InputOutputUtility.leggiNumeroDouble());
        System.out.println("Stazza: ");
        vBarche[cntBarche].setStazza(InputOutputUtility.leggiNumero());
        this.cntBarche ++;
    }

    public double rimuoviBarca(int posizione) {
        double prezzo;
        int giorni;
        System.out.println("Giorni di sosta:");
        giorni = InputOutputUtility.leggiNumero();
        if(vBarche[posizione].getTipologia().equals("vela")){
            prezzo = 10 * giorni * vBarche[posizione].getLunghezza();
        }else{
            prezzo = 20 * giorni * vBarche[posizione].getStazza();
        }
        vBarche[posizione] = null;
        cntBarche--;
        return prezzo;
    }

    public void infoBarca(int posizione){
        System.out.println(vBarche[posizione].toString());
    }

    public void barcheNazionalita(Barca[] vBarcheNazionalita, String nazionalita){
        int contatoreBarche = 0;
        for (int conta=0; conta < N_MAX; conta++) {
            if (vBarche[conta] != null && vBarche[conta].getNazionalita().equals(nazionalita)) {

                vBarcheNazionalita[contatoreBarche] = vBarche[conta];
                contatoreBarche++;
            }
        }
    }

    /*public void toFile(String line) throws IOException, FilerException {
        writer.write(line);
        writer.newLine();
    }*/

    public void stampa() {
        System.out.println("Porto");
        for(int conta=0; conta<N_MAX;conta++){
            if(vBarche[conta]!=null){
                System.out.println(vBarche[conta].toString());
            }
        }
    }

    public static void main(String[] args) {
        Porto porto = new Porto(0);

        try {
            porto.addBarca();
            porto.addBarca();
            porto.addBarca();

        } catch (PortoPienoException e) {
            e.printStackTrace();
        }
        double prezzo = porto.rimuoviBarca(1);
        System.out.println("La barca costa "+prezzo+ "€");

        porto.infoBarca(0);
        porto.stampa();
        Barca vBarcheNazionalita[];
        vBarcheNazionalita = new Barca[N_MAX];
        System.out.println("Barche di nazionalità italiana");
        porto.barcheNazionalita(vBarcheNazionalita, "Italia");
        for(int i = 0;i < N_MAX; i++){
            if(vBarcheNazionalita[i]!=null){
                System.out.println(vBarcheNazionalita[i].toString());
            }
        }

        /*for(int i=0;i<N_MAX;i++) {
            try {
                porto.toFile(porto.vBarche[i].toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}
