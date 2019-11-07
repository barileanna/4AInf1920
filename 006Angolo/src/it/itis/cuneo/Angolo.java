package it.itis.cuneo;

import javax.swing.*;

public class Angolo {
    //attributi
    private int g;
    private int p;
    private int s;

    //metodi
    //costruttori
    public Angolo(){

    }

    public Angolo(int g, int p, int s){
        this.g = g;
        this.p = p;
        this.s = s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getS(){
        return this.s;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getP() {
        return this.p;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getG() {
        return this.g;
    }

    public void visualizzaAngolo(){
        System.out.println("Angolo: "+this.g+"° "+this.p+"'"+this.s+"''");
    }

    public void aggiungiGradi(int n){
        this.g += n;
    }

    public void aggiungiPrimi(int n){
        this.p += n;
        if(this.p >=60){
            this.p = this.p-60;
            this.g++;
        }
    }

    public void aggiungiSecondi(int n){
        this.s += n;
        if(this.s >=60){
            this.s = this.s-60;
            this.p++;
            if(this.p>=60) {
                this.p -= 60;
                this.g++;
            }
        }
    }

    public int angoloSecondi(){
        int tot = 0;
        tot = this.s + (60*this.p)+ (3600*this.g);
        return tot;
    }

    public void secondiAngolo(int n){
        if(n>=60){
            this.p = n/60;
            this.s = n-(this.p*60);
            this.g = 0;
            if(this.p>=60) {
                do {
                    this.g++;
                    this.p = this.p - 60;
                } while (this.p >= 60);
            }
        }
        else{
            this.s = n;
            this.p = 0;
            this.g = 0;
        }
    }

    public int differenzaAngolo(Angolo angolo){
        int differenza=0;
        differenza = angoloSecondi() - angolo.angoloSecondi();
        return differenza;
    }

    public Angolo sommaAngolo(Angolo angolo){
        Angolo angoloRes = new Angolo();
        int x;
        x = angoloSecondi();
        x = x+angolo.angoloSecondi();
        angoloRes.secondiAngolo(x);
        return angoloRes;
    }

    public static void main(String[] args){
        Angolo a = new Angolo(13,42,15);
        Angolo b = new Angolo(15,22,30);
        Angolo c = new Angolo(10,59,59);
        int x;

        System.out.println("a:");
        a.visualizzaAngolo();
        System.out.println("b:");
        b.visualizzaAngolo();

        x = a.angoloSecondi();
        System.out.println("\nAngolo a in secondi: "+x);

        x = b.angoloSecondi();
        System.out.println("Angolo b in secondi: "+x);

        x = a.differenzaAngolo(b);
        System.out.println("\nDifferenza A e B in secondi: "+x);

        a = a.sommaAngolo(b);
        System.out.println("\nSomma angoli: ");
        a.visualizzaAngolo();

        a.secondiAngolo(16395);
        a.visualizzaAngolo();

        c.aggiungiSecondi(2);
        c.aggiungiPrimi(5);
        c.aggiungiGradi(2);



        System.out.println("\nAngolo a modificato(+2 °, +5', +2'')");
        c.visualizzaAngolo();
    }


}
