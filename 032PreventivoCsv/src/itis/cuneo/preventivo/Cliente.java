package itis.cuneo.preventivo;

import java.util.ArrayList;
import java.util.List;

//Comparable = classe confrontabile
//Comparable = classe che implementa l'interfaccia
public class Cliente implements Comparable {

	private  String nome;
	private  String cognome;
	private  String indirizzo;
	private  List<Articolo> aArticolo;

	//costruttore
	public Cliente(String nome, String cognome, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		aArticolo= new ArrayList<Articolo>();
	}

	//aggiungi un articolo all'arrayList
	public void aggiungiArticolo(Articolo articolo) {
		this.aArticolo.add(articolo);
	}

	//aggiungere il cliente e i vari articoli da acquistare per restituire il preventivo
	public void caricaCliente(Preventivo preventivo) {
		
		nome = Tastiera.leggiNome("Inserire il nome: ");
		cognome = Tastiera.leggiNome("Inserire il cognome: ");
		indirizzo = Tastiera.leggiNome("Inserire l'indirizzo");
		Cliente cliente = new Cliente(nome,cognome,indirizzo);
		preventivo.aggiungiCliente(cliente);
		
		int numeroarticoli = Tastiera.leggiNumero("inserisci il numero di articoli");
		for(int cntarticoli = 0;cntarticoli<numeroarticoli;cntarticoli++) {
			Articolo articolo = new Articolo();
			articolo = articolo.caricaArticolo();
			cliente.aggiungiArticolo(articolo);
		}
	}
	//costruttore
	public Cliente() {
		super();
	}

	//setter e getter
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public List<Articolo> getaArticolo() {
		return aArticolo;
	}

	public void setaArticolo(List<Articolo> aArticolo) {
		this.aArticolo = aArticolo;
	}

	//toSring
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + ", aArticolo="
				+ aArticolo + "]";
	}

	//riga del CSV del cliente (con i separatori)
	public String toRowCSV() {
		return "Cliente" + Preventivo.SEPARATOR + nome + Preventivo.SEPARATOR + cognome + Preventivo.SEPARATOR + indirizzo + "\n";
	}

	//calcolo del prezzo totale
	public double calcolaPrezzoTotale() {
		double totalePrezzoArticoli=0;
		double prezzo;
		
		for(int cntArticolo=0;cntArticolo<this.aArticolo.size();cntArticolo++) {
			Articolo articolo = this.aArticolo.get(cntArticolo);
			prezzo = articolo.calcolaPrezzoScontato( articolo.getImportoSenzaIVA() );
			//prezzo = this.aArticolo.get(cntArticolo).calcolaPrezzoScontato( c.aArticolo.get(cntArticolo).getImportoSenzaIVA() );
			prezzo=prezzo*this.aArticolo.get(cntArticolo).getQuantita();
			totalePrezzoArticoli=totalePrezzoArticoli+prezzo;
		}
	
		double ivaSuTuttiGliArticoli = (totalePrezzoArticoli/100) * 22;
		double totaleConIVA = totalePrezzoArticoli + ivaSuTuttiGliArticoli;
		//double totaleConIVA = totalePrezzoArticoli * (1 + 22 / 100);
		//System.err.println("totaleConIVA: "+totaleConIVA);
		return totaleConIVA;
	}

	//elimina articolo dalla lista degli articoli del cliente
	public void eliminaArticolo(String codice) {
		
		int numArticoli = this.aArticolo.size();
		for(int cntArticoli=0; cntArticoli<numArticoli;cntArticoli++) {
			
			if( ( this.aArticolo.get(cntArticoli).getCodice() ).equalsIgnoreCase( codice ) ) {
				this.aArticolo.remove(cntArticoli);
			}
		}		
		
	}

	@Override
	//confronta due clienti per cognome
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Cliente cliente = (Cliente) arg0;
		
		if(this.cognome.equalsIgnoreCase( cliente.cognome))
			return 1; //true
		else
			return 0;
	}
	
}
