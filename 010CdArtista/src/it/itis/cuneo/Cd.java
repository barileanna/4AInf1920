package it.itis.cuneo;

public class Cd {
    private String titolo;
    private String autore;
    private int numeroBrani;
    private double durata;

    //metodi
    //costruttori
    public Cd(){}

    public Cd(String titolo, String autore, int numeroBrani, double durata){
        this.titolo = titolo;
        this.autore = autore;
        this.numeroBrani = numeroBrani;
        this.durata = durata;
    }

    public Cd(Cd cd){
        this.titolo = new String(cd.titolo);
        this.autore = new String(cd.autore);
        this.durata = int cd.numeroBrani;
        this.durata = double cd.durata;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    public String getTitolo(){
        return this.titolo;
    }

    public void setAutore(String autore){
        this.autore = autore;
    }

    public String getAutore(){
        return this.autore;
    }

    public void setNumeroBrani(int numeroBrani){
        this.numeroBrani = numeroBrani;
    }

    public int getNumeroBrani(){
        return this.numeroBrani;
    }

    public void setDurata(double durata){
        this.durata = durata;
    }

    public double getDurata(){
        return this.durata;
    }

    public String toString(){
        return ("CD:"+ "\" Titolo:\""+this.titolo+"\" Autore:\""+this.autore+"\" Numero Brani:\""+this.numeroBrani+"\" Durata:\""+this.durata);
    }

    public Cd comparareDurata(Cd cd){
        Cd res = new Cd(cd);
        if (this.durata>=cd.durata){
            res.setTitolo(this.titolo);
            res.setAutore(this.autore);
            res.setNumeroBrani(this.numeroBrani);
            res.setDurata(this.durata);
        }
        return res;
    }


    public static void main(String[] args){
        Cd cdUno = new Cd("Magmamemoria", "Levante", 13, 46.39);
        Cd cdDue = new Cd("Colpa delle favole", "Ulitmo", 13, 46.10);

        System.out.println("cdUno:"+cdUno.toString());
        System.out.println("cdDue:"+cdDue.toString());

        cdUno = cdUno.comparareDurata(cdDue);
        System.out.println("Il cd più lungo è: "+cdUno.toString());
    }
}
