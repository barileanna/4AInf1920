package itis.cuneo.preventivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preventivo {
	//percorso di dove salvare il file CSV
	public static final String FILE_NAME = "D:\\4AINF\\informatica\\intellij\\Esercizi\\31PreventivoCsv\\preventivo.csv";
	//separatore nelle righe del file di CSV
	public static final String SEPARATOR = ",";

	//lista dei cliente
	private List<Cliente> aCliente;
	//dichiarazione IVA
	public static final int IVA= 22;

	//costruttore
	public Preventivo() {
		super();
		aCliente= new ArrayList<>();
	}

	//overloading --> due metodi con stesso nome, ma firma diversa (costruttori)
	//override --> due metodi con la stessa firma, nella stessa famiglia
	//sovraccarico del costruttore precedente (stesso nome, firma diversa)
	public Preventivo(List<Cliente> aCliente) {
		super();
		this.aCliente = aCliente;
	}

	//aggiugere cliente
	public void aggiungiCliente(Cliente cliente) {
		
		this.aCliente.add(cliente);
	}
	
	
	//setter e getter
	public List<Cliente> getaCliente() {
		return aCliente;
	}


	public void setaCliente(List<Cliente> aCliente) {
		this.aCliente = aCliente;
	}

	//dati precaricati di simulazione
	public void simula() {
		//nuovo cliente con dati
		Cliente c= new Cliente("MARIO", "ROSSI", "VIA SOLE");
		Articolo a= new Articolo("sz1", "domestico", 100, 20, 2);
		Articolo b= new Articolo("sz2", "domestica", 15, 10, 1);
		//aggiuta degli articoli all'arrayList di articoli
		c.aggiungiArticolo(a);
		c.aggiungiArticolo(b);
		//aggiunta degli articoli all'arrayList dei clienti
		this.aggiungiCliente(c);
		
		Cliente c2= new Cliente("LUCA", "MASI", "VIA LUNA");
		Articolo a2= new Articolo("sz3", "informatico", 200, 15, 3);
		Articolo b2= new Articolo("sz4", "domotico", 23, 10,8);
		c2.aggiungiArticolo(a2);
		c2.aggiungiArticolo(b2);
		this.aggiungiCliente(c2);
	}

	//caricamento dei clienti da tastiera
	public void caricaClienti(Preventivo preventivo) {
		int numeroClienti=Tastiera.leggiNumero("Inserisci la quantita di clienti: ");
		
		Cliente c= new Cliente();
		for(int cntClienti=0;cntClienti<numeroClienti;cntClienti++) {
			c.caricaCliente(preventivo);
		}
	}
	
	

	@Override
	public String toString() {
		//quando fai il toString di una lista il programma chiama tutti i toString dei dati della lista
		return "Preventivo [aCliente=" + aCliente + "]";
	}

	//toString del preventivo, stampa soltatnto
	public void stampa() {
		System.out.println( this.toString() );
	}

	//stampa di tutti i dati del cliente, dell'articolo e del preventivo utilizzando un ciclo for (ti fa il preventivo)
	public void stampConFor() {
		float sumPreventivo=0;
		for(int cntCliente = 0; cntCliente<this.aCliente.size(); cntCliente++) {
			Cliente cliente = this.getaCliente().get(cntCliente);
			System.out.println("Cliente: " + cliente.toString());
			double totaleIvato = cliente.calcolaPrezzoTotale();
			System.out.println("Totale ivato: " + totaleIvato);
			
			sumPreventivo += totaleIvato;
		}
		System.out.println("Totale Preventivo: " + sumPreventivo);
		
	}

	//ordinamento per cognome dei clienti inseriti
	public void ordinaPreventivoByCognomeCliente() {
		//richiama in automatico il metodo sort(Object) dell' elemento della lista,
		//   che implementa il metodo sort(Object) dell'interfaccia Comparable
		//ordina in base al cognome l'arrayList di clienti aClienti
		Collections.sort( this.aCliente );
	}

	//ricerca del cliente per cognome e nome
	public Cliente ricercaClienteByCognomeAndNome(String cognome, String nome) {
		Cliente cliente=null;
		boolean foundCliente=false;
		
		for(int cntCliente = 0; cntCliente<this.aCliente.size() && !foundCliente; cntCliente++) {
			cliente=this.aCliente.get(cntCliente);
			if(cliente.getCognome().equalsIgnoreCase(cognome)
				&& cliente.getNome().equalsIgnoreCase(nome)) {
				foundCliente=true;
			}
			else {
				cliente=null;
			}
		}
		
		return cliente;
	}
	
	//salva il file CSV
	public void salvaCSV() {
		String str ="";
		BufferedWriter bw;
		try {
			bw= new BufferedWriter(new FileWriter(FILE_NAME));
			
			for(int cntCliente=0; cntCliente<this.aCliente.size(); cntCliente++)
			{
				Cliente cliente = this.aCliente.get(cntCliente);
				bw.write(cliente.toRowCSV());
				
				for(int cntArticolo=0; cntArticolo<cliente.getaArticolo().size(); cntArticolo++) {
					Articolo articolo = cliente.getaArticolo().get(cntArticolo);
					bw.write(articolo.toRowCsv());
				}
			}
			
			//obbligatorio oppure il file rimane vuoto
			//forza lo svuotamento del buffer nel file, dopo di che lo chiude
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	}

	//aprire il CSV
	public void apriCSV() {
		BufferedReader br;
		String rowLine;
		Cliente cliente= null;
		
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			
			while((rowLine = br.readLine()) != null) {
				String[] campi = rowLine.split(Preventivo.SEPARATOR);
				if(campi[0].equalsIgnoreCase("Cliente")) {
					cliente = new Cliente(campi[1], campi[2], campi[3]);
					this.aggiungiCliente(cliente);
				}
				if(campi[0].equalsIgnoreCase("Articolo")) {
					//public Articolo(String codice, String descrizione, double importoSenzaIVA, int scontoPercentuale, int quantita) 
					Articolo articolo = new Articolo(campi[1], campi[2], Double.parseDouble(campi[3]),
										Integer.parseInt(campi[4]), Integer.parseInt(campi[5]));
					cliente.aggiungiArticolo(articolo);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	//main
	public static void main(String[]args) {
		//metodo simula()
		//caricare la struttura
		Preventivo p= new Preventivo();
		p.simula();
		
		/*Cliente cliente = p.getaCliente().get(0);
		double totaleIvato = cliente.calcolaPrezzoTotale();
		System.out.println("totaleIvato: " + totaleIvato);
		*/
		//p.caricaClienti(p);

		//stampa i vari preventivi
		System.out.println("\n\n\n*********<stampa preventivo..");
		p.stampa();

		//usa un forEach
		System.out.println("\n\n\n*********stampa preventivo con for..");
		p.stampConFor();

		//stampa i preventivi in ordine di cognome
		System.out.println("\n\n\n*********stampa preventivo ordinato..");
		p.ordinaPreventivoByCognomeCliente();
		p.stampa();


		System.out.println("\n\n\n*********stampa preventivo dopo rimuovi..");
		Cliente cliente = p.ricercaClienteByCognomeAndNome("Rossi", "Mario");
		if(cliente!= null) {
			cliente.eliminaArticolo("A1");
		}
		p.stampa();
		
		p.salvaCSV();
		
		Preventivo preventivo2 = new Preventivo();
		preventivo2.apriCSV();
		System.out.println("\n\n\n*********stampa preventivo dopo caricamento da CSV..");
		preventivo2.stampa();
	}

	
}
