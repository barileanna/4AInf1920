package it.itis.cuneo;

import javax.annotation.processing.FilerException;
import java.io.*;

/**
 * Created by inf.barilea1810 on 16/12/2019.
 */
public class TextFile {
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;

    public TextFile(String filename, char mode) throws IOException{
        this.mode = 'R';
        if (mode == 'W' || mode == 'w'){
            this.mode = 'W';
            writer = new BufferedWriter(new FileWriter(filename));
        }else {
            reader = new BufferedReader(new FileReader(filename));
        }
    }

    /*scrivere in un file aperto in scrittura*/
    public void toFile(String line)throws FileException, IOException{
        if(this.mode == 'R')
            throw new FileException(("Read-only"+"file!"));
        writer.write(line);
        writer.newLine();
    }

    /*legge una riga da file aperto in lettura*/
    public String fromFile() throws FileException, IOException{
        String tmp;

        if(this.mode == 'W')
            throw new FileException("Write-only"+"file!");
        tmp = reader.readLine();
        if(tmp == null)
            throw new FileException("End of file!");
        return tmp;
    }

    /*chiudi il file aperto*/
    public void closeFile() throws IOException{
        if(this.mode == 'W')
            writer.close();
        else
            reader.close();
    }

    /*public static void main(String args[]) throws IOException{
        TextFile out = new TextFile("file.txt",'W');
        try{
            out.toFile("Riga 1");
            out.toFile("Riga 2");
            out.toFile("Riga 3");
        }catch (FileException exception){
            System.out.println(exception.getMatter());
        }
        out.closeFile();

        TextFile in = new TextFile("file.txt", 'R');
        String line;
        try {
            while(true){
                line = in.fromFile();
                System.out.println(line);
            }
        }catch (FileException exception){
            System.out.println(exception.getMatter());
        }
        out.closeFile();
    }*/
}
