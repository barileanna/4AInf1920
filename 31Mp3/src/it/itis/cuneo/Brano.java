package it.itis.cuneo;

import java.util.StringTokenizer;

public class Brano {

    //attributi
    private String titolo;
    private int durata;

    //costruttori
    public Brano() {
        super();
    }

    public Brano(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    public Brano(Brano brano) {
        this.titolo = brano.getTitolo();
        this.durata = brano.getDurata();
    }

    //metodi
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Brano{" +
                "titolo='" + titolo + '\'' +
                ", durata= " + durata + " sec."+
                '}';
    }

    public void carica(String linea){
        StringTokenizer st = new StringTokenizer(linea, PlaylistFile.SEPARATOR);
        int cntCampi=0;
        while(st.hasMoreElements()){
            String  campoTxt = (String) st.nextElement();

            switch (cntCampi){
                case 0:
                    titolo = campoTxt;
                    break;
                case 1:
                    durata = Integer.parseInt(campoTxt);
                    break;
            }
            cntCampi++;
        }
    }

    public String riga() {
        String rigaFile= "";
        rigaFile = this.titolo +" "+ this.durata+"\n";
        return rigaFile;
    }
}
