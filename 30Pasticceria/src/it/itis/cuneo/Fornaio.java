package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 21/12/2019.
 */
public class Fornaio implements Pasticcere, RivenditaAlimentari {

    private boolean isFornoAcceso;

    @Override
    public void accendiForno() {
        //ereditarietà singola, infinite intefaccie da implementare
        isFornoAcceso = true;

    }

    @Override
    public void riempiMagazzino() {

    }
}
