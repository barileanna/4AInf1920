package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 17/10/2019.
 */
public class CasaEditrice {
    private String regioneSociale;
    private String luogo;
    private int anno;

    public CasaEditrice(){}

    public CasaEditrice(String regioneSociale, String luogo, int anno){
        this.regioneSociale = new String(regioneSociale);
        this.luogo = new String(luogo);
        this.anno = anno;
    }

    public CasaEditrice(CasaEditrice casaEditrice){
        this.regioneSociale = new String(regioneSociale);
        this.luogo = new String(luogo);
        this.anno = anno;
    }
}
