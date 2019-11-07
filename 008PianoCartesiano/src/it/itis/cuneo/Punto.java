package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 07/10/2019.
 */
public class Punto {

    //attributi
    private int x;
    private int y;

    //metodi
    //costruttori
    public Punto(){
        //a cosa serve???
        super();
    }

    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    //costruttore di copia, che serve quando uno dei tuoi attributi è un wrapper
    public Punto(Punto p){
        x = p.getX();
        y = p.getY();
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public String toString(){
        //nomi di attributi delimitati da apici e metto lo \ per togliere la visibilità degli apici
        return ("Punto{\"x:\" "+this.x+ ","+"\"y\": " +this.y+ "}");
    }

    public boolean equals(Punto punto){
        boolean equals=false;
        if((x==punto.getX()) && y==punto.getY()){
            equals=true;
        }
        return equals;
    }
    public static void main(String[] args){

        //non sono nella stessa area di memoria
        //sono nell'heap ma non puntano alla stessa cella
        /*puntoA e puntoB referenziano due aree di memoria diverse, puntoB è una copia di puntoA per il suo stato,
         ma fisicamente sono di due aree di memoria diverse*/
        Punto puntoA = new Punto(4,6);
        Punto puntoB = new Punto(puntoA);

        //puntano alla stessa area di memoria
        //puntoC e puntoA come handler referenziano la stessa di memoria
        Punto puntoC = puntoA;
        Punto puntoD = new Punto();
        Punto puntoE = null;

        //se il richiamo al costruttore non esiste mi da errore NullPointer
        puntoE = new Punto();

        //stack(pila) --> errore nel main alla riga 64 ed è un errore di tipo NullPointer
        //puntatore a nulla e gli dico scrivi(nulla=non esiste una competenza)
        System.out.println(puntoA.toString());

        System.out.println("A e B sono uguali? -->"+puntoA.equals(puntoB));

    }
}
