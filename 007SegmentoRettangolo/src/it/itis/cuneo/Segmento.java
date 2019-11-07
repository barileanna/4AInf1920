package it.itis.cuneo;

public class Segmento {
    //attributi
    private Punto uno;
    private Punto due;

    //metodi
    //costruttori
    public Segmento(){}

    public Segmento(Punto uno, Punto due){
        this.uno = uno;
        this.due = due;
    }

    public void setUno(Punto uno) {
        this.uno = uno;
    }

    public Punto getUno() {
        return uno;
    }

    public void setDue(Punto due) {
        this.due = due;
    }

    public Punto getDue() {
        return due;
    }


    public double lunghezza(){
        double dis;
        dis = Math.pow(uno.getX()-due.getX(),2) - Math.pow(uno.getY()-due.getY(),2);
        if(dis<0){
            dis = -dis;
        }
        return Math.sqrt(dis);
    }

}


