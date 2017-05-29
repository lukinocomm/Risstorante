
public class CalcolaOrdinazioniInCorso implements IOperazioneSuOrdinazione {
	
	private Contatore contatore;
	
	public CalcolaOrdinazioniInCorso(Contatore contatore){
		this.contatore=contatore;
	}

	@Override
	public void applicaOperazione(OrdinazioneInCorso oic) {
		this.contatore.incrementaContatoreDiUnUnita();

	}

	@Override
	public void applicaOperazione(OrdinazioneNonInCorso onic) {
		// TODO Auto-generated method stub

	}

}
