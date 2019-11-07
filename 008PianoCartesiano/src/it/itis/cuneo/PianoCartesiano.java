package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 07/10/2019.
 */
public class PianoCartesiano {
    //static serve per creare variabili condivise

    //costante(public final(non modificabile) static e variabile maiuscola)
    public final static int MAX_X = 800;
    public final static int MAX_Y = 900;

    //private static(attributi statici): attributi di classe
    //costanti che però possono essere modificate
    private static int ox = 0;
    private static int oy = 0;

    //attributi
    private Rettangolo rettangolo1  ;
    private Rettangolo rettangolo2;

    //metodi
    //costruttori
    public PianoCartesiano(Rettangolo rettangolo1, Rettangolo rettangolo2){
        this.rettangolo1 = new Rettangolo(rettangolo1);
        this.rettangolo2 = new Rettangolo(rettangolo2);
    }

    public PianoCartesiano(PianoCartesiano pianoCartesiano){
        this.rettangolo1 = new Rettangolo(pianoCartesiano.getRettangolo1());
        this.rettangolo2 = new Rettangolo(pianoCartesiano.getRettangolo2());
    }

    public static void setOx(int ox) {
        PianoCartesiano.ox = ox;
    }

    public static int getOx(){
        return ox;
    }

    public Rettangolo getRettangolo1() {
        return this.rettangolo1;
    }

    public Rettangolo getRettangolo2() {
        return this.rettangolo2;
    }

    public boolean equlas(PianoCartesiano pianoCartesiano){
        boolean equals=false;
        if(rettangolo1.equals(pianoCartesiano.getRettangolo1()) && rettangolo2.equals(pianoCartesiano.getRettangolo2())){
            equals=true;
        }
        return equals;
    }

    public String toString(){
        String str="";
        str="PianoCartesiano{\"rettangolo1\":"+rettangolo1+","+"\"rettangolo2\":"+rettangolo2+"}";
        //equivate a "\"rettangolo2\":"+rettangolo2.toString()+"}";
        return str;
    }

    public static void main(String[] args) {
        //static definisce una variabile globale condivisa per tutte le istanze della classe
        //Alle variabili statiche, tipo ox, si accede con PianoCartesiano (senza utilizzare il costruttore)

        int maxX = PianoCartesiano.MAX_X;//costante solo in lettura (non modificabile)
        //se l'attributo condiviso viene modificato, per tutti gli oggetti
        PianoCartesiano.setOx(10);//la posso scrivere e la posso leggere
        int myOx = PianoCartesiano.getOx();
        System.out.println(myOx);
    }
}

