package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 17/10/2019.
 */
public class Libro {
    private String titolo;
    private Autore autore;
    private CasaEditrice casaEditrice;
    private int data;

    public Libro(){}

    public Libro(String titolo, Autore autore, CasaEditrice casaEditrice, int data){
        this.titolo = new String(titolo);
        this.autore = new Autore(autore);
        this.casaEditrice = new CasaEditrice(casaEditrice);
        this.data = data;
    }

    public Libro(Libro libro){
        this.titolo = new String(titolo);
        this.autore = new Autore(autore);
        this.casaEditrice = new CasaEditrice(casaEditrice);
        this.data = data;
    }
}
