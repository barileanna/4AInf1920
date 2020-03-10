package it.itis.cuneo;

public class Main {
    public static void main(String[] args) {

        //richiesta input e input della stringa
        System.out.println("Inserire una stringa: ");
        String string = InputOutputUtility.leggiNome();
        //creazione thread(con la stringa inserita)
        Stringa stringa = new Stringa(string);
        stringa.start();
        try {
            stringa.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
