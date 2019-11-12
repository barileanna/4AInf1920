package it.itis.cuneo;



public class Programma {

    private String denominazione;

    private String produttore;

    private String versione;

    private String sistemaOperativo;

    private int anno;



    public Programma(){

    }



    public Programma(String denominazione, String produttore, String versione, String sistemaOperativo, int anno){

        this.denominazione = denominazione;

        this.produttore = produttore;

        this.versione = versione;

        this.sistemaOperativo = sistemaOperativo;

        this.anno = anno;

    }



    public Programma(Programma programma){

        this.denominazione = new String(programma.getDenominazione());

        this.produttore = new String (programma.getProduttore());

        this.versione = new String(programma.getVersione());

        this.sistemaOperativo = new String(programma.getSistemaOperativo());

        this.anno = programma.getAnno();

    }



    public void setDenominazione(String denominazione) {

        this.denominazione = new String(denominazione);

    }



    public String getDenominazione() {

        return denominazione;

    }



    public void setProduttore(String produttore) {

        this.produttore = new String(produttore);

    }



    public String getProduttore() {

        return produttore;

    }



    public void setVersione(String versione) {

        this.versione = new String(versione);



    }



    public String getVersione() {

        return versione;

    }



    public void setSistemaOperativo(String sistemaOperativo) {



        this.sistemaOperativo = new String(sistemaOperativo);

    }



    public String getSistemaOperativo() {

        return sistemaOperativo;

    }



    public void setAnno(int anno) {



        this.anno = anno;

    }



    public int getAnno() {

        return anno;

    }



    public String toString(){

        return ("Programma: "+"\"Denominazione:\""+this.denominazione+" \"Produttore:\""+this.produttore+"  \"Versione:\""+this.versione+"  \"Sistema operativo:\""+this.sistemaOperativo+" \"Anno:\""+this.anno);

    }



    public int comapreAnno(Programma programma){

        int confronto;



        confronto = Math.abs(this.anno - programma.getAnno());

        return confronto;

    }

}