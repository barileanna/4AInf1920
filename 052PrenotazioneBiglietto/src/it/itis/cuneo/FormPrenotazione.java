package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FormPrenotazione extends JFrame implements ActionListener {

    //dichiarazione etichette
    JLabel cognome;
    JLabel nome;
    JLabel telefono;
    JLabel partenza;
    JLabel destinazione;
    JLabel data;

    //dichiarazione campi di testo
    JTextField tCognome;
    JTextField tNome;
    JTextField tTelefono;
    JTextField tPartenza;
    JTextField tDestinazione;
    JTextField tData;

    //dichiarazione pulsanti
    JButton conferma;
    JButton annulla;
    JButton stampa;
    JButton salva;

    //array di prenotazioni
    private ArrayList<Prenotazione> prenotazioni;
    //dichiarazione contatore per la stampa
    private int cnt = 0;
    //percorso del file da salvare
    public static final String FILE_PATH = "C:\\Users\\Anna\\Desktop\\052PrenotazioneBiglietto\\prenotazioni.csv";

    public FormPrenotazione(){
        //creazione array list
        prenotazioni = new ArrayList<Prenotazione>();
        //set titolo finestra
        setTitle("Prenota il tuo biglietto!");
        //set dimensioni finestra
        setSize(400, 300);
        //set posiszione della finsetra sul monitor
        setLocation(500,200);
        //la finestra non è ridimensionabile
        setResizable(false);
        //inizializzazione
        initComponents();
        //finestra visibile
        setVisible(true);
        //operazioni di chiusura
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        //creazione nuovo pannello
        JPanel finestra = new JPanel();
        //nessun layout preimpostato, posizionamento degli oggetti manuale (dopo la dichiarazione degli oggetti)
        finestra.setLayout(null);
        //etichetta
        cognome = new JLabel("Cognome: ");
        //inserimento etichetta sul pannello
        finestra.add(cognome);
        //campo di testo
        tCognome = new JTextField();
        //inserimento campo di testo sul pannello
        finestra.add(tCognome);
        //etichetta
        nome = new JLabel("Nome: ");
        //inserimento etichetta sul pannello
        finestra.add(nome);
        //campo di testo
        tNome = new JTextField();
        //inserimento campo di testo sul pannello
        finestra.add(tNome);
        //etichetta
        telefono = new JLabel("Telefono: ");
        //inserimento etichetta sul pannello
        finestra.add(telefono);
        //campo di testo
        tTelefono = new JTextField();
        //inserimento campo di testo sul pannello
        finestra.add(tTelefono);
        //etichetta
        partenza = new JLabel("Partenza: ");
        //inserimento etichetta sul pannello
        finestra.add(partenza);
        //campo di testo
        tPartenza = new JTextField();
        //inserimento campo di testo sul pannello
        finestra.add(tPartenza);
        //etichetta
        destinazione = new JLabel("Arrivo: ");
        //inserimento etichetta sul pannello
        finestra.add(destinazione);
        //campo di testo
        tDestinazione = new JTextField();
        //inserimento campo di testo sul pannello
        finestra.add(tDestinazione);
        //etichetta
        data = new JLabel("Data: ");
        //inserimento etichetta sul pannello
        finestra.add(data);
        //campo di testo
        tData = new JTextField();
        //inserimento campo di testo sul pannello
        finestra.add(tData);

        //layout 'personale' --> posizionamento di tutti i componenti per un miglior risultato
        //posizionamento delle etichette all'interno della mia finestra
        cognome.setBounds(60,30,60,15);
        nome.setBounds(60,50,60,15);
        telefono.setBounds(60,70,60,15);
        partenza.setBounds(60,90,60,15);
        destinazione.setBounds(60,110,60,15);
        data.setBounds(60,130,60,15);

        //posizionamento dei campi di testo all'interno della mia finestra
        tCognome.setBounds(135,30,200,20);
        tNome.setBounds(135,50,200,20);
        tTelefono.setBounds(135,70,200,20);
        tPartenza.setBounds(135,90,200,20);
        tDestinazione.setBounds(135,110,200,20);
        tData.setBounds(135,130,200,20);

        //nuovo pannello con i pulsanti
        JPanel bottoni = new JPanel();
        //pulsante conferma
        conferma = new JButton("Conferma");
        //inserimento pulsante sul pannello
        bottoni.add(conferma);
        //gestore degli eventi
        conferma.addActionListener(this);

        //pulsante annulla
        annulla = new JButton("Annulla");
        //inserimento campo di testo sul pannello
        bottoni.add(annulla);
        //gestore degli eventi
        annulla.addActionListener(this);

        //pulsante salva
        salva = new JButton("Salva");
        //inserimento campo di testo sul pannello
        bottoni.add(salva);
        //gestore degli eventi
        salva.addActionListener(this);

        //pulsante stampa
        stampa = new JButton("Stampa");
        //inserimento campo di testo sul pannello
        bottoni.add(stampa);
        //gestore degli eventi
        stampa.addActionListener(this);

        //inserimento dei due pannelli sulla finestra principale
        this.add(finestra, BorderLayout.CENTER);
        this.add(bottoni, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //pulsante conferma premuto
        if(actionEvent.getSource() == conferma){
            //nuova prenotazione
            Prenotazione prenotazione = new Prenotazione();
            //salva la prenotazione
            salvaInfo(prenotazione);
            //aggiungere la prenotazione all'array list
            prenotazioni.add(prenotazione);
            //messaggio di conferma
            printMessage("Confermata la prenotazione");
        }
        //pulsante annulla premuto
        if(actionEvent.getSource() == annulla){
            //messaggio di annullamento
            printMessage("Annullata la prenotazione");
        }
        //pulsante stampa premuto
        if(actionEvent.getSource() == stampa){
            //stampa delle prenotazioni su una finestra a scorrimento
            printPrenotazioni();
        }
        //pulsante salva premuto
        if(actionEvent.getSource() == salva){
            //salva i dati su un file CSV
            salvaCSV();
            //pulisce i campi di testo
            reset();
        }
    }

    //stampa delle prenotazioni
    private void printPrenotazioni() {
        /*SOLUZIONE MESSAGGIO CON SCROLL BAR, NON CON PULSANTI AVANTI INDIETRO
        //stringa da stampare
        String stringa = "Prenotazioni: \n";
        //ciclo for per tutti gli elementi dell'array list
        for(int cnt=0; cnt<prenotazioni.size(); cnt++){
            //aggiungo tutte le prenotazioni alla stringa da stampare
            stringa = stringa + "Prenotazione "+(cnt+1)+" " + prenotazioni.get(cnt).toString();
        }
        //creazione area di testo
        JTextArea textArea = new JTextArea(6, 25);
        //metto la stringa nell'area di testo
        textArea.setText(stringa);
        //set colore testo
        textArea.setSelectedTextColor(Color.BLACK);
        //non si può modificare il testo
        textArea.setEnabled(false);
        //pannello di scorrimento con scrollBar
        JScrollPane scrollPane = new JScrollPane(textArea);*/


        //SOLUZIONE CON I PULSANTI AVANTI E INDIETRO
        JPanel show = new JPanel();
        //caratteri pulsanti della finestra
        String[] options = {"< indietro", "avanti >"};
        String string = "";
        while(cnt<prenotazioni.size()){
            string = "Prenotazione "+ (cnt+1)+" " +prenotazioni.get(cnt).toString();
            //JOptionPane.showMessageDialog(null, vPrenotazioni.toString()) --> utilizzo JOptionPane.showOptionDialog per poter inserire il pulsante avanti/indietro
            int x = JOptionPane.showOptionDialog(null, string, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            //pulsante indietro
            if(x==0 && cnt>0){
                //contatore decrementato
                cnt--;
            }
            //pulsante avanti
            if(x==1){
                //contatore incrementato
                cnt++;
            }
            //pulsante chiudi finestra di messaggio
            if(x== JOptionPane.CLOSED_OPTION){
                //chiusura della finestra di dialogo
                return;
            }
        }
    }

    //stampa messaggio
    private void printMessage(String stringa) {
        //finestra di dialogo per la stampa del messaggio di conferma o di annullamento
        JOptionPane.showMessageDialog(this, stringa);
        //pulisce i campi di testo
        reset();
    }

    //reset
    private void reset() {
        //pulisce tutti i campi di testo
        tCognome.setText("");
        tNome.setText("");
        tTelefono.setText("");
        tPartenza.setText("");
        tDestinazione.setText("");
        tData.setText("");
    }

    //salva info
    public void salvaInfo(Prenotazione prenotazione){
        //salva le informazioni della prenotazione per poi aggiungerle all'array list
        prenotazione.setCognome(tCognome.getText());
        prenotazione.setNome(tNome.getText());
        prenotazione.setTelefono(tTelefono.getText());
        prenotazione.setPartenza(tPartenza.getText());
        prenotazione.setDestinazione(tDestinazione.getText());
        prenotazione.setData(tData.getText());
    }

    //slavaCSV
    public void salvaCSV() {
        BufferedWriter bw;
        try {
            //creazione bufferedWriter
            bw= new BufferedWriter(new FileWriter(FILE_PATH, true));
            //ciclo for per tutte le prenotazioni
            for(int cntPrenotazioni=0; cntPrenotazioni<prenotazioni.size(); cntPrenotazioni++)
            {
                //prenotazione
                Prenotazione pren = prenotazioni.get(cntPrenotazioni);
                //stampa di controllo
                System.out.println(pren.toString());
                //scrittura sul file della prenotazione in formato csv
                bw.write(pren.toRowCSV());
                //stampa di controllo
                System.out.println("salvato!\n");
            }
            //obbligatorio oppure il file rimane vuoto
            //forza lo svuotamento del buffer nel file, dopo di che lo chiude
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //main
    public static void main(String[] args) {
        //creazione finestra
        FormPrenotazione formPrenotazione = new FormPrenotazione();
    }

    @Override
    public String toString() {
        return "FormPrenotazione{" +
                "prenotazioni=" + prenotazioni +
                '}';
    }
}
