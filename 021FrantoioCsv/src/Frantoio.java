import java.util.ArrayList;
import java.util.List;

/**
 * Created by d.claudio.borgogno on 23/11/2019.
 */
public class Frantoio {

    //List<E> è un interfaccia di ArrayList<E>
    //ArrayList<E> implementa List<E>
    private List<Oliva> listaOlive;
    private FrantorioCsv frantorioCsv;

    public Frantoio() {
        super();
        // inizializzare per avere un riferimento
        frantorioCsv = new FrantorioCsv();
        this.listaOlive = new ArrayList<Oliva>();
    }
    public Frantoio(List<Oliva> listaOlive) {
        new Frantoio();
        this.listaOlive = listaOlive;

    }

    public List<Oliva> getListaOlive() {
        return listaOlive;
    }
    public void setListaOlive(List<Oliva> listaOlive) {
        this.listaOlive = listaOlive;
    }
    public FrantorioCsv getFrantorioCsv() {
        return frantorioCsv;
    }
    public void setFrantorioCsv(FrantorioCsv frantorioCsv) {
        this.frantorioCsv = frantorioCsv;
    }

    @Override
    public String toString() {
        return "Frantoio{" +
                "listaOlive=" + listaOlive +    // stampa di un ArrayList, stampa in automatico
                '}';
    }

    // carica un ArrayList di olive
    public void simula() {
        listaOlive.add(new Oliva("o1",
                ColoreOliva.MARRONE,
                MaturazioneOliva.MARCITURA,
                InputOutputUtility.convertiDataOraToCalendar("11/08/19 15:45:00", InputOutputUtility.dfDayHour)));

        listaOlive.add(new Oliva("o2",
                ColoreOliva.VERDE,
                MaturazioneOliva.MATURA,
                InputOutputUtility.convertiDataOraToCalendar("12/08/2019 14:25:00", InputOutputUtility.dfDayHour)));

        listaOlive.add(new Oliva("o3",
                ColoreOliva.NERO,
                MaturazioneOliva.PICCOLA,
                InputOutputUtility.convertiDataOraToCalendar("01/09/2019 11:30:00", InputOutputUtility.dfDayHour)));
    }


    public static void main(String[] args) {
        Frantoio frantoio = new Frantoio();

        frantoio.simula();

        // List --> più generico rispetto ad ArrayList
        //frantoio.getFrantorioCsv().scriveFile(frantoio.getListaOlive());


        List<Oliva> lOliva = frantoio.getFrantorioCsv().leggiFile();
        frantoio.setListaOlive(lOliva);

        System.out.println(frantoio.toString());


    }
}
