package it.itis.cuneo;
/**
 * Created by inf.barilea1810 on 07/10/2019.
 */
public class Rettangolo {
    //attributi
    private Segmento segmentoAlto;
    private Segmento segmentoDestro;
    private Segmento segmentoBasso;
    private Segmento segmentoSinistro;
f
    public Rettangolo(){

    }

    public Rettangolo(Segmento segmentoAlto, Segmento segmentoDestro, Segmento segmentoBasso, Segmento segmentoSinistro){
        this.segmentoAlto = new Segmento(segmentoAlto);
        this.segmentoDestro = new Segmento(segmentoDestro);
        this.segmentoBasso = new Segmento(segmentoBasso);
        this.segmentoSinistro = new Segmento(segmentoSinistro);
    }

    //chiamo un costruttore di copia
    public Rettangolo(Rettangolo rettangolo){
        this.segmentoAlto = new Segmento(rettangolo.getSegmentoAlto());
        this.segmentoDestro =new Segmento(rettangolo.getSegmentoDestro());
        this.segmentoBasso = new Segmento(rettangolo.getSegmentoBasso());
        this.segmentoSinistro =new Segmento (rettangolo.getSegmentoSinistro());
    }


    public void setSegmentoAlto(Segmento segmentoAlto){
        this.segmentoAlto = segmentoAlto;
    }

    public Segmento getSegmentoAlto() {
        return segmentoAlto;
    }

    public void setSegmentoDestro(Segmento segmentoDestro) {
        this.segmentoDestro = segmentoDestro;
    }

    public Segmento getSegmentoDestro() {
        return segmentoAlto;
    }

    public void setSegmentoBasso(Segmento segmentoBasso) {
        this.segmentoBasso = segmentoBasso;
    }

    public Segmento getSegmentoBasso() {
        return segmentoAlto;
    }

    public void setSegmentoSinistro(Segmento segmentoSinistro) {
        this.segmentoSinistro = segmentoSinistro;
    }

    public Segmento getSegmentoSinistro() {
        return segmentoAlto;
    }

    public String toString(){
        return ("Segmento {\"segmento alto:\" "+this.segmentoAlto+ ","+"\"segmento basso:\"" +this.segmentoBasso+ ","+"\"segmento destro:\"" +this.segmentoDestro+","+"\"segmento sinistro:\"" +this.segmentoSinistro+"}");
    }

    public boolean equals(Rettangolo rettangolo){
        boolean equals=false;
        if(this.getSegmentoAlto().equals(rettangolo.getSegmentoAlto()) && this.getSegmentoBasso().equals(rettangolo.getSegmentoBasso()) && this.getSegmentoDestro().equals(rettangolo.getSegmentoDestro()) && this.getSegmentoSinistro().equals(rettangolo.getSegmentoSinistro())){
            equals=true;
        }
        return equals;
    }

    public static void main(String[] args) {
        Punto uno;
    }

}
