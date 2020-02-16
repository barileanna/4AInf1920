package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.File;

/**
 * Created by inf.barilea1810 on 05/02/2020.
 */
//public class Prodotto extends Deperibile implements Mangiabile{}
public class Prodotto{

    public static final String NOME_CLASSE = "Prodotto";

    private String id;
    private String nome;

    public Prodotto() {
    }

    public Prodotto(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    @XmlValue
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String toRowCsv(){
        return NOME_CLASSE + Magazzino.SEPARATOR + id + Magazzino.SEPARATOR + nome + "\n";
    }
}
