package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


//togliere la scritta al bottone
//sfida con il computer, il computer può inserire la pedina solo dove possibile
//controllo diagonali unito

public class Forza4 extends JFrame implements ActionListener {

    //attributi
    //matrice di bottoni per la griglia del forza 4
    private JButton matrice[][];
    //pulsante di inizio gioco
    JButton inizia;
    //variabile per stabilire il turno
    private int turno = 0;
    //contatori per determinare la vincita di uno dei due giocatori
    private int contC = 0;
    private int contR = 0;
    private int contD = 0;
    //strighe di assegnazione dei bottoni
    public static final String G = "G"; //giallo
    public static final String R = "R"; //rosso
    //Path del file da salvare
    public static final String FILE_PATH = "C:\\Users\\Anna\\Desktop\\051Forza4\\game.txt";

    //costruttore
    public Forza4() {
        //creazione matrice di bottoni
        matrice = new JButton[4][4];
        //impostazione dimensioni finestra
        setSize(400, 400);
        //impostazione titolo finestra
        setTitle("Forza 4");
        //impostazione ridimensione finestra --> falso
        setResizable(false);
        //inizializzo i componenti della finestra
        initComponents();
        //rendo visibile la finestra
        setVisible(true);
        //operazione di chiusura finestra
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        //creo pannello di griglia
        JPanel griglia = new JPanel();
        //assegno alla griglia il layout(4 col, 4 righe)
        griglia.setLayout(new GridLayout(4, 4));
        //ciclo creazione dei bottoni (scorrimento della matrice)
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                //creo bottone
                matrice[r][c] = new JButton();
                //inizializzazione testo bottone
                matrice[r][c].setText("");
                //inizializzazione colore bottone
                matrice[r][c].setBackground(Color.WHITE);
                //se il bottone fa parte dell'ultima riga lo abilito alla modifica
                if (r == 3) {
                    matrice[r][c].setEnabled(true);
                }
                //altrimenti lo disabilito
                else {
                    matrice[r][c].setEnabled(false);
                }
                //aggiungo il bottone creato alla griglia
                griglia.add(matrice[r][c]);
                matrice[r][c].addActionListener(this);
            }
        }
        //aggiungo la griglia alla finestra
        this.add(griglia);
        //nuovo pannello
        JPanel sPanel = new JPanel();
        //pulsante inizia
        inizia = new JButton("Gioca");
        //aggiungo pulsante al pannello
        sPanel.add(inizia);
        inizia.addActionListener(this);
        //aggiungo il nuovo pannello nella sezione SOUTH della finestra
        this.add(sPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //se ho premuto il pulsante inizia
        if(actionEvent.getSource() == inizia){
            //metodo newGame()
            newGame();
        }
        //ciclo di socrrimento della matrice
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                //se è il urno del giocatore
                if ((turno % 2) == 0) {
                    //è stato premuto il bottone
                    if (actionEvent.getSource() == matrice[r][c]) {
                        //output di controllo
                        System.out.println("Turno" + turno + " del giocatore");
                        //metodo toggle
                        toggle(matrice[r][c]);
                        //disabilito la cella
                        matrice[r][c].setEnabled(false);
                        //incremento il turno
                        turno++;
                        //se non sono alla prima riga(riga 0)
                        if(r-1>=0) {
                            //abilito la cella sopra quella appena modificata
                            matrice[r - 1][c].setEnabled(true);
                        }
                        //controllo vittoria nelle righe
                        controlRow();
                        //controllo vittoria colonna
                        controlCol();
                        //controllo vittoria diagonale
                        controlDiag1();
                        //controllo vittoria diagonale
                        controlDiag2();
                        //controllo partita finita in pareggio
                        partitaFinita();
                    }
                    //turno del computer
                } else {
                //output di controllo
                    System.out.println("Turno" + turno + " del computer");
                    //metodo automatico
                    automatico();
                }
            }
        }
    }

    private void automatico() {
        boolean giocato = false;

        while (!giocato) {
            Random rand = new Random();
            int r = rand.nextInt((3)+1);
            int c = rand.nextInt((3)+1);
            if (matrice[r][c].getText().equalsIgnoreCase("") && (matrice[r][c].isEnabled()==true)) {
                toggle(matrice[r][c]);
                if(r-1>=0) {
                    //abilito la cella sopra quella appena modificata
                    matrice[r - 1][c].setEnabled(true);
                }
                matrice[r][c].setEnabled(false);
                turno++;
                controlRow();
                controlCol();
                controlDiag1();
                controlDiag2();
                partitaFinita();
                giocato = true;
            }
        }
    }

    //toggle()
    private void toggle(JButton jButton) {
        //inizializzo stringa contenuto della cella
        String txt = "";
        //turno di giocatore 1
        if ((turno % 2) == 0) {
            //G
            txt = G;
            //impostazione colore bottone
            jButton.setBackground(Color.YELLOW);
        }
        //turno giocatore 2
        else{
            //R
            txt = R;
            //impostazione colore bottone
            jButton.setBackground(Color.RED);
        }
        //impostazione testo bottone
        jButton.setText(txt);
    }

    //partitaFinita()
    private void partitaFinita() {
        //contatore celle piene
        int cnt = 0;
        //ciclo scorrimento matrice
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                //se il bottone preso in considerazione è già stato selezionato
                if (matrice[r][c].getText().equalsIgnoreCase(G) || matrice[r][c].getText().equalsIgnoreCase(R)) {
                    //incremento contatore
                    cnt++;
                }
            }
        }
        //se tutte le celle sono state riempite
        if (cnt == 16) {
            //parità --> partita terminata
            printWinner("Pareggio");
        }
    }

    //printWinner(String winner)
    private void printWinner(String winner) {
        //messaggio di vittoria
        JOptionPane.showMessageDialog(this, winner);
        //salva la partita sul file
        salva(winner);
        //nuova partita
        newGame();
    }

    //newGame()
    private void newGame() {
        //azzeramento di tutti i bottoni
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                matrice[r][c].setBackground(Color.WHITE);
                matrice[r][c].setText("");
                if (r == 3) {
                    matrice[r][c].setEnabled(true);
                }else{
                    matrice[r][c].setEnabled(false);
                }
            }
        }
        //inizializzazione turni
        turno = 0;
    }

    //controlRow()
    private void controlRow() {
        //ciclo scorrimento righe
        for (int r = 0; r < 4; r++) {
            //inizializzazioe contatore
            contR = 0;
            //ciclo scorrimento colonne
            for (int c = 0; c < 4; c++) {
                //se la cella è rossa
                if (matrice[r][c].getText().equalsIgnoreCase(R)) {
                    //incremento contatore
                    contR++;
                }
                //se la cella è gialla
                if (matrice[r][c].getText().equalsIgnoreCase(G)) {
                    //decremento contatore
                    contR--;
                }
            }
            //se la riga ha 4 celle rosse
            if (contR == 4) {
                //stampa vincitore
                this.printWinner("Ha vinto: ROSSO (riga" +(3-r+1)+")");
            }
            //se la riga ha 4 celle gialle
            if (contR == -4) {
                //stampa vincitore
                this.printWinner("Ha vinto: GIALLO (riga " +(3-r+1)+")");
            }
        }
    }

    //controlCol()
    private void controlCol() {
        //ciclo scorrimento colonne
        for (int c = 0; c < 4; c++) {
            //contatore
            contC = 0;
            //ciclo scoriimento righe
            for (int r = 0; r < 4; r++) {
                //se la cella è rossa
                if (matrice[r][c].getText().equalsIgnoreCase(R)) {
                    //incremento contatore
                    contC++;
                }
                //se la cella è gialla
                if (matrice[r][c].getText().equalsIgnoreCase(G)) {
                    //decremento contatore
                    contC--;
                }
            }
            //se la colonna ha 4 celle rosse
            if (contC == 4) {
                //stampo vincitore
                this.printWinner("Ha vinto: ROSSO (colonna" +(c+1)+")");
            }
            //se la colonna ha 4 celle gialle
            if (contC == -4) {
                //stampo vincitore
                this.printWinner("Ha vinto: GIALLO (colonna " +(c+1)+")");
            }
        }
    }

    //controlDiag1()
    private void controlDiag1() {
        contD = 0;
        for(int r=0; r<4; r++){
            for(int c=0; c<4; c++){
                if(matrice[r][c].getText().equalsIgnoreCase(R) && r==c){
                    contD++;
                }
                if(matrice[r][c].getText().equalsIgnoreCase(G) && r==c){
                    contD--;
                }
            }
            if(contD == 4){
                this.printWinner("Ha vinto: " + R + "(diagonale)");
            }
            if(contD == -4){
                this.printWinner("Ha vinto: " + G + "(diagonale)");
            }
        }
    }

    //controlDiag2()
    private void controlDiag2() {
        contD = 0;
        for(int r=0; r<4; r++){
            for(int c=0; c<4; c++){
                if(matrice[r][c].getText().equalsIgnoreCase(R) && (r+c==3)){
                    contD++;
                }
                if(matrice[r][c].getText().equalsIgnoreCase(G) && (r+c==3)){
                    contD--;
                }
            }
            if(contD == 4){
                this.printWinner("Ha vinto: " + R + "(diagonale)");
            }
            if(contD == -4){
                this.printWinner("Ha vinto: " + G + "(diagonale)");
            }
        }
    }

    public void salva(String x) {
        BufferedWriter bw;
        String str = "";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        str = str + sdf.format(calendar.getTime()) + "\n" ;
        str = str + x.toUpperCase() + "\n";
        try{
            bw = new BufferedWriter(new FileWriter(FILE_PATH,true));
            for(int r=0; r<4; r++){
                for(int c=0; c<4; c++){
                    String btnText = matrice[r][c].getText();
                    if(btnText.equals("")){
                        btnText = "-";
                    }
                    str = str + btnText + " ";
                }
                str = str + "\n";
            }
            str = str + "\n";

            bw.write(str);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Forza4 forza4 = new Forza4();
    }
}
