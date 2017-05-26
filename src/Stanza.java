import java.util.LinkedList;

public class Stanza {
	
	private LinkedList<AbstractTavolo> listaTavoli;
	private String nome;
	
	public Stanza(String nome){
		this.setNome(nome);
		this.listaTavoli=new LinkedList<>();
	}
	
	public void addTavolo(AbstractTavolo tavolo){
		this.listaTavoli.add(tavolo);
	}
	
	public LinkedList<AbstractTavolo> getListaTavoli(){
		return this.listaTavoli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
