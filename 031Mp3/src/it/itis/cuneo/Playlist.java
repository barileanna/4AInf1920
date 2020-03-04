package it.itis.cuneo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist {
    private List<Brano> listaBrani;
    private PlaylistFile playlistFile;

    public Playlist() {
        super();
        playlistFile = new PlaylistFile();
        this.listaBrani = new ArrayList<Brano>();
    }

    public Playlist(List<Brano> listaBrani) {
        new Playlist();
        this.listaBrani = listaBrani;
    }

    public List<Brano> getListaBrani() {
        return listaBrani;
    }

    public void setListaBrani(List<Brano> listaBrani) {
        this.listaBrani = listaBrani;
    }

    public PlaylistFile getPlaylistFile() {
        return playlistFile;
    }

    public void setPlaylistFile(PlaylistFile playlistFile) {
        this.playlistFile = playlistFile;
    }

    public String listaBrani(){
        String s="";
        for(int cnt=0;cnt<listaBrani.size();cnt++){
            Brano brano = listaBrani.get(cnt);
            s = s + brano.toString();
        }
        return s;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "listaBrani=" + listaBrani() +
                '}';
    }

    public void addBrano(Brano brano) {
        listaBrani.add(brano);
    }

    public int findBrano(List<Brano> aBrani, Brano brano) {
        for(int cntBrani = 0; cntBrani<aBrani.size(); cntBrani++){
            Brano brano1 = aBrani.get(cntBrani);
            if(brano1.equals(brano))
                return cntBrani;
        }
        return -1;
    }

    public int durataTotale(List<Brano> aBrani){
        int durata = 0;
        for(int cntBrani = 0; cntBrani<aBrani.size(); cntBrani++){
            Brano brano = aBrani.get(cntBrani);
            durata = durata + brano.getDurata();
        }
        return durata;
    }

    public Brano[] vettoreNbrani(List<Brano> aBrani, int n){
        Brano[] vBrani = new Brano[n];
        int cntVettore = 0;

        for (int cntBrani = 0; cntBrani<n;cntBrani++){
            Brano brano = aBrani.get(cntBrani);
            vBrani[cntVettore] = brano;
            cntVettore++;
        }
        return vBrani;
    }

    public List<Brano> vettoreTriproduzione(List<Brano> aBrani, int t){
        ArrayList<Brano> vBrani = new ArrayList<Brano>();
        int tempo = 0;
        for (int cntBrani = 0; tempo+aBrani.get(cntBrani).getDurata()<t; cntBrani++){
            Brano brano = aBrani.get(cntBrani);
            tempo = tempo + brano.getDurata();
            vBrani.add(brano);
        }
        return vBrani;
    }

    public void spostaBranoPrima(List<Brano> aBrani, int posizione){
        Brano brano = aBrani.get(posizione);
        aBrani.set(posizione-1,brano);
    }

    public void spostaBranoDopo(List<Brano> aBrani, int posizione){
        Brano brano = aBrani.get(posizione);
        aBrani.set(posizione+1,brano);
    }

    public List<Brano> playlistCasuale(List<Brano> listaBrani){
        ArrayList<Brano> vBrani = new ArrayList<Brano>();
        for(int cntBrani=0;cntBrani<listaBrani.size();cntBrani++) {
            Random random = new Random();
            int casuale = random.nextInt(listaBrani.size());
            Brano brano = listaBrani.get(casuale);
            vBrani.add(brano);
        }
        return vBrani;
    }

    public void simula() {
        listaBrani.add(new Brano("Landslide",199));
        listaBrani.add(new Brano("TimeAfterTime",245));
        listaBrani.add(new Brano("Royals",190));
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.simula();
        playlist.getPlaylistFile().scriveFile(playlist.getListaBrani());
        List<Brano> lBrani = playlist.getPlaylistFile().leggiFile();
        playlist.setListaBrani(lBrani);

        System.out.println(playlist.toString());
    }
}
