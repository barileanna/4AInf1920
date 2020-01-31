package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@XmlType(propOrder = {"telaio","freno", "cambio", "ruotaA", "ruotaP"})
public class Bicicletta {

    private String telaio;
    private String freno;
    private String cambio;
    private String ruotaA;
    private String ruotaP;


    public Bicicletta() {
        super();
    }

    public Bicicletta(String telaio, String freno, String cambio, String ruotaA, String ruotaP) {
        this.telaio = telaio;
        this.freno = freno;
        this.cambio = cambio;
        this.ruotaA = ruotaA;
        this.ruotaP = ruotaP;
    }


    public String getTelaio() {
        return telaio;
    }

    @XmlElement
    public void setTelaio(String telaio) {
        this.telaio = telaio;
    }

    public String getFreno() {
        return freno;
    }

    @XmlElement
    public void setFreno(String freno) {
        this.freno = freno;
    }

    public String getCambio() {
        return cambio;
    }

    @XmlElement
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }


    public String getRuotaA() {
        return ruotaA;
    }

    @XmlElement
    public void setRuotaA(String ruotaA) {
        this.ruotaA = ruotaA;
    }

    public String getRuotaP() {
        return ruotaP;
    }

    @XmlElement
    public void setRuotaP(String ruotaP) {
        this.ruotaP = ruotaP;
    }



    @Override
    public String toString() {
        return "Bicicletta{" +
                "telaio='" + telaio + '\'' +
                ", freno='" + freno + '\'' +
                ", cambio='" + cambio + '\'' +
                ", ruotaA='" + ruotaA + '\'' +
                ", ruotaP='" + ruotaP + '\'' +
                '}';
    }
}
