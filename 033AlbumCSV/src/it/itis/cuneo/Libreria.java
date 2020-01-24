package it.itis.cuneo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Libreria {
    public static final String FILE_NAME = "C:\\Users\\Anna\\Desktop\\033AlbumCSV\\libreria.csv";
    public static final String SEPARATOR = ",";

    private List<Album> aAlbum;

    public Libreria() {
        super();
        aAlbum = new ArrayList<Album>();
    }

    public Libreria(List<Album> aAlbum) {
        this.aAlbum = aAlbum;
    }

    public List<Album> getaAlbum() {
        return aAlbum;
    }

    public void setaAlbum(List<Album> aAlbum) {
        this.aAlbum = aAlbum;
    }

    public void aggiungiAlbum(Album album){
        aAlbum.add(album);
    }

    public void caricaAlbum(Libreria libreria){
        int numeroAlbum = InputOutputUtility.leggiNumero("Inserire il numero di album da aggiungere: ");

        Album album = new Album();
        for(int cntAlbum = 0; cntAlbum<numeroAlbum; cntAlbum++){
            album.caricaAlbum(libreria);
        }

    }

    @Override
    public String toString() {
        return "Libreria[" +
                "aAlbum=" + aAlbum +
                ']';
    }

    public void stampa() {
        System.out.println(toString());
    }

    public void ordinaAlbum() {
        Collections.sort( this.aAlbum);
    }

    public Album ricercaAlbum(String titolo, String autore){
        Album album = null;
        boolean trovato = false;

        for(int cntAlbum = 0; cntAlbum<aAlbum.size();cntAlbum++){
            album = aAlbum.get(cntAlbum);
            if(album.getTitolo().equalsIgnoreCase(titolo) && album.getAutore().equalsIgnoreCase(autore)){
                trovato = true;
            }
            else {
                album = null;
            }
        }
        return album;
    }

    public void salvaCSV() {
        String str ="";
        BufferedWriter bw;
        try {
            bw= new BufferedWriter(new FileWriter(FILE_NAME));

            for(int cntAlbum=0; cntAlbum<this.aAlbum.size(); cntAlbum++)
            {
                Album album = this.aAlbum.get(cntAlbum);
                bw.write(album.toRowCSV());

                for(int cntBrani=0; cntBrani<album.getaBrani().size(); cntBrani++) {
                    Brano brano = album.getaBrani().get(cntBrani);
                    bw.write(brano.toRowCSV());
                }
            }

            //obbligatorio oppure il file rimane vuoto
            //forza lo svuotamento del buffer nel file, dopo di che lo chiude
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void apriFile() {
        BufferedReader br;
        String rowLine;
        Album album = null;

        try {
            br = new BufferedReader(new FileReader(FILE_NAME));

            while((rowLine = br.readLine()) != null){
                String[] campi = rowLine.split(Libreria.SEPARATOR);
                if(campi[0].equalsIgnoreCase("Album")){
                    int id = Integer.parseInt(campi[1]);
                    album = new Album(id,campi[2],campi[3]);
                    aggiungiAlbum(album);
                }
                if(campi[0].equalsIgnoreCase("Brano")){
                    int id = Integer.parseInt(campi[1]);
                    int durata = Integer.parseInt(campi[4]);
                    Brano brano = new Brano(id, campi[2], durata, campi[3]);
                    album.aggiungiBrano(brano);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simula(){
        Album album1 = new Album(245,"Ink","Mandy Moore");
        Album album2 = new Album(2533,"Fuori dall'hype", "PTN");

        Brano brano1 = new Brano(1,"Verdura",158,"PTN");
        Brano brano2 = new Brano(2,"La banalità del mare", 220, "PTN");
        Brano brano3 = new Brano(43,"Invisible Ink", 187, "Mandy Moore");
        Brano brano4 = new Brano(24, "Willin'", 192, "Mandy Moore");

        album2.aggiungiBrano(brano1);
        album2.aggiungiBrano(brano2);
        album1.aggiungiBrano(brano3);
        album1.aggiungiBrano(brano4);

        aggiungiAlbum(album1);
        aggiungiAlbum(album2);
    }

    public static void main(String[] args) {
        Libreria lib = new Libreria();
        lib.simula();

        lib.salvaCSV();

        Libreria lib2 = new Libreria();
        lib2.apriFile();
        System.out.println("Stampa LIBRERIA: ");
        lib2.stampa();
    }

}
