import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by inf.barilea1810 on 20/02/2020.
 */
public class Tris extends JFrame implements ActionListener{

    private JButton matrice [][];
    private int turno = 0;
    private int contX;
    private int contY;
    private int contD;
    public static final String X = "X";
    public static final String O = "O";
    public static final String FILE_PATH = "C:\\Users\\Anna\\Desktop\\050Tris\\file.txt";
    JButton inizia;

    public Tris()
    {
        matrice = new JButton[3][3];
        setSize(300,300);
        setLocation(200, 200);
        setTitle("Tris Barile");
        setResizable(false);
        initComponets();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void initComponets() {
        JPanel grigliaTris = new JPanel();
        grigliaTris.setLayout(new GridLayout(3,3));
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                matrice[r][c] = new JButton();
                matrice[r][c].setText("");
                matrice[r][c].setBackground(Color.ORANGE);
                matrice[r][c].setEnabled(true);
                grigliaTris.add(matrice[r][c]);
                matrice[r][c].addActionListener(this);
            }
        }
        this.add(grigliaTris);
        JPanel sPanel = new JPanel();
        inizia = new JButton("Gioca");
        sPanel.add(inizia);
        inizia.addActionListener(this);
        this.add(sPanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == inizia){
            newGame();
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if((turno%2) == 0){
                    if (actionEvent.getSource() == matrice[r][c]) {
                        System.out.println("Turno" + turno + " del giocatore");
                        toggle(matrice[r][c]);
                        matrice[r][c].setEnabled(false);
                        turno++;
                        isWinnerR();
                        isWinnerC();
                        isWinnerD1();
                        isWinnerD2();
                        partitaFinita();
                        if(c==2 && r==2){
                            c=c-1;
                        }
                    }
                }else{
                    System.out.println("Turno" + turno + " del computer");
                    automatico();
                }

            }
        }
    }

    public void automatico() {
        boolean giocato = false;

        while (!giocato) {
            Random rand = new Random();
            int r = rand.nextInt((2)+1);
            int c = rand.nextInt((2)+1);
            if(matrice[r][c].getText().equalsIgnoreCase("")){
                toggle(matrice[r][c]);
                matrice[r][c].setEnabled(false);
                turno++;
                isWinnerR();
                isWinnerC();
                isWinnerD1();
                isWinnerD2();
                partitaFinita();
                giocato = true;
            }
        }
    }

    public void partitaFinita() {
        int cnt = 0;
        for(int r=0; r<3; r++){
            for(int c=0; c<3;c++){
                if(matrice[r][c].getText().equalsIgnoreCase(X) || matrice[r][c].getText().equalsIgnoreCase(O) ){
                    cnt ++;
                }
            }
        }
        if(cnt==9){
            printWinner("Pareggio");
        }
    }

    public void toggle(JButton jButton) {
        String txt = jButton.getText();
        if((turno %2)==0){
            if(txt.equalsIgnoreCase("")){
                txt = O;
            }
        }else if(txt.equalsIgnoreCase("")){
            txt = X;
        }
        jButton.setText(txt);
    }

    public void printWinner(String x) {
        JOptionPane.showMessageDialog(this,x);
        salva(x);
        newGame();
    }

    public void newGame() {
        for(int r=0;r<3;r++){
            for(int c=0; c<3; c++){
                matrice[r][c].setText("");
                matrice[r][c].setEnabled(true);
            }
        }
        turno = 0;
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
            for(int r=0; r<3; r++){
                for(int c=0; c<3; c++){
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

    public void isWinnerD1() {
        contD = 0;
        for(int c=0; c<3; c++){
            for(int r=0; r<3; r++){
                //controllo matrice al contrario
                if(matrice[r][c].getText().equalsIgnoreCase(X) && r==c){
                    contD++;
                }if(matrice[r][c].getText().equalsIgnoreCase(O) && r==c){
                    contD--;
                }
            }
            if(contD == 3){
                this.printWinner("Ha vinto: " + X);
            }
            if(contD == -3){
                this.printWinner("Ha vinto: " + O);
            }
        }
    }

    public void isWinnerD2() {
        contD = 0;
        for(int c=0; c<3; c++){
            for(int r=0; r<3; r++){
                //controllo matrice al contrario
                if(matrice[r][c].getText().equalsIgnoreCase(X) && (r+c == 2)){
                    contD++;
                }if(matrice[r][c].getText().equalsIgnoreCase(O) && (r+c==2)){
                    contD--;
                }
            }
            if(contD == 3){
                this.printWinner("Ha vinto: " + X);
            }
            if(contD == -3){
                this.printWinner("Ha vinto: " + O);
            }
        }
    }

    public void isWinnerC() {
        for(int c=0; c<3; c++){
            for(int r=0; r<3; r++){
                if(matrice[r][c].getText().equalsIgnoreCase(X)){
                    contY++;
                }if(matrice[r][c].getText().equalsIgnoreCase(O)){
                    contY--;
                }
            }
            if(contY == 3){
                this.printWinner("Ha vinto: " + X);
            }
            if(contY == -3){
                this.printWinner("Ha vinto: " + O);
            }
            contY = 0;
        }
    }

    public void isWinnerR(){
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                if(matrice[r][c].getText().equalsIgnoreCase(X)){
                    contX++;
                }if(matrice[r][c].getText().equalsIgnoreCase(O)){
                    contX--;
                }
            }
            if(contX == 3){
                this.printWinner("Ha vinto: " + X);
            }
            if(contX == -3){
                this.printWinner("Ha vinto: " + O);
            }
            contX = 0;
        }
    }

    public static void main(String[] args) {
        Tris finestra = new Tris();
    }
}
