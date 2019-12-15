import javafx.scene.chart.ScatterChart;

public class Campana implements Runnable{
    public String suono;
    public int volte;

    public Campana() {
    }

    public Campana(String suono, int volte) {
        this.suono = suono;
        this.volte = volte;
    }

    public String getSuono() {
        return suono;
    }

    public void setSuono(String suono) {
        this.suono = suono;
    }

    public int getVolte() {
        return volte;
    }

    public void setVolte(int volte) {
        this.volte = volte;
    }

    @Override
    public void run() {
        try {
            for(int conta=0;conta<volte;conta++) {
                System.out.print(suono + " ");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
