package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 07/10/2019.
 */
public class Segmento {
    //attributi
    private Punto punto1;
    private Punto punto2;

    //metodi
    //costruttori

    //se fuori mi elimina gli oggetti perdo tutto, gli oggetti sono creati solo nel main(2 volte richiamo new)
    /*public Segmento(Punto punto1, Punto punto2){
        this.punto1 = punto1;
        this.punto2 = punto2;
    }
    */

    //instanzio degli oggetti
    //aree di memoria diverse, 4 volte richiamo new(due volte furoi e due volte dentro)
    //creo un nuovo blocco(nuovo oggetto Punto, basandosi sulla x e sulla y dell'oggetto che gli hai passato), se fuori mi elimina(metto uguale a NULL i puntatori) gli oggetti
    /*public Segmento(Punto punto1, Punto punto2){
        this.punto1 = new Punto(punto1.getX(), punto1.getY());
        this.punto2 = new Punto(punto2.getX(), punto2.getY());
    }*/

    //metodo uguale al precedente, però invoca il costruttoe di copia locale
    public Segmento(Punto punto1, Punto punto2){
        //se dereferenzio il parametro perdo il contenuto, io lo ricreo così non ho problemi quando cambio parametro
        this.punto1 = new Punto(punto1);
        this.punto2 = new Punto(punto2);
    }

    public Segmento(Segmento segmento){
        this.punto1 = new Punto(segmento.getPunto1());
        this.punto2 = new Punto(segmento.getPunto2());
    }

    public void setPunto1(Punto punto1) {
        this.punto1 = punto1;
    }

    public Punto getPunto1() {
        return this.punto1;
    }

    public void setPunto2(Punto punto2) {
        this.punto2 = punto2;
        // chiami due cose diverse--> this.punto2 =new Punto(punto2.getX(), punto2.getY());
    }

    public Punto getPunto2() {
        return punto2;
    }

    public boolean equals(Segmento segmento){
        boolean equals=false;
        if((punto1.equals(segmento.getPunto1())) && (punto2.equals(segmento.getPunto2()))){
            equals = true;
        }
        return equals;
    }
}
