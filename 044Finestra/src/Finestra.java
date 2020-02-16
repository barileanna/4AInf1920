import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Finestra extends JFrame implements ActionListener {
	
	JLabel lCognome;
	JLabel lNome;
	JLabel lEta;
	JTextField tNome;
	JTextField tCognome;
	JTextField tEta;
	JButton bInvia;
	JLabel lCompleto;
	
	public Finestra()
	{
		setSize(1200,600);
		setLocation(200, 200);
		setTitle("MyFirstFrame");
		initComponets();
		//pack();
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.LIGHT_GRAY);
		Container container = this.getContentPane();
		container.add(myPanel);
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 }
	
	private void initComponets() {
		// TODO Auto-generated method stub
		this.setLayout(new FlowLayout());
		lCognome = new JLabel("cognome: ");
		this.add(lCognome);
		tCognome = new JTextField(20);
		this.add(tCognome);
		lNome = new JLabel("nome: ");
		this.add(lNome);
		tNome= new JTextField(20);
		this.add(tNome);
		lEta = new JLabel("età: ");
		this.add(lEta);
		tEta= new JTextField(20);
		this.add(tEta);
		bInvia= new JButton("Invia");
		this.add(bInvia);
		lCompleto = new JLabel("Cognome+Nome+Età");
		this.add(lCompleto);
		bInvia.addActionListener(this);
	}
	
	//@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == bInvia)
		{
			lCompleto.setText(tCognome.getText()+" "+tNome.getText()+" "+tEta.getText());
		}
	}
	
	public static void main(String[] args)
	{
		Finestra fs = new Finestra();
	}
}
