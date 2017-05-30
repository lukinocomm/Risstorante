
public class CalcolaTavoliDisponibiliInArea implements IOperazioneSuSettore{
	
	private Contatore contatore;
	
	public CalcolaTavoliDisponibiliInArea(Contatore contatore){
		this.contatore=contatore;
	}

	@Override
	public void applicaOperazione(Area area) {
		for (ISettore isett : area.getListaSettori()){
			isett.eseguiOperazione(this);	
		}
		
	}

	@Override
	public void applicaOperazione(Stanza stanza) {
		for (AbstractTavolo t : stanza.getListaTavoli()){
			if(t.isDisponibile())
				this.contatore.incrementaContatoreDiUnUnita();
									
		}
		
	}
	
	

}
