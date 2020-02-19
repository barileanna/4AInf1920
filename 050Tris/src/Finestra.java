import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by inf.barilea1810 on 19/02/2020.
 */
public class Finestra extends JFrame implements ActionListener {

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;

    public Finestra()
    {
        setSize(300,300);
        setLocation(200, 200);
        setTitle("MyFirstFrame");
        initComponets();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponets() {
        this.setLayout(new GridLayout(3,3));
        b1 = new JButton();
        this.add(b1);
        b1.addActionListener(this);
        b2 = new JButton();
        this.add(b2);
        b2.addActionListener(this);
        b3 = new JButton();
        this.add(b3);
        b3.addActionListener(this);
        b4 = new JButton();
        this.add(b4);
        b4.addActionListener(this);
        b5 = new JButton();
        this.add(b5);
        b5.addActionListener(this);
        b6 = new JButton();
        this.add(b6);
        b6.addActionListener(this);
        b7 = new JButton();
        this.add(b7);
        b7.addActionListener(this);
        b8 = new JButton();
        this.add(b8);
        b8.addActionListener(this);
        b9 = new JButton();
        this.add(b9);
        b9.addActionListener(this);
    }

    public static void main(String[] args) {
        Finestra finestra = new Finestra();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String txt = "";
        Object source = actionEvent.getSource();
        if (b1.equals(source)) {
            txt = b1.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b1.setText(txt);
        }
        if (b2.equals(source)) {
            txt = b2.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b2.setText(txt);
        }
        if (b3.equals(source)) {
            txt = b3.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b3.setText(txt);
        }
        if (b4.equals(source)) {
            txt = b4.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b4.setText(txt);
        }
        if (b5.equals(source)) {
            txt = b5.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b5.setText(txt);
        }
        if (b6.equals(source)) {
            txt = b6.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b6.setText(txt);
        }
        if (b7.equals(source)) {
            txt = b7.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b7.setText(txt);
        }
        if (b8.equals(source)) {
            txt = b8.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b8.setText(txt);
        }
        if (b9.equals(source)) {
            txt = b9.getText();
            if (txt.equalsIgnoreCase("x")) {
                txt = "O";
            } else {
                txt = "X";
            }
            b9.setText(txt);
        }
    }
}
