
public class CalcolaPreferenzaTavoli implements IOperazioneSuTavoli {
	
	private Contatore contatoreTavoliVIP;
	private Contatore contatoreTavoliNormali;
	
	public CalcolaPreferenzaTavoli(Contatore tavoliVIP, Contatore tavoliNormali){
		this.contatoreTavoliVIP=tavoliVIP;
		this.contatoreTavoliNormali=tavoliNormali;
	}

	@Override
	public void applicaOperazione(TavoloNormale tavN) {
		this.contatoreTavoliNormali.incrementaContatoreDiUnUnita();
	}

	@Override
	public void applicaOperazione(TavoloVIP tavVIP) {
		this.contatoreTavoliVIP.incrementaContatoreDiUnUnita();

	}

}
