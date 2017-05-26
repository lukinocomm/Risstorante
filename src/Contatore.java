
public class Contatore {
	
	private int valore;
	
	public Contatore(){
		this.valore=0;
	}
	
	public void incrementaContatoreDiUnUnita(){
		this.valore++;
	}
	
	public void incrementaContatoreConSpecificaQuantita(int quantita){
		this.valore= this.valore+quantita;
	}
	
	public int getValoreContatore(){
		return this.valore;
	}
	
	

}
