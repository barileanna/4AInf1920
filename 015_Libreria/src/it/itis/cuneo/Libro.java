package it.itis.cuneo;

import java.util.Calendar;

/**
 * Created by inf.barilea1810 on 30/10/2019.
 */
public class Libro {
    //attributi
    private String titolo;
    private String autore;
    private String isbn;
    private Calendar dataPubblicazione;

    //costruttori
    public Libro() {
    }

    //costruttore per tipo
    public Libro(String titolo, String autore, String isbn, Calendar dataPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.dataPubblicazione = dataPubblicazione;
    }

    //costruttore per copia
    public Libro(Libro libro) {
        this.titolo = libro.getTitolo();
        this.autore = libro.getAutore();
        this.isbn = libro.getIsbn();
        this.dataPubblicazione = libro.getDataPubblicazione();
    }

    //getter e setter
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Calendar getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(Calendar dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public boolean equals (Libro libro){
        boolean bEquals = false;
        if(titolo != null && titolo.equals(libro.getTitolo()) &&
                autore!=null && autore.equals(libro.getAutore()) &&
                isbn != null && isbn.equals(libro.getIsbn()) &&
                dataPubblicazione != null && dataPubblicazione.equals(libro.getDataPubblicazione())) {
            bEquals = true;
        }
        return bEquals;
    }

    /* equals generato automaticamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        if (titolo != null ? !titolo.equals(libro.titolo) : libro.titolo != null) return false;
        if (autore != null ? !autore.equals(libro.autore) : libro.autore != null) return false;
        if (isbn != null ? !isbn.equals(libro.isbn) : libro.isbn != null) return false;
        return dataPubblicazione != null ? dataPubblicazione.equals(libro.dataPubblicazione) : libro.dataPubblicazione == null;
    }

    hascode : stringa ottenuta da un'insieme di altri dati (codice fiscale)

    */



}
