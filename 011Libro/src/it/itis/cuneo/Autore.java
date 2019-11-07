package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 17/10/2019.
 */
public class Autore {
    private String cognome;
    private String nome;
    private int anno;

    public Autore(){}

    public Autore(String cognome, String nome, int anno){
        this.cognome = new String(cognome);
        this.nome = new String(nome);
        this.anno = anno;
    }

    public Autore(Autore autore){
        this.cognome = new String(cognome);
        this.nome = new String(nome);
        this.anno = anno;
    }
}
