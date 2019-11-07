package it.itis.cuneo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Casello {
    //attributi
    private String identificator;
    private Calendar dataEntrata;
    private Calendar dataUscita;

    //metodi
    //costruttori
    public Casello(){}

    public Casello(String identificator, Calendar dataEntrata, Calendar dataUscita){
        this.identificator = identificator;

        Calendar cDataIngresso = Calendar.getInstance();
        cDataIngresso.setTime(dataEntrata.getTime());
        this.dataEntrata = cDataIngresso;

        Calendar cDataUscita = Calendar.getInstance();
        cDataUscita.setTime(dataUscita.getTime());
        this.dataUscita = cDataUscita;
    }

    public Casello(Casello casello){
        this.identificator = new String(casello.getIdentificator());

        Calendar cDataIngresso = Calendar.getInstance();
        cDataIngresso.setTime(casello.getDataEntrata().getTime());
        this.dataEntrata = cDataIngresso;

        Calendar cDataUscita = Calendar.getInstance();
        cDataUscita.setTime(casello.getDataUscita().getTime());
        this.dataUscita = cDataUscita;
    }

    public void setIdentificator(String identificator){
        this.identificator = identificator;
    }

    public String getIdentificator(){
        return this.identificator;
    }

    public void setDataEntrata(Calendar dataEntrata){
        this.dataEntrata = dataEntrata;
    }

    public Calendar getDataEntrata(){
        return this.dataEntrata;
    }

    public void setDataUscita(Calendar dataUscita){
        this.dataUscita = dataUscita;
    }

    public Calendar getDataUscita(){
        return this.dataUscita;
    }

    public String toString(){
        return ("Casello:{ \"Data entrata:\""+dataEntrata.getTime()+"  \"Data uscita:\""+dataUscita.getTime()+"   \"Identificatore:\""+this.identificator+"}");
    }

    public static void main(String[] args) throws ParseException {
        /*
        Calendar cDataUno = Calendar.getInstance();
        cDataUno.setTime(cDataUno.getTime());

        Calendar cDataDue = Calendar.getInstance();
        cDataDue.setTimeInMillis(cDataDue.getTimeInMillis() + 5400000);
        */

        //creo una data (partenza dal casello)
        //cast da stringa a data uso simpleDateForm che possiede un pattern(formato della data)(Simple Date Form)
        //es.     23/10/2019 09:25:52
        //pattern = come io voglio andare a tradurre quello che devo ottenere dalla stringa, formato della data di input (rappresentato da una stringa)
        //pattern dd/MM/yyyy HH:mm:ss
        final String FORMATO_DD_HMS = "dd/MM/yyyy HH:mm:ss";
        String strDataPartenza = "29/08/2002 13:30:40";

        strDataPartenza = InputOutputUtility.leggiNome("Inserisci la data di partenza (dd/MM/yyyy HH:mm:ss)");
        Date dataPartenza = null;
        SimpleDateFormat sdfP = new SimpleDateFormat(FORMATO_DD_HMS);
        //classe unica e non usa il costruttore, ma un metodo di generazioni (get.Instance)
        Calendar cDataPartenza = Calendar.getInstance();
        //parsificare una stringa permette di ottenere una variabile di altro tipo
        //Eccezione anomalia software che si verifica quando il codice genera un'errore in tempo di esecuzione
        //ParseException: indica che la stringa non rispatta il formato atteso
        //errore di esecuzione = comunicazione errata, risposta errata dal punto di vista dal significato
        //a parse devo passare un attributo di tipo Date
        //da usare ogni volta che c'è il rischio che qualcosa vada male
        try {

            dataPartenza = sdfP.parse(strDataPartenza);
            cDataPartenza.setTime(dataPartenza);
            System.out.println(sdfP.format(cDataPartenza.getTime()));
        }
        catch (ParseException e) {
            //Errore nel formato della stringa
            //Viene stampato uno stackTrace: traccia dello stack(= elenco delle chiamate ai metodi)
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally{
            System.out.println("Fine");
        }


        //data di arrivo al casello
        String strDataArrivo = "29/08/2002 14:32:40";
        Date dataArrivo=null;
        Calendar cDataArrivo = Calendar.getInstance();
        try {
            SimpleDateFormat sdfA = new SimpleDateFormat(FORMATO_DD_HMS);
            sdfA.setLenient(false);
            dataArrivo = sdfA.parse(strDataArrivo);
            cDataArrivo.setTime(dataArrivo);
            System.out.println(sdfA.format(cDataArrivo.getTime()));

        } catch (ParseException e) {
            //Errore nel formato della stringa
            //Viene stampato uno stackTrace: traccia dello stack(= elenco delle chiamate ai metodi)
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally{
            System.out.println("Fine");
        }

        int distanza = 200;

        Casello caselloUno = new Casello("1", cDataPartenza, cDataArrivo);
        System.out.println(caselloUno.toString());
        System.out.println(cDataPartenza.getTimeInMillis());

        double tempo = Math.abs(((caselloUno.getDataEntrata().getTimeInMillis()/1000) - (caselloUno.getDataUscita().getTimeInMillis()/1000))/60);


        double velocitaMedia = (distanza / tempo * 60);

        System.out.println("Hai viaggiato ai > " + Math.round(velocitaMedia) + "km/h");


    }


}
