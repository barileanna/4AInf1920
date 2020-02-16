package it.itis.cuneo;

import java.util.Calendar;

/**
 * Created by inf.barilea1810 on 05/02/2020.
 */
public abstract class Deperibile {

    private Calendar dataScadenza;

    //differenza con la data attuale
    public abstract int quantiGiorniAllaScadenza();
}
