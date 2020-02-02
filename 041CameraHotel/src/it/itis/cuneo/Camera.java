package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"postiLetto", "bagno", "vista"})
public class Camera {

    private String nome;
    private String postiLetto;
    private String bagno;
    private String vista;

    public Camera() {
        super();
    }

    public Camera(String nome, String postiLetto, String bagno, String vista) {
        this.nome = nome;
        this.postiLetto = postiLetto;
        this.bagno = bagno;
        this.vista = vista;
    }

    public String getNome() {
        return nome;
    }

    @XmlAttribute (name = "nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostiLetto() {
        return postiLetto;
    }

    @XmlElement (name = "letto")
    public void setPostiLetto(String postiLetto) {
        this.postiLetto = postiLetto;
    }

    public String getBagno() {
        return bagno;
    }

    @XmlElement
    public void setBagno(String bagno) {
        this.bagno = bagno;
    }

    public String getVista() {
        return vista;
    }

    @XmlElement
    public void setVista(String vista) {
        this.vista = vista;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "nome='" + nome + '\'' +
                ", letto='" + postiLetto + '\'' +
                ", bagno='" + bagno + '\'' +
                ", vista='" + vista + '\'' +
                '}';
    }

    public String toRowCsv() {
        return "Camera" + Hotel.SEPARATOR + nome + Hotel.SEPARATOR +
                postiLetto + Hotel.SEPARATOR + bagno + Hotel.SEPARATOR +
                vista + "\n";
    }

    public Camera caricaCamera() {
        Camera camera = new Camera();
        camera.setNome(InputOutputUtility.leggiNome("Nome camera: "));
        camera.setPostiLetto(InputOutputUtility.leggiNome("Posti letto: "));
        camera.setBagno(InputOutputUtility.leggiNome("Bagno (si/no): "));
        camera.setVista(InputOutputUtility.leggiNome("Vista (mare/montagna...): "));
        return camera;
    }
}
