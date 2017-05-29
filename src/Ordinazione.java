import java.time.LocalDateTime;
import java.util.LinkedList;

public class Ordinazione {
	
	private AbstractTavolo tavolo;
	private LocalDateTime data;
	private LinkedList<String> listaProdottiOrdinati;
	private Cameriere cameriere;
	private IStrategiaOrdinazione verificaData;
	private IState statoOrdinazione;
	
	public Ordinazione(AbstractTavolo tavolo, LocalDateTime data, Cameriere cameriere){
		this.setTavolo(tavolo);
		this.setData(data);
		this.listaProdottiOrdinati = new LinkedList<>();
		this.setCameriere(cameriere);
		this.verificaData = new VerificaUltimaSettimana();
		this.statoOrdinazione=new OrdinazioneInCorso();
	}

	public AbstractTavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(AbstractTavolo tavolo) {
		this.tavolo = tavolo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public LinkedList<String> getListaProdottiOrdinati() {
		return listaProdottiOrdinati;
	}

	public void addProdotto(String prodotto) {
		this.listaProdottiOrdinati.add(prodotto);
	}
	
	public void archiviaOrdinazione(){
		this.statoOrdinazione=new OrdinazioneNonInCorso();
	}

	public Cameriere getCameriere() {
		return cameriere;
	}

	public void setCameriere(Cameriere cameriere) {
		this.cameriere = cameriere;
	}
	
	public boolean verificaOrdinazioneNelPeriodo(){
		return this.verificaData.eseguiVerificaData(this.data);
	}
	
	public void cambiaIntervalloDiVerificaDellaData(IStrategiaOrdinazione istr){
		this.verificaData=istr;
	}
	
	public IState getStatoOrdinazione(){
		return this.statoOrdinazione;
	}
	

}
