package it.itis.cuneo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Playlist {
    public static final String FILE_PATH = "C:\\Users\\Anna\\Desktop\\038PlaylistXml\\src\\it\\itis\\cuneo\\playlist3.xml";
    private List<Brano> playlist;

    public Playlist(){
        super();
        playlist = new ArrayList<Brano>();
    }

    public void addBrano(Brano brano){
        playlist.add(brano);
    }

    public List<Brano> getPlaylist() {
        return playlist;
    }

    @XmlElement
    public void setPlaylist(List<Brano> playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlist=" + playlist +
                '}';
    }

    public String toXml() {
        String xml = "";
        for(Brano brano : this.playlist) {
            xml += brano.toXml();
        }
        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+"\n"+"<playlist>\n"
                + xml + "</playlist>";
        return xml;
    }

    public void scriviXml(){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(FILE_PATH));
            bw.write(this.toXml());
            System.out.println(this.toXml());
            bw.flush();
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void marshallingXml(){
        try{
            File file = new File(Playlist.FILE_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Playlist.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private void simula() {
        Brano brano1 = new Brano(1,"Wonderwall", 198, "Oasis");
        this.addBrano(brano1);
        Brano brano2 = new Brano(2, "Willin'", 219, "Mandy Moore");
        this.addBrano(brano2);
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.simula();
        //playlist.scriviXml();
        //Metodo di scrittura basato su jaxb
        playlist.marshallingXml();
    }
}
