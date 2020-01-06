package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 21/12/2019.
 */
public class Supermercato implements RivenditaAlimentari, Pasticcere {
    private int gradiFornoEletrico;

    @Override
    public void accendiForno() {
        gradiFornoEletrico = 180;
    }

    @Override
    public void riempiMagazzino() {

    }
}
