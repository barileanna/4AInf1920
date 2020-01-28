package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 20/11/2019.
 */
public class Abitazione {

    private int nStanze;
    private double superficie;
    private String indirizzo;
    private String citta;
    private int tipo;

    public Abitazione() {
    }

    public Abitazione(int nStanze, double superficie, String indirizzo, String citta) {
        this.nStanze = nStanze;
        this.superficie = superficie;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public Abitazione(Abitazione abitazione){
        this.nStanze = abitazione.getnStanze();
        this.superficie = abitazione.getSuperficie();
        this.indirizzo = abitazione.getIndirizzo();
        this.citta = abitazione.getCitta();
    }

    public int getnStanze() {
        return nStanze;
    }

    public void setnStanze(int nStanze) {
        this.nStanze = nStanze;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public static void caricaAbitazione(Abitazione elencoAbitazioni[], int indice, InputOutputUtility t){
        int tipoAbitazione;
        do{
            System.out.println("Tipo di abitazione (0:villa / 1:appartamento): ");
            tipoAbitazione = t.leggiNumero();
        }while (tipoAbitazione<0 || tipoAbitazione>1);
        if(tipoAbitazione==0){
            elencoAbitazioni[indice] = new Villa();
            System.out.println("Numero piani: ");
            ((Villa)elencoAbitazioni[indice]).setnPiani(t.leggiNumero());
            System.out.println("Piscina: ");
            ((Villa)elencoAbitazioni[indice]).setPiscina(t.leggiBoolean());
            System.out.println("Superficie giardino: ");
            ((Villa)elencoAbitazioni[indice]).setSuperficieGiardino(t.leggiNumeroFloat());
        }else{
            elencoAbitazioni[indice] = new Appartamento();
            System.out.println("Piano: ");
            ((Appartamento)elencoAbitazioni[indice]).setPiano(t.leggiNumero());
            System.out.println("Numero balcono: ");
            ((Appartamento)elencoAbitazioni[indice]).setnBalconi(t.leggiNumero());
            System.out.println("Ascensore: ");
            ((Appartamento)elencoAbitazioni[indice]).setAscensore(t.leggiBoolean());
        }
        elencoAbitazioni[indice].setTipo(tipoAbitazione);
        System.out.println("Numero di stanze: ");
        elencoAbitazioni[indice].setnStanze(t.leggiNumero());
        System.out.println("Superficie: ");
        elencoAbitazioni[indice].setSuperficie(t.leggiNumeroFloat());
        System.out.println("Indirizzo: ");
        elencoAbitazioni[indice].setIndirizzo(t.leggiNome());
        System.out.println("Città: ");
        elencoAbitazioni[indice].setCitta(t.leggiNome());

    }

    @Override
    public String toString() {
        return "nStanze=" + nStanze +
                ", superficie=" + superficie +
                ", indirizzo='" +  + '\'' +
                ", citta='" + citta + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abitazione that = (Abitazione) o;

        if (nStanze != that.nStanze) return false;
        if (Double.compare(that.superficie, superficie) != 0) return false;
        if (indirizzo != null ? !indirizzo.equals(that.indirizzo) : that.indirizzo != null) return false;
        return citta != null ? citta.equals(that.citta) : that.citta == null;
    }
}
