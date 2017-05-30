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
	private LinkedList<IObserverOrdinazioni> listaOsservatoriOrdinazioni;
	private LinkedList<IObserverTavoli> listaOsservatoriTavoli;
	
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
		this.listaOsservatoriOrdinazioni = new LinkedList<>();
		this.listaOsservatoriTavoli = new LinkedList<>();
		
	}
	
	public void addOsservatorePerOrdinazione(IObserverOrdinazioni iob){
		this.listaOsservatoriOrdinazioni.add(iob);
	}
	
	public void removeOsservatorePerOrdinazione(IObserverOrdinazioni iob){
		this.listaOsservatoriOrdinazioni.remove(iob);
	}
	
	public void addOsservatoreTavoli(IObserverTavoli iob){
		this.listaOsservatoriTavoli.add(iob);
	}
	
	public void removeOsservatoreTavoli(IObserverTavoli iob){
		this.listaOsservatoriTavoli.remove(iob);
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
			for (IObserverOrdinazioni o : this.listaOsservatoriOrdinazioni){
				o.update(ordinazione);
			}
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
		//this.listaTavoli.add(tavolo);
		return tavolo;
	}
	
	public TavoloVIP addTavoloVIP(int numero, Stanza stanza){
		TavoloVIP tavolo = new TavoloVIP(numero);
		stanza.addTavolo(tavolo);
		//this.listaTavoli.add(tavolo);
		return tavolo;
	}
	
	public Area addArea(String nome){
		Area area = new Area(nome);
		this.listAree.add(area);
		return area;
	}
	
	public Area addAreaAdArea(String nome, Area contenitore){
		Area area = new Area(nome);
		contenitore.addAreaOStanza(area);
		return area;
	}
	
	public Stanza addStanza(String nome, Area contenitore){
		Stanza stanza = new Stanza(nome);
		contenitore.addAreaOStanza(stanza);
		return stanza;
	}
	
	public void liberaTavolo(Ordinazione ordinazione){
		ordinazione.archiviaOrdinazione();
		ordinazione.getTavolo().setDisponibile(true);
		for (IObserverTavoli o : this.listaOsservatoriTavoli){
			o.update(ordinazione.getTavolo());
		}
	}
	
	public int getOrdinazioniInCorso(){
		Contatore count=new Contatore();
		CalcolaOrdinazioniInCorso operazione = new CalcolaOrdinazioniInCorso(count);
		for (Ordinazione ordinazione : listaOrdinazioni) {
			ordinazione.getStatoOrdinazione().eseguiOperazione(operazione);
		}
		return count.getValoreContatore();
	}
	
	
	public int getTavoliLiberi(){
		Contatore contatore = new Contatore();
		CalcolaTavoliDisponibiliInArea operazione = new CalcolaTavoliDisponibiliInArea(contatore);
		for (Area area : listAree){
			operazione.applicaOperazione(area);
		}
		return contatore.getValoreContatore();
	}
	
	
	public int getTavoliLiberiInArea(Area a){
		Contatore contatore = new Contatore();
		CalcolaTavoliDisponibiliInArea operazione = new CalcolaTavoliDisponibiliInArea(contatore);
		operazione.applicaOperazione(a);
		return contatore.getValoreContatore();
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
			if(ordinazione.verificaOrdinazioneNelPeriodo()){
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
