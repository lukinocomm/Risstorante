
public class OrdinazioneNonInCorso implements IState {

	@Override
	public void eseguiOperazione(IOperazioneSuOrdinazione iop) {
		iop.applicaOperazione(this);
		
	}

}
