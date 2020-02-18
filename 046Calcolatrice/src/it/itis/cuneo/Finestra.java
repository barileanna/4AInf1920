package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finestra extends JFrame implements ActionListener {

    JLabel lNum1;
    JLabel lNum2;
    JTextField tNum1;
    JTextField tNum2;
    JButton somma;
    JButton sott;
    JButton mul;
    JButton div;
    JLabel tOp;

    public Finestra(){
        setTitle("MyWindow");
        initComponents();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        this.setLayout(new FlowLayout());
        this.setBounds(200,100,200,250);
        lNum1 = new JLabel("Numero: ");
        this.add(lNum1);
        tNum1 = new JTextField(10);
        this.add(tNum1);
        lNum2 = new JLabel("Numero: ");
        this.add(lNum2);
        tNum2 = new JTextField(10);
        this.add(tNum2);
        somma = new JButton("+");
        this.add(somma);
        sott = new JButton("-");
        this.add(sott);
        mul = new JButton("*");
        this.add(mul);
        div = new JButton("/");
        this.add(div);
        tOp = new JLabel("Calcolo: ");
        this.add(tOp);
        somma.addActionListener(this);
        sott.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == somma){
            tOp.setText(String.valueOf((Double.parseDouble(tNum1.getText())) + (Double.parseDouble(tNum2.getText()))));
        }
        if(actionEvent.getSource() == sott){
            tOp.setText(String.valueOf((Double.parseDouble(tNum1.getText())) - (Double.parseDouble(tNum2.getText()))));
        }
        if(actionEvent.getSource() == mul){
            tOp.setText(String.valueOf((Double.parseDouble(tNum1.getText())) * (Double.parseDouble(tNum2.getText()))));
        }
        if(actionEvent.getSource() == div){
            tOp.setText(String.valueOf((Double.parseDouble(tNum1.getText())) / (Double.parseDouble(tNum2.getText()))));
        }

    }

    public static void main(String[] args) {
        Finestra finestra = new Finestra();
    }
}
