import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "Album")
public class Album implements Comparable {

    private int idAlbum;
    private String titolo;
    private String autore;
    private List<Brano> aBrani;

    public Album(int idAlbum, String titolo, String autore) {
        this.idAlbum = idAlbum;
        this.titolo = titolo;
        this.autore = autore;
        aBrani = new ArrayList<Brano>();
    }

    public Album() {
        aBrani = new ArrayList<Brano>();
    }


    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public List<Brano> getaBrani() {
        return aBrani;
    }

    @XmlElement(name = "Brano")
    public void setaBrani(List<Brano> aBrani) {
        this.aBrani = aBrani;
    }

    public void aggiungiBrano(Brano brano){
        this.aBrani.add(brano);
    }

    public void caricaAlbum(Libreria libreria){
        idAlbum = InputOutputUtility.leggiNumero("Inserire codice dell'album: ");
        titolo = InputOutputUtility.leggiNome("Inserire il titolo dell'album: ");
        autore = InputOutputUtility.leggiNome("Inserire l'autore dell'album: ");
        Album album = new Album(idAlbum, titolo, autore);
        libreria.aggiungiAlbum(album);

        int numeroBrani = InputOutputUtility.leggiNumero("Inserisci il numero totale di brani dell'album: ");
        for(int cntBrani = 0; cntBrani < numeroBrani; cntBrani++) {
            Brano brano = new Brano();
            brano = brano.caricaBrano();
            album.aggiungiBrano(brano);
        }
    }

    @Override
    public String toString() {
        return "Album[" +
                "idAlbum=" + idAlbum +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", aBrani=" + aBrani +
                ']';
    }

    public String toRowCSV() {
        return "Album" + Libreria.SEPARATOR + idAlbum + Libreria.SEPARATOR + titolo + Libreria.SEPARATOR
                + autore + "\n";
    }

    public void eliminaBrano(int idAlbum){
        int numBrani = aBrani.size();
        for(int cntBrani = 0; cntBrani<numBrani; cntBrani++){
            if(aBrani.get(cntBrani).getIdBrano() == idAlbum) {
                this.aBrani.remove(cntBrani);
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        Album album = (Album) o;
        if(this.titolo.equalsIgnoreCase( album.titolo))
            return 1;
        else
            return 0;
    }
}
