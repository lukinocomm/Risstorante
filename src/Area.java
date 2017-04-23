import java.util.LinkedList;

public class Area {
	
	private LinkedList<Area> listaAree;
	private LinkedList<Stanza> listaStanze;
	private String nome;
	
	public Area(String nome){
		this.setNome(nome);
		this.listaAree=new LinkedList<>();
		this.listaStanze=new LinkedList<>();
	}
	
	public void addArea(Area area){
		this.listaAree.add(area);
	}
	
	public LinkedList<Area> getListaAree(){
		return this.listaAree;
	}
	
	public void addStanza(Stanza stanza){
		this.listaStanze.add(stanza);
	}
	
	public LinkedList<Stanza> getListaStanze(){
		return this.listaStanze;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
