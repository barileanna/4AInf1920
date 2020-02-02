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

@XmlRootElement (name = "hotel")
public class Hotel {
    public static final String FILE_XML = "C:\\Users\\Anna\\Desktop\\041CameraHotel\\src\\hotel.xml";
    public static final String FILE_CSV = "C:\\Users\\Anna\\Desktop\\041CameraHotel\\src\\hotel.csv";
    public static final String SEPARATOR = ",";

    private String nome;
    private List<Camera> lCamera;

    public Hotel() {
        super();
        lCamera = new ArrayList<Camera>();
    }

    public Hotel(String nome) {
        this.nome = nome;
        lCamera = new ArrayList<Camera>();
    }

    public Hotel(String nome, List<Camera> lCamera) {
        this.nome = nome;
        this.lCamera = lCamera;
    }

    public List<Camera> getlCamera() {
        return lCamera;
    }

    @XmlElement (name = "camera")
    public void setlCamera(List<Camera> lCamera) {
        this.lCamera = lCamera;
    }

    public String getNome() {
        return nome;
    }

    @XmlAttribute (name = "nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void aggCamera(Camera camera){
        this.lCamera.add(camera);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                 lCamera +
                '}';
    }

    public void salvaCSV() {
        String str = "";
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(FILE_CSV));

            for(int cntCamera = 0; cntCamera<this.lCamera.size(); cntCamera++){
                Camera camera = this.lCamera.get(cntCamera);
                bw.write(camera.toRowCsv());
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void apriCSV() {
        BufferedReader br;
        String rowLine;
        Camera camera = null;

        try{
            br = new BufferedReader(new FileReader(FILE_CSV));
            while((rowLine = br.readLine()) != null){
                String[] campi = rowLine.split(Hotel.SEPARATOR);
                camera = new Camera(campi[1], campi[2], campi[3], campi[4]);
                aggCamera(camera);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void marshalXml() {
        try{
            File file = new File(FILE_XML);

            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void unmarshalXml() {
        try{
            File file = new File(FILE_XML);
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Hotel hotel = (Hotel) jaxbUnmarshaller.unmarshal(file);
            System.out.println(hotel.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        Camera camera1 = new Camera("13S","2","si","mare");
        Camera camera2 = new Camera("13B","3","no","città");
        Camera camera3 = new Camera("13A","4","si","mare");


        this.aggCamera(camera1);
        this.aggCamera(camera2);
        this.aggCamera(camera3);
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel("alto");

        //hotel.simulate();
        //hotel.salvaCSV();
        //hotel.marshalXml();
        System.out.println("LEGGI CSV: ");
        Hotel hotelCsv = new Hotel();
        hotelCsv.apriCSV();
        System.out.println(hotelCsv.toString());

        System.out.println("LEGGI XML: ");
        hotel.unmarshalXml();
    }


}
