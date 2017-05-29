
public class OrdinazioneInCorso implements IState {

	@Override
	public void eseguiOperazione(IOperazioneSuOrdinazione iop) {
		iop.applicaOperazione(this);
		
	}


}
