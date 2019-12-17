package it.itis.cuneo;

public class Libro {
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina = 0.05;
    final double COSTO_FISSO=5.5;

    public Libro() {
    }

    public Libro(String titolo, String autore, int numeroPagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroPagine = numeroPagine;
    }

    public Libro(Libro libro) {
        this.titolo = libro.getTitolo();
        this.autore = libro.getAutore();
        this.numeroPagine = libro.getNumeroPagine();
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

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public double prezzo(){
        return COSTO_FISSO+numeroPagine*costoPagina;
    }

    public static void setCostoPagina(double costo) {
        costoPagina = costo;
    }
}
