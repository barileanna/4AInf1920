import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Finestra extends JFrame implements ActionListener, ListSelectionListener {

    JLabel cognome;
    JLabel nome;
    JTextField tCognome;
    JTextField tNome;
    JButton aggiungi;

    JList<String> nameList;
    DefaultListModel listModel;

    JComboBox<String> nameCombo;
    DefaultComboBoxModel comboModel;

    ArrayList<String> aNomi;


    public Finestra(){
        aNomi = new ArrayList<String>();
        setSize(700,250);
        setTitle("Classe");
        initComponent();
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponent() {
        JPanel nomeCognome = new JPanel();
        nomeCognome.setLayout(new FlowLayout());

        cognome = new JLabel("Cognome: ");
        nomeCognome.add(cognome);
        tCognome = new JTextField(20);
        nomeCognome.add(tCognome);

        nome = new JLabel("Nome: ");
        nomeCognome.add(nome);
        tNome = new JTextField(20);
        nomeCognome.add(tNome);

        aggiungi = new JButton("Aggiungi");
        nomeCognome.add(aggiungi);
        aggiungi.addActionListener(this);

        JPanel listCombo = new JPanel();
        listCombo.setLayout(null);
        listModel = new DefaultListModel();
        nameList = new JList<String>(listModel);
        JScrollPane lista = new JScrollPane(nameList);
        lista.setBounds(100,50,200,30);
        listCombo.add(lista);

        comboModel = new DefaultComboBoxModel();
        nameCombo = new JComboBox<String>(comboModel);
        JScrollPane box = new JScrollPane(nameCombo);
        box.setBounds(350,50,200,30);
        listCombo.add(box);

        this.add(BorderLayout.NORTH, nomeCognome);
        this.add(BorderLayout.CENTER, listCombo);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(aggiungi)){
            String stringa = tCognome.getText() + " " + tNome.getText();
            listModel.addElement(stringa);
            comboModel.addElement(stringa);
            tCognome.setText("");
            tNome.setText("");
            aNomi.add(stringa);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
    }

    public static void main(String[] args) {
        Finestra finestra = new Finestra();
    }
}
