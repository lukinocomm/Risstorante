
public class CalcolaRendimentoTavoliVIP implements IOperazioneSuTavoli {
	
	private Contatore contatoreTavoliVIP;
	
	public CalcolaRendimentoTavoliVIP(Contatore contatore) {
		this.contatoreTavoliVIP=contatore;
	}

	@Override
	public void applicaOperazione(TavoloNormale tavN) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applicaOperazione(TavoloVIP tavVIP) {
		this.contatoreTavoliVIP.incrementaContatoreConSpecificaQuantita(2);

	}

}
