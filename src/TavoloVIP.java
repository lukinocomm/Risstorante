
public class TavoloVIP extends AbstractTavolo {

	public TavoloVIP(int numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void eseguiOperazione(IOperazioneSuTavoli iop) {
		iop.applicaOperazione(this);
		
	}

}
