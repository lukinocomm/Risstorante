import java.time.LocalDateTime;
import java.util.LinkedList;

public class Ristorante {
	
	private String nome;
	private String telefono;
	private String indirizzo;
	private String email;
	private String direttore;
	private LinkedList<Cameriere> listaCamerieri;
	private LinkedList<Ordinazione> listaOrdinazioni;
	private LinkedList<Area> listAree;
	private LinkedList<AbstractTavolo> listaTavoli;
	
	public Ristorante(String nome, String telefono, String indirizzo, String email, 
			String direttore){
		
		this.nome=nome;
		this.telefono=telefono;
		this.indirizzo=indirizzo;
		this.email=email;
		this.direttore=direttore;
		this.listaCamerieri = new LinkedList<Cameriere>();
		this.listaOrdinazioni = new LinkedList<Ordinazione>();
		this.listAree = new LinkedList<Area>();
		this.listaTavoli = new LinkedList<AbstractTavolo>();
		
	}
	
	public Cameriere addCameriere(String nome, String cognome){
		Cameriere cameriere = new Cameriere(nome, cognome);
		this.listaCamerieri.add(cameriere);
		return cameriere;
	}
	
	public LinkedList<Cameriere> getListaCamerieri(){
		return this.listaCamerieri;
	}
	
	public void removeCameriere(Cameriere cameriere){
		this.listaCamerieri.remove(cameriere);
	}
	
	public Ordinazione addOrdinazione(AbstractTavolo tavolo, LocalDateTime data, Cameriere cameriere){
		Ordinazione ordinazione = new Ordinazione(tavolo, data, cameriere);
		if(tavolo.isDisponibile()){
			this.listaOrdinazioni.add(ordinazione);
			tavolo.setDisponibile(false);
		}
		return ordinazione;
	}
	
	public LinkedList<Ordinazione> getListaOrdinazioni(){
		return this.listaOrdinazioni;
	}
	
	public void removeOrdinazione(Ordinazione ordinazione){
		this.listaOrdinazioni.remove(ordinazione);
	}
	
	public void addProdottoAOrdinazione(String prodotto, Ordinazione ordinazione){
		ordinazione.addProdotto(prodotto);
	}
	
	public TavoloNormale addTavoloNormale(int numero, Stanza stanza){
		TavoloNormale tavolo = new TavoloNormale(numero);
		stanza.addTavolo(tavolo);
		this.listaTavoli.add(tavolo);
		return tavolo;
	}
	
	public TavoloVIP addTavoloVIP(int numero, Stanza stanza){
		TavoloVIP tavolo = new TavoloVIP(numero);
		stanza.addTavolo(tavolo);
		this.listaTavoli.add(tavolo);
		return tavolo;
	}
	
	public Area addArea(String nome){
		Area area = new Area(nome);
		this.listAree.add(area);
		return area;
	}
	
	public Area addAreaAdArea(String nome, Area contenitore){
		Area area = new Area(nome);
		contenitore.addArea(area);
		return area;
	}
	
	public Stanza addStanza(String nome, Area contenitore){
		Stanza stanza = new Stanza(nome);
		contenitore.addStanza(stanza);
		return stanza;
	}
	
	public void archiviaOrdinazione(Ordinazione ordinazione){
		ordinazione.setInCorso(false);
		ordinazione.getTavolo().setDisponibile(true);
	}
	
	public int calcolaOrdinazioniInCorso(){
		int count=0;
		for (Ordinazione ordinazione : listaOrdinazioni) {
			if(ordinazione.isInCorso())
				count++;
		}
		return count;
	}
	
	
	public int calcolaTavoliLiberi(){
		int count=0;
		for (AbstractTavolo tavolo : listaTavoli) {
			if(tavolo.isDisponibile())
				count++;
		}
		return count;
	}
	
	
	
	public int getTavoliLiberiInArea(Area a){
		int count=0;
		
		//Caso Induttivo
		if(a.getListaAree().size()!=0){
			for (Area area : a.getListaAree()) {
				count+=this.getTavoliLiberiInArea(area);
			}
		}
		
		// Caso Base
		else{
			for (Stanza stanza : a.getListaStanze()){
				for (AbstractTavolo tavolo : stanza.getListaTavoli()){
					if(tavolo.isDisponibile())
						count++;
				}				
			}
		}
		return count;
	}
	
	public int getRendimentoTavoliVIP(){
		Contatore contatore = new Contatore();
		IOperazioneSuTavoli iop = new CalcolaRendimentoTavoliVIP(contatore);
		for (Ordinazione ordinazione : listaOrdinazioni) {
			ordinazione.getTavolo().eseguiOperazione(iop);
		}
		return contatore.getValoreContatore();
	}
	
	
	public boolean getPreferenzaTavoliVIPSettimanaPassata(){
		Contatore tavVIP=new Contatore();
		Contatore tavNor=new Contatore();
		IOperazioneSuTavoli iop = new CalcolaPreferenzaTavoli(tavVIP, tavNor);
		for (Ordinazione ordinazione : listaOrdinazioni) {
			if(ordinazione.getData().isAfter(LocalDateTime.now().minusDays(1).minusWeeks(1)) &&
					ordinazione.getData().isBefore(LocalDateTime.now().plusDays(1))){
				ordinazione.getTavolo().eseguiOperazione(iop);
			}
		}
		
		return tavVIP.getValoreContatore()>=tavNor.getValoreContatore();
		
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDirettore() {
		return direttore;
	}
	
	public void setDirettore(String direttore) {
		this.direttore = direttore;
	}
	
	

}
