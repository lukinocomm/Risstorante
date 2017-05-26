
public abstract class AbstractTavolo {
	
	private int numero;
	private boolean disponibile;
	
	public AbstractTavolo(int numero){
		this.setNumero(numero);
		this.disponibile=true;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}
	
	abstract protected void eseguiOperazione(IOperazioneSuTavoli iop);

}
