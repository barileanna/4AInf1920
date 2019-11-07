package it.itis.cuneo;

public class Persona {
    //attributi
    private int eta;
    private String nome;
    private String sesso;
    private String professione;

    //metodi
    //costruttori
    public Persona(){

    }

    public Persona(int eta, String nome, String sesso, String professione){
        this.eta = eta;
        this.nome = nome;
        this.sesso = sesso;
        this.professione = professione;
    }
    public void setEta(int eta){
        this.eta = eta;
    }

    public int getEta(){
        return this.eta;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setSesso(String sesso){
        this.sesso = sesso;
    }

    public String getSesso(){
        return this.sesso;
    }

    public void setProfessione(String professione){
        this.professione = professione;
    }

    public String getProfessione(){
        return this.professione;
    }

    public String chiSei(){
        return "\nSono una persona di nome: "+nome+", sesso: "+sesso+", età: "+eta+" e professione: "+professione;
    }

    public static void main(String[] args) {
        Persona a = new Persona(16, "Anna", "femmina", "studentessa");

        System.out.println(a.chiSei());
    }


}
