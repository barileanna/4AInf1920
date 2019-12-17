package it.itis.cuneo;

public class Mensola {
    private static final int MAX_NUM_VOLUMI=15;
    private Libro volumi[];

    public Mensola() {
        volumi = new Libro[MAX_NUM_VOLUMI];
    }

    public Mensola(Mensola mensola) {
        int posizione;
        volumi = new Libro[MAX_NUM_VOLUMI];
        for(posizione=0; posizione<MAX_NUM_VOLUMI;posizione++){
            if(mensola.getVolume(posizione)!=null){
                volumi[posizione]=new Libro(mensola.getVolume(posizione));
            }
        }
    }

    public int setVolume(Libro libro, int posizione) {
        try {
            if (volumi[posizione]!=null){
                return -2;
            }
            volumi[posizione] = new Libro(libro);
            return posizione;
        }catch (ArrayIndexOutOfBoundsException exception){
            return -1;
        }
    }

    public Libro getVolume(int posizione) {
        try{
            return new Libro(volumi[posizione]);
        }catch (ArrayIndexOutOfBoundsException exception){
            return null;
        }
        catch (NullPointerException exception){
            return null;
        }
    }

    public static int getMaxNumVolumi() {
        return MAX_NUM_VOLUMI;
    }

    public int getNumVolumi() {
        int posizione, n=0;
        for(posizione=0;posizione<MAX_NUM_VOLUMI;posizione++){
            if(volumi[posizione]!=null){
                n++;
            }
        }
        return n;
    }

    public void salvaVolumi() throws java.io.IOException {
        TextFile out = new TextFile("volumi.txt", 'W');

        try{
            for(int posizione=0;posizione<MAX_NUM_VOLUMI; posizione++){
                if(volumi[posizione]!=null)  {
                    String line = Integer.toString(posizione);
                    line += ";"+volumi[posizione].getTitolo();
                    line += ";"+volumi[posizione].getAutore();
                    line += ";"+volumi[posizione].getNumeroPagine();
                    out.toFile(line);
                }
            }
        }catch (FileException exception){

        }
        out.closeFile();
    }

    public void caricaVolumi() throws java.io.IOException {
        TextFile in = new TextFile("volumi.txt",'R');
        int posizione, pagine;
        String linea, autore, titolo;
        String[] elementi;
        Libro libro;

        try{
            while(true) {
                linea = in.fromFile();
                elementi = linea.split(";");
                if(elementi.length == 4){
                    posizione = Integer.parseInt(elementi[0]);
                    titolo = elementi[1];
                    autore = elementi[2];
                    pagine = Integer.parseInt(elementi[3]);
                    libro = new Libro(titolo, autore, pagine);
                    setVolume(libro, posizione);
                }
            }
        }catch (FileException exception){

        }
    }

    public static void main(String[] args) throws java.io.IOException {
        Mensola mensola = new Mensola();

        Libro libro1 = new Libro("Pinocchio", "C.Collodi", 150);
        Libro libro2 = new Libro("Pollicino", "C.Perrault", 80);
        Libro libro3 = new Libro("La bella addormantata nel bosco", "C.Perrault", 50);
        System.out.println("Numero volumi: "+mensola.getNumVolumi());

        mensola.setVolume(libro1,0);
        mensola.setVolume(libro2,2);
        mensola.setVolume(libro3,9);
        System.out.println("Numero volumi: " +mensola.getNumVolumi());

        mensola.salvaVolumi();
        //creazione nuova mensola vuota
        mensola = new Mensola();
        System.out.println("Numero volumi: "+mensola.getNumVolumi());

        mensola.caricaVolumi();
        System.out.println("Numero volumi: "+mensola.getNumVolumi());
    }
}
