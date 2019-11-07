package it.itis.cuneo;

public class Rettangolo {
    //attributi
    private Segmento lato1;
    private Segmento lato2;
    private Segmento lato3;
    private Segmento lato4;

    //costruttore
    public Rettangolo(){

    }

    public Rettangolo(Segmento lato1, Segmento lato2, Segmento lato3, Segmento lato4){
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;
        this.lato4 = lato4;
        }

    public void setLato1(Segmento lato1) {
        this.lato1 = lato1;
        }

    public Segmento getLato1() {
        return this.lato1;
        }

    public void setLato2(Segmento lato2) {
        this.lato2 = lato2;
        }

    public Segmento getLato2() {
        return this.lato2;
        }

    public void setLato3(Segmento lato3) {
        this.lato3 = lato3;
        }

    public Segmento getLato3() {
        return this.lato3;
        }

    public void setLato4(Segmento lato4) {
        this.lato4 = lato4;
        }

    public Segmento getLato4() {
        return this.lato4;
        }

    public double area(){
        double area;
        area = lato1.lunghezza() * lato2.lunghezza();
        return area;
        }

    public boolean interseca(Rettangolo rettangolo){
        boolean interseca=false;

        Punto a1,a2,b1,b2;

        a1=lato1.getUno();
        a2=lato2.getDue();
        b1=rettangolo.lato1.getUno();
        b2=rettangolo.lato2.getDue();

        if((((a1.getX()<=b1.getX() && b1.getX()<=a2.getX()) || (a1.getX()<=b2.getX() && b2.getX()<=a2.getX())) && (((a1.getY()<=b1.getY() && b1.getY()<=a2.getY()) || (a1.getY()<=b2.getY() && (b2.getY()<=a2.getY())))))){

            interseca = true;
        }
        return interseca;
    }

    public int pianoCartesiano(){

    }


    public void sposta(Punto a, Punto b, Punto c, Punto d, int n){
        a.setX(a.getX()+n);
        a.setY(a.getY()+n);
        b.setX(b.getX()+n);
        b.setY(b.getY()+n);

        c.setX(c.getX()+n);
        c.setY(c.getY()+n);
        d.setX(d.getX()+n);
        d.setY(d.getY()+n);
    }


    public static void main(String[] args) {
        Punto a = new Punto(1,1);
        Punto b = new Punto(6,1);
        Punto c = new Punto(6,4);
        Punto d = new Punto(1,4);
        Punto a1 = new Punto(7,2);
        Punto b1 = new Punto(10,2);
        Punto c1 = new Punto(10,7);
        Punto d1 = new Punto(7,7);

        Segmento as = new Segmento(a,b);
        Segmento bs = new Segmento(b,c);
        Segmento cs = new Segmento(c,d);
        Segmento ds = new Segmento(d,a);
        Segmento as1 = new Segmento(a1,b1);
        Segmento bs1 = new Segmento(b1,c1);
        Segmento cs1 = new Segmento(c1,d1);
        Segmento ds1 = new Segmento(d1,a1);

        Rettangolo ret1 = new Rettangolo(as,bs,cs,ds);
        Rettangolo ret2 = new Rettangolo(as1,bs1,cs1,ds1);

        double area = ret1.area();
        System.out.println("Area: "+area);

        System.out.println("I due rettangoli si intersecano? " +ret1.interseca(ret2));
        

        ret1.sposta(a,b,c,d,5);
        System.out.println("A: "+a.getX()+ "," + a.getY());
        System.out.println("B: "+b.getX() + "," + b.getY());
        System.out.println("C: "+c.getX() + "," + c.getY());
        System.out.println("D: "+d.getX() + "," + d.getY());

        }
}