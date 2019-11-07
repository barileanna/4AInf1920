package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 24/10/2019.
 */

//la throws non è obbligatoria, il metodo può rilanciare eccezioni anche enza averlo esplicitato. La mettiamo per poterlo esplicitare.
//nel caso in cui si rilanci un'eccezioni senza averla esplicitata, il programma la rilancia comunque
public class EccezionaleRicevitore {

    //dico l'eccezione più fine (AritmeticException -> visto nello stackTrace)
    public int divisione(int numeratore, int denominatore)throws ArithmeticException{
        int quoto= 0;

        quoto = numeratore/denominatore;


        return quoto;
    }

    //un'eccezione rappresenta un imprevisto straordinario
    //un'eccezione gestisce quello che non ho preventivato
    public static void main(String[] args) {

        EccezionaleRicevitore eccezionaleRicevitore = new EccezionaleRicevitore();

        try{
            eccezionaleRicevitore.divisione(5,0);
        }
        catch(ArithmeticException aEx){
            System.out.println("catch(ArithmeticException aEx)");
            aEx.printStackTrace();
        }
        catch (Exception ex){
            System.out.println("catch (Exception ex)");
            ex.printStackTrace();
        }
        finally {
            System.out.println("Ne esco sempre bene!");
        }

    }
}

//metodo che viene richiamato fino a quando non si sono verificate 5 eccezioni dello stesso metodo
//random dentro il metodo, random estrae un numero. Se esce uno il metodo rilancia l'eccezione, se è 0 non rilancia l'eccezione.
//il main richiama n volte il metodo, fino a quando non ho ottenuto  eccezioni