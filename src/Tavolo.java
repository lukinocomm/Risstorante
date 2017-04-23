
public class Tavolo {
	
	private String tipo;
	private int numero;
	private boolean disponibile;
	
	public Tavolo(String tipo, int numero){
		this.setTipo(tipo);
		this.setNumero(numero);
		this.disponibile=true;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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


	
	
	
	
	

}
