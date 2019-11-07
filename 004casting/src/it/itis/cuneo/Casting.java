package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 30/09/2019.
 */
public class Casting {

    //conversione tra classe e classe, partendo da un primitivo
    public static void main(String[] args) {

        //Float: classe wrapper(contiene un primitivo dello stesso tipo e dei metodi che permettono di lavorarci sopra), contiene anche il primitivo
        //float: è un tipo primitivo(variabile)
        Float f;

        //0.524 è un primitivo
        f = new Float(0.524d);

        //System.out.println(String s);
        //La firma del metodo sopra richiede una stringa come parametro,quindi il float viene convertito in una stringa al momento della chiamata
        //System.out.println(float fPrimitivo)
        //Nel caso della firma sopra passiamo un float wrapper, il metodo vuole un tipo primitivo. Il programma fa in automatico un cast implicito
        System.out.println("Da double a float"+f);

        //da double a intero
        double dN = 6.5d;
        int intN = (int) dN;//converte un double in un int
        Integer iN = new Integer(intN); //converto da int a Integer (sono int come parametro)
        iN = intN; //wrapper = primitivoDelloStessoTipo
        System.out.println("Da double a intero "+iN);



        String quanteMele = "8";
        int s;
        s = Integer.parseInt(quanteMele);
        System.out.println("Da stringa a intero "+s);

        //da intero a float 2
        int n=5;
        Float ogF;
        ogF = new Float(n);
        System.out.println("Da intero a float "+ogF);

        //da stringa a float 3
        String str = "5.25f";
        Float ogF1;
        ogF1 = Float.parseFloat(str);
        System.out.println("Da stringa a float "+ogF1);

        //da float a stringa 4
        // metodo 1
        String s2;
        s2 = ""+ ogF1; //concatenazione
        // oppure s2=new String(solo primitivo float)(costruttore)
        System.out.println("Da float a stringa(1 metodo) "+s2);

        //da float a stringa 4
        // metodo 2
        String s3;
        s3 = ogF1.toString(); // toString
        System.out.println("Da float a stringa(2 metodo)  "+s3);

        //da float a stringa 4
        // metodo 3
        String s4;
        s4 = new String(""+ ogF1); // costruttore
        System.out.println("Da float a stringa(3 metodo)  "+s4);
        // stampa ---> System.out.println("s4 = new String(\"\"+ ogF1)" +s3);

    }
}
