import java.util.LinkedList;

public class Area implements ISettore{
	
	private LinkedList<ISettore> listaSettori;
	private String nome;
	
	public Area(String nome){
		this.setNome(nome);
		this.listaSettori=new LinkedList<>();
	}
	
	public void addAreaOStanza(ISettore isett){
		this.listaSettori.add(isett);
	}
	
	public LinkedList<ISettore> getListaSettori(){
		return this.listaSettori;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void eseguiOperazione(IOperazioneSuSettore iop) {
		iop.applicaOperazione(this);
		
	}
	
	

}
