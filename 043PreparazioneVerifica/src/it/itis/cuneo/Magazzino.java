package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by inf.barilea1810 on 05/02/2020.
 */
@XmlRootElement
public class Magazzino {

    public static final String FILE_XML ="D:\\4AINF\\informatica\\intellij\\Esercizi\\043PreparazioneVerifica\\src\\prodotti.xml";
    public static final String FILE_XMLM = "D:\\4AINF\\informatica\\intellij\\Esercizi\\043PreparazioneVerifica\\src\\prodotti2.xml";
    public static final String FILE_CSV = "D:\\4AINF\\informatica\\intellij\\Esercizi\\043PreparazioneVerifica\\src\\prodotti2.csv";
    public static final String SEPARATOR = ",";

    public static final String NOME_CLASSE = "Magazzino";

    private String name;
    private List<Prodotto> lProdotto;

    public Magazzino() {
        super();
        lProdotto = new ArrayList<Prodotto>();
    }

    public Magazzino(String name) {
        this.name = name;
        lProdotto = new ArrayList<Prodotto>();
    }

    public Magazzino(String name, List<Prodotto> lProdotto) {
        this.name = name;
        this.lProdotto = lProdotto;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public List<Prodotto> getlProdotto() {
        return lProdotto;
    }

    @XmlElement (name = "prodotto")
    public void setlProdotto(List<Prodotto> lProdotto) {
        this.lProdotto = lProdotto;
    }

    public void aggiungiProdotto(Prodotto prodotto){
        lProdotto.add(prodotto);
    }

    @Override
    public String toString() {
        return "Magazzino{" +
                "name='" + name + '\'' +
                ", lProdotto=" + lProdotto +
                '}';
    }

    public void unMarshalXml(){
        Magazzino magazzino = null;
        try{
            File file = new File(FILE_XML);

            JAXBContext jaxbContext = JAXBContext.newInstance(Magazzino.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //= this = (Magazzino) jaxbUnmarshaller.unmarshal(file)
            //bisognerebbe caricare il this, non servirebe return e salvaCsv
             magazzino = (Magazzino) jaxbUnmarshaller.unmarshal(file);

             this.name = magazzino.name;
             this.lProdotto = magazzino.lProdotto;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void marshallXml(){
        try{
            File file = new File(FILE_XMLM);

            JAXBContext jaxbContext = JAXBContext.newInstance(Magazzino.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this,file);
            jaxbMarshaller.marshal(this,System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void scriviCsv(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FILE_CSV));
            bw.write(this.toRowCsv());
            //for(Prodotto prodotto : magazzino.getlProdotto()){
            for(Prodotto prodotto : this.getlProdotto()){
                bw.write(prodotto.toRowCsv());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void apriCsv(){
        BufferedReader br = null;
        String rowLine;
        Prodotto prodotto = null;
        try {
            br = new BufferedReader(new FileReader(FILE_CSV));
            while((rowLine = br.readLine()) != null){
                String[] campi = rowLine.split(Magazzino.SEPARATOR);
                if(campi[0].equalsIgnoreCase("magazzino")){
                    this.setName(campi[1]);
                }else{
                    prodotto = new Prodotto(campi[1], campi[2]);
                    this.aggiungiProdotto(prodotto);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toRowCsv(){
        return NOME_CLASSE + Magazzino.SEPARATOR + name + "\n";
    }

    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino();

        magazzino.unMarshalXml();

        System.out.println("\n\n\n\n" + magazzino.toString()+"\n\n\n\n");

        magazzino.scriviCsv();

        Magazzino magazzino1 = new Magazzino();

        magazzino1.apriCsv();
        System.out.println(magazzino1.toString());


    }
}
