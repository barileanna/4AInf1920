public class Programma {
    private String denominazione;
    private String produttore;
    private float versione;
    private String os;
    private int anno;

    public Programma(String denominazione, String produttore, float versione, String os, int anno) {
        this.denominazione = denominazione;
        this.produttore = produttore;
        this.versione = versione;
        this.os = os;
        this.anno = anno;
    }
    public Programma() {
        super();
    }
    public Programma(Programma programma) {
        this.denominazione = programma.denominazione;
        this.produttore = programma.produttore;
        this.versione = programma.versione;
        this.os = programma.os;
        this.anno = programma.anno;
    }

    public String getDenominazione() {
        return denominazione;
    }
    public String getProduttore() {
        return produttore;
    }
    public float getVersione() {
        return versione;
    }
    public String getOs() {
        return os;
    }
    public int getAnno() {
        return anno;
    }
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }
    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }
    public void setVersione(float versione) {
        this.versione = versione;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String toString(String denominazione, String produttore, float versione, String os, int anno) {
        return "{denominazione:" + this.denominazione + ", produttore:" + this.produttore + ", versione:" + this.versione + ", sistema operativo:" + this.os + ", anno:" + this.anno + "}";
    }

    public boolean compareAnno(Programma programma) {
        boolean equal = false;
        if (this.anno == programma.anno) {
            equal = true;
        }
        return equal;
    }
}
