import java.time.LocalDateTime;
import java.util.LinkedList;

public class Ordinazione {
	
	private AbstractTavolo tavolo;
	private LocalDateTime data;
	private LinkedList<String> listaProdottiOrdinati;
	private boolean inCorso;
	private Cameriere cameriere;
	
	public Ordinazione(AbstractTavolo tavolo, LocalDateTime data, Cameriere cameriere){
		this.setTavolo(tavolo);
		this.setData(data);
		this.listaProdottiOrdinati = new LinkedList<>();
		this.setInCorso(true);
		this.setCameriere(cameriere);
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

	public boolean isInCorso() {
		return inCorso;
	}

	public void setInCorso(boolean inCorso) {
		this.inCorso = inCorso;
	}

	public Cameriere getCameriere() {
		return cameriere;
	}

	public void setCameriere(Cameriere cameriere) {
		this.cameriere = cameriere;
	}
	
	
	
	

}
