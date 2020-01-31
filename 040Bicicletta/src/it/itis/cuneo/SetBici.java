package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@XmlRootElement (name ="biciclette")
public class SetBici {

    public static final String FILE_PATH = "C:\\Users\\Anna\\Desktop\\040Bicicletta\\src\\bicicletta.xml";

    private List<Bicicletta> bici;

    public SetBici() {
        super();
        bici = new ArrayList<Bicicletta>();
    }


    public SetBici(List<Bicicletta> bici) {
        this.bici = bici;
    }

    public void addBici(Bicicletta bicicletta1){
        bici.add(bicicletta1);
    }

    public List<Bicicletta> getBici() {
        return bici;
    }

    @XmlElement (name = "bicilette")
    public void setBici(List<Bicicletta> bici) {
        this.bici = bici;
    }

    public void marshallingXml(){

        try {
            File file = new File (SetBici.FILE_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(SetBici.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void unmarshalXml() {
        try {

            File file = new File(FILE_PATH);
            //misuro le dimensioni e il tipo della classe
            //scheletro della classe per estrapolare le annotation
            JAXBContext jaxbContext = JAXBContext.newInstance(SetBici.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            //converto il padre nel figlio, metto il cast
            SetBici bici = (SetBici) jaxbUnmarshaller.unmarshal(file);
            System.out.println(bici.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void simula() {
        Bicicletta bicicletta1 = new Bicicletta("Atala", "shimano", "campagnolo","ruota1", "ruota2");
        this.addBici(bicicletta1);
        Bicicletta bicicletta2 = new Bicicletta("tel2", "fre2", "cam2","ruota3","ruota4");
        this.addBici(bicicletta2);
    }

    public static void main(String[] args) {
        SetBici bicicletta = new SetBici();

        bicicletta.simula();
        //bicicletta.marshallingXml();
        bicicletta.unmarshalXml();
    }

    @Override
    public String toString() {
        return "SetBici{" +
                "bici=" + bici +
                '}';
    }
}
