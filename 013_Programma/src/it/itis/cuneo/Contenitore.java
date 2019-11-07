package it.itis.cuneo;

public class Contenitore {

    private static final int N = 3;
    private Programma[] contenitore;

    public Contenitore() {
        int cont=0;
        contenitore = new Programma[N];
        for(cont=0;cont<N;cont++){
            contenitore[cont]=new Programma();
        }
    }



    public String getProgramma(int posizione){

        return contenitore[posizione].toString();
    }

    public void setProgramma(Programma programma, int posizione){
        contenitore[posizione]=new Programma(programma);

    }



    public static void main(String[] args) {


    }
}
