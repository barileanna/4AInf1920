package it.itis.cuneo;
/**
 * Created by inf.barilea1810 on 21/09/2019.
 */

import java.lang.Math;

public class Punto {

    //attributi
    private int x;
    private int y;

    //metodi
    //costruttore senza parametri
    public Punto(){

    }

    public Punto( int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX (int x){
        this.x = x;
    }

    public double getX (){
        return this.x;
    }
    public void setY (int y){
        this.y = y;
    }

    public double getY (){
        return this.y;
    }

    public int numeroQuadrante(){
        int quadrante;

        if(this.x>0) {
            if(this.y>0){
                quadrante=1;
            }
            else{
                quadrante=4;
            }
        }
        else{
            if(y>0){
                quadrante=2;
            }
            else{
                quadrante=3;
            }
        }
        return quadrante;
    }

    public double distanza(Punto punto){
        double dis;
        dis = Math.pow(this.x-punto.getX(),2) - Math.pow(this.y-punto.getY(),2);
        if(dis<0){
            dis = -dis;
        }
        return Math.sqrt(dis);
    }

    public boolean puntiUguali(Punto punto){
        boolean uguali=false;
        if(this.x==punto.getX() && this.y==punto.getY()){
            uguali=true;
        }
        return uguali;
    }

    public String toString(){
        return "(" + x + ", " + y +")";
    }

    public static void main(String[] args){
        Punto a = new Punto(-2,-6);
        Punto b = new Punto(2,6);


        System.out.println("\nQuadrante punto A: "+ a.numeroQuadrante());
        System.out.println("\nQuadrante punto B: "+ b.numeroQuadrante());

        System.out.println("\nDistanza: "+ a.distanza(b));

        System.out.println("\nI punti corrispondono? "+ a.puntiUguali(b));

        System.out.println("\nA"+a.toString());
        System.out.println("\nB"+b.toString());
    }
}

