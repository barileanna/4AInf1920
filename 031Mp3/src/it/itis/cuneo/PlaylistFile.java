package it.itis.cuneo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PlaylistFile {

    public static final String FILE_PATH="C:\\Users\\Anna\\Desktop\\";
    public static final String FILE_NAME="playlist.txt";
    public static final String SEPARATOR=" ";

    private String linea;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public List<Brano> leggiFile(){
        ArrayList<Brano> lBrani = new ArrayList<Brano>();

        try {
            //OpenFile
            //Buffer: area di MC, che contiene una piccola porzione del grande file
            bufferedReader = new BufferedReader(
                    new FileReader(
                            new File(
                                    PlaylistFile.FILE_PATH + PlaylistFile.FILE_NAME)));

            //bufferedReader.readLine() se null -> sono arrivato a eof
            while( (linea=bufferedReader.readLine())!=null ){
                Brano brano = new Brano();
                brano.carica(linea);
                lBrani.add(brano);
            }


        } catch (FileNotFoundException e) {
            //Rilanciata in fase di apertura se non trova il nome file
            e.printStackTrace();
        } catch (IOException e) {
            //Rilanciata in fase di lettura, se il file è bloccato
            e.printStackTrace();
        } finally {
            //CloseFile
            if(bufferedReader!=null){
                //FileReader e File vengono distrutti dal garbage collector
                // perchè dipendenze da bufferedReader
                bufferedReader=null;
            }
        }

        return lBrani;
    }

    public int scriveFile(List<Brano> aBrani){

        try {
            bufferedWriter = new BufferedWriter(
                    new FileWriter(
                            new File(
                                    PlaylistFile.FILE_PATH + PlaylistFile.FILE_NAME
                            )
                    )
            );
            for(Brano brano: aBrani){
                linea = brano.riga();
                bufferedWriter.write(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
