package it.itis.cuneo;

import java.util.List;

public class Prenotazione {

    private String cognome;
    private String nome;
    private String telefono;
    private String partenza;
    private String destinazione;
    private String data;
    public static final String SEPARATOR = ",";

    public Prenotazione() {
        super();
    }

    public Prenotazione(String cognome, String nome, String telefono, String partenza, String destinazione, String data) {
        this.cognome = cognome;
        this.nome = nome;
        this.telefono = telefono;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.data = data;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", telefono='" + telefono + '\'' +
                ", partenza='" + partenza + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", data='" + data + '\'' + "\n";
    }

    public String toRowCSV(){
        return cognome + SEPARATOR +
                nome + SEPARATOR +
                telefono + SEPARATOR +
                partenza + SEPARATOR +
                destinazione + SEPARATOR +
                data + "\n";
    }
}
