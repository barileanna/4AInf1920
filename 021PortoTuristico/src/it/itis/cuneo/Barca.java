package it.itis.cuneo;

public class Barca {
    private String nome;
    private String nazionalita;
    private double lunghezza;
    private double stazza;
    private String tipologia;

    public Barca() {
    }

    public Barca(String nome, String nazionalita, double lunghezza, double stazza, String tipologia) {
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.lunghezza = lunghezza;
        this.stazza = stazza;
        this.tipologia = tipologia;
    }

    public Barca(Barca barca){
        this.nome = barca.getNome();
        this.nazionalita = barca.getNazionalita();
        this.lunghezza = barca.getLunghezza();
        this.stazza = barca.getStazza();
        this.tipologia = barca.getTipologia();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public double getStazza() {
        return stazza;
    }

    public void setStazza(double stazza) {
        this.stazza = stazza;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @Override
    public String toString() {
        return "Barca{" +
                "nome='" + nome + '\'' +
                ", nazionalita='" + nazionalita + '\'' +
                ", lunghezza=" + lunghezza +
                ", stazza=" + stazza +
                ", tipologia='" + tipologia + '\'' +
                '}';
    }
}
