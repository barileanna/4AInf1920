package it.itis.cuneo;

public class Vettore {
    //attributi
    private Punto puntoOrigine;
    private Punto puntoVertice;

    //metodi
    //costruttori
    public Vettore(){}

    public Vettore(Punto puntoOrigine, Punto puntoVertice){
        this.puntoOrigine = new Punto(puntoOrigine);
        this.puntoVertice = new Punto(puntoVertice);
    }

    public Vettore(Vettore vettore){
        puntoOrigine = new Punto(vettore.getPuntoOrigine());
        puntoVertice = new Punto(vettore.getPuntoVertice());
    }

    public void setPuntoOrigine(Punto puntoOrigine) {
        this.puntoOrigine = puntoOrigine;
    }

    public Punto getPuntoOrigine() {
        return this.puntoOrigine;
    }

    public void setPuntoVertice(Punto puntoVertice) {
        this.puntoVertice = puntoVertice;
    }

    public Punto getPuntoVertice() {
        return this.puntoVertice;
    }

    public boolean equals(Vettore vettore){
        boolean equals = false;
        if(puntoOrigine.equals(vettore.puntoOrigine) && puntoVertice.equals(vettore.puntoVertice)){
            equals = true;
        }
        return equals;
    }

    public double lenght(){
        double lunghezza;
        lunghezza = Math.pow(puntoOrigine.getX()-puntoVertice.getX(),2) - Math.pow(puntoOrigine.getY()-puntoVertice.getY(),2);
        if(lunghezza<0){
            lunghezza = -lunghezza;
        }
        return Math.sqrt(lunghezza);
    }

    public String toString(){
        return ("Origine{ \"x:\" " +this.puntoOrigine.getX()+" ,"+"\"y:\" "+this.puntoOrigine.getY()+"}"+"\nVertice{ \"x: \""+puntoVertice.getX()+","+"\"y: \""+puntoVertice.getY()+"}");
    }

    public static void main(String[] args){
        Punto a = new Punto(1,3);
        Punto b = new Punto(8,3);

        Vettore vet1 = new Vettore(a,b);
        Vettore vet2 = new Vettore(vet1);

        double lunghezza = vet1.lenght();

        System.out.println("I due vettori sono uguali? " + vet1.equals(vet2));

        System.out.println("Lunghezza vettore 1: "+lunghezza);

        System.out.println("vettore 1 "+vet1.toString());
        System.out.println("vettore 2 "+vet2.toString());
    }
}
