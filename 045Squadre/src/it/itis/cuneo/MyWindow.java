package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyWindow extends JFrame implements ActionListener {

    JLabel lSquadra1;
    JLabel lSquadra2;
    JLabel lpunteggio;
    JTextField tSquadra1;
    JTextField tSquadra2;
    JTextField tPunteggio;
    JButton invia;
    JLabel tCompleto;

    public MyWindow(){
        setTitle("MyFrame");
        initComponets();
        /*JPanel myPanel = new JPanel();
        myPanel.setBackground(Color.BLUE);
        Container container = this.getContentPane();
        container.add(myPanel);*/
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponets() {
        this.setLayout(new FlowLayout());
        this.setBounds(200,100,300,250);
        lSquadra1 = new JLabel("squadra1: ");
        this.add(lSquadra1);
        tSquadra1 = new JTextField(20);
        this.add(tSquadra1);
        lSquadra2 = new JLabel("squadra2: ");
        this.add(lSquadra2);
        tSquadra2 = new JTextField(20);
        this.add(tSquadra2);
        lpunteggio= new JLabel("punteggio: ");
        this.add(lpunteggio);
        tPunteggio = new JTextField(20);
        this.add(tPunteggio);
        invia = new JButton("Invia");
        this.add(invia);
        tCompleto = new JLabel("\nSquadre - punteggi");
        this.add(tCompleto);
        invia.addActionListener(this);
    }



    public static void main(String[] args) {
        MyWindow myWin = new MyWindow();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == invia){
            tCompleto.setText(tSquadra1.getText() + " "
                    + tSquadra2.getText() + " "
                    + tPunteggio.getText() + "\n"
            );
        }
    }
}
