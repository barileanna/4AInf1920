package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

public class Brano {
    private int idBrano;
    private String titolo;
    private int durata;
    private String autore;

    public Brano() {
    }

    public Brano(int idBrano, String titolo, int durata, String autore) {
        this.idBrano = idBrano;
        this.titolo = titolo;
        this.durata = durata;
        this.autore = autore;
    }

    public Brano(Brano brano){
        this.idBrano = brano.getIdBrano();
        this.titolo = brano.getTitolo();
        this.durata = brano.getDurata();
        this.autore = brano.getAutore();
    }

    public int getIdBrano() {
        return idBrano;
    }

    @XmlAttribute
    public void setIdBrano(int idBrano) {
        this.idBrano = idBrano;
    }

    public String getTitolo() {
        return titolo;
    }

    @XmlElement
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    @XmlElement
    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getAutore() {
        return autore;
    }

    @XmlElement
    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Brano[" +
                "idBrano=" + idBrano + ", titolo='" + titolo + '\'' +
                ", durata='" + durata + '\'' + ", autore='" + autore + '\'' + ']';
    }

    public String toXml() {
        return "\t<brano idBrano=\"" + idBrano +"\">" +
                "\n\t\t<titolo>" + titolo + "</titolo>\n" +
                "\t\t<durata>" + durata + "</durata>\n" +
                "\t\t<autore>" + autore + "</autore>\n" +
                "\t</brano>\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brano brano = (Brano) o;
        return idBrano == brano.idBrano &&
                durata == brano.durata &&
                Objects.equals(titolo, brano.titolo) &&
                Objects.equals(autore, brano.autore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBrano, titolo, durata, autore);
    }
}