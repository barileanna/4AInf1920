package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 20/11/2019.
 */
public class Appartamento extends Abitazione {
    private int piano;
    private boolean ascensore;
    private int nBalconi;

    public Appartamento(){
        super();
    }

    public Appartamento(int piano, boolean ascensore, int nBalconi) {
        this.piano = piano;
        this.ascensore = ascensore;
        this.nBalconi = nBalconi;
    }

    public Appartamento(int nStanze, double superficie, String indirizzo, String citta, int piano, boolean ascensore, int nBalconi) {
        super(nStanze, superficie, indirizzo, citta);
        this.piano = piano;
        this.ascensore = ascensore;
        this.nBalconi = nBalconi;
    }

    public Appartamento(Abitazione abitazione, int piano, boolean ascensore, int nBalconi) {
        super(abitazione);
        this.piano = piano;
        this.ascensore = ascensore;
        this.nBalconi = nBalconi;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public boolean isAscensore() {
        return ascensore;
    }

    public void setAscensore(boolean ascensore) {
        this.ascensore = ascensore;
    }

    public int getnBalconi() {
        return nBalconi;
    }

    public void setnBalconi(int nBalconi) {
        this.nBalconi = nBalconi;
    }

    @Override
    public String toString() {
        return "Appartamento{ " + super.toString()+
                "piano=" + piano +
                ", ascensore=" + ascensore +
                ", nBalconi=" + nBalconi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean ret = true;

        if (o == null || getClass() != o.getClass())
            ret = false;
        if (!super.equals(o))
            ret = false;

        Appartamento appartamento = (Appartamento) o;

        if(ret == true) {
            if (piano != appartamento.piano)
                ret = false;
            if (nBalconi != appartamento.nBalconi)
                ret = false;
            ret = appartamento.isAscensore();
        }
        return ret;
    }
}
