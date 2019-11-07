package it.itis.cuneo;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by inf.barilea1810 on 30/10/2019.
 */

//sempre costruttori, setter e getter, toString e equals

public class Libreria {

    //definizione di un vettore, con tutte e tre le proprietà
    public static final int MAX_LIBRI = 2;
    private Libro[] vLibro;
    //cntLibri<= MAX_LIBRI
    private int cntLibro;

    public Libreria() {
        //costruttore di Array
        vLibro = new Libro[MAX_LIBRI];
        //all'inizio ci sono 0 libri
        cntLibro = 0;
    }

    public static int getMaxLibri() {
        return MAX_LIBRI;
    }

    public Libro[] getvLibro() {
        return vLibro;
    }

    public void setvLibro(Libro[] vLibro) {
        this.vLibro = vLibro;
    }

    public int getCntLibro() {
        return cntLibro;
    }

    public void setCntLibro(int cntLibro) {
        this.cntLibro = cntLibro;
    }

    public void addLibro(Libro libro) throws LibreriaPiena{

        //lancio eccezione di tipo LibreriaPiena
        //possibile perchè LibreriaPiena extends Exception
        //esempio utilizzo di un'eccezione
        if(cntLibro+1 > MAX_LIBRI){
            throw new LibreriaPiena(1, "Troppi Libri!!");
        }
        else {
            //inserisco un nuovo libro
            vLibro[cntLibro] = libro;
            //aggiungo il libro al contatore
            cntLibro++;
        }

    }

    @Override
    public String toString() {
        return "Libreria{" +
                "vLibro=" + Arrays.toString(vLibro) +
                ", cntLibro=" + cntLibro +
                '}';
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("Alice", "Lewis Carroll", "179174heqgwe", InputOutputUtility.convertiDataOraToCalendar("12/10/2019", InputOutputUtility.dfDay));

        Libro libro2 = new Libro("Pinocchio", "Carlo Collodi", "hdh21389", InputOutputUtility.convertiDataOraToCalendar("11/10/2019",InputOutputUtility.dfDay));

        Libreria libreria = new Libreria();
        try {
            //throws
            libreria.addLibro(libro1);
            libreria.addLibro(libro2);
            libreria.addLibro(libro2);
        } catch (LibreriaPiena libreriaPiena) {
            //manage
            libreriaPiena.printStackTrace();
            System.err.println(libreriaPiena.toString());
        }
        //console
        System.err.println(libreria.toString());
        //System.in --> input/keyboard  /black
        //Sistem.err --> error console  /red
        //bytecode = formato con cui la macchina virtuale trasforma java in .class

    }
}