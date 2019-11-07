import static java.lang.System.out;

public class Frazione {

    //Attributi
    private int num;
    private int den;

    //Metodi
    //costruttori
    public Frazione(){

    }

    public Frazione(int num, int den){
        this.num = num;
        this.den = den;
    }

    public void setNum(int num){
        this.num = num;
    }

    public int getNum(){
        return this.num;
    }

    public void setDen(int den){
        this.den = den;
    }

    public int getDen(){
        return this.den;
    }

    public Frazione getSomma(Frazione frazione){
        Frazione frazioneRes = new Frazione(((this.num*frazione.getDen())+(this.den*frazione.getNum())),(this.den*frazione.getDen()));
        return frazioneRes;
    }

    public Frazione getMoltiplicazione(Frazione frazione){
        Frazione frazioneRes = new Frazione((this.num*frazione.getNum()),(this.den*frazione.getDen()));
        return frazioneRes;
    }

    public Frazione getDivisione(Frazione frazione){
        Frazione frazioneRes = new Frazione((this.num*frazione.getDen()),(this.den*frazione.getNum()));
        return frazioneRes;
    }

    public Frazione getSottrazione(Frazione frazione){
        Frazione frazioneRes = new Frazione(((this.num*frazione.getDen())-(this.den*frazione.getNum())),(this.den*frazione.getDen()));
        return frazioneRes;
    }

    public Frazione getReciproco(){
        Frazione frazioneRes = new Frazione(this.den, this.num);
        return frazioneRes;
    }

    public String toString(){
        return "Frazione { numeratore: " + num + ", denominatore: " + den + "}";
    }

    public static void main(String args[]){
        Frazione frazione1 = new Frazione(3,7);
        Frazione frazione2 = new Frazione(5,7);
        Frazione res = new Frazione();

        res= frazione2.getSomma(frazione1);
        System.out.println("Somma:");
        System.out.println( res.toString());

        res = frazione2.getMoltiplicazione(frazione1);
        System.out.println("Moltiplicazione:");
        System.out.println( res.toString());

        res = frazione2.getDivisione(frazione1);
        System.out.println("Divisione:");
        System.out.println( res.toString());


        res = frazione2.getSottrazione(frazione1);
        System.out.println("Sottrazione:");
        System.out.println( res.toString());


        res = frazione1.getReciproco();
        System.out.println("Reciproco:");
        System.out.println( res.toString());

    }

}
