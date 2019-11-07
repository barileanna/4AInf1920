package it.itis.cuneo;

public class Punto {
    //attributi
    private int x;
    private int y;

    //metodi
    //costruttore
    public Punto(){}

    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Punto(Punto p){
        x = p.getX();
        y = p.getY();
    }


    public void setX(int x){
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Punto punto) {
        boolean equals=false;
        if(x == punto.getX() && y==punto.getY()) {
            equals =true;
        }
        return equals;
    }
}
