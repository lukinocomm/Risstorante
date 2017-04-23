import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {

		Ristorante ristorante = new Ristorante("La Taverna", "0755732536",
				"Via delle Streghe, 8", "la_taverna@TripAdvisor.it", "M.Rossi");
		
		Cameriere cameriere1 = ristorante.addCameriere("Giorgio", "Rossi");
		Cameriere cameriere2 = ristorante.addCameriere("Matteo", "Gialli");
		Cameriere cameriere3 =  ristorante.addCameriere("Renato", "Bianchi");
		
		Area a1 = ristorante.addArea("A1");
		Area a2 = ristorante.addArea("A2");
		
		Area a3 = ristorante.addAreaAdArea("A3", a1);
		Area a4 = ristorante.addAreaAdArea("A4", a1);
		Area a5 = ristorante.addAreaAdArea("A5", a2);
		Area a6 = ristorante.addAreaAdArea("A6", a2);
		Area a11 = ristorante.addAreaAdArea("A1", a3);
		
		Stanza s1 = ristorante.addStanza("S1", a11);
		Stanza s2 = ristorante.addStanza("S2", a11);
		Stanza s3 = ristorante.addStanza("S3", a11);
		
		Stanza s4 = ristorante.addStanza("S4", a4);
		
		Stanza s5 = ristorante.addStanza("S5", a5);
		Stanza s6 = ristorante.addStanza("S6", a6);
		Stanza s7 = ristorante.addStanza("S7", a6);
		
		Tavolo t1 = ristorante.addTavolo("Normale", 1, s1);
		Tavolo t2 = ristorante.addTavolo("Normale", 2, s1);
		Tavolo t3 = ristorante.addTavolo("Normale", 3, s1);
		Tavolo t4 = ristorante.addTavolo("VIP", 4, s2);
		Tavolo t5 = ristorante.addTavolo("VIP", 5, s3);
		Tavolo t6 = ristorante.addTavolo("Normale", 6, s4);
		
		System.out.println("Tavoli Liberi "+ristorante.calcolaTavoliLiberi());
		System.out.println("Ordinazioni In Corso "+ristorante.calcolaOrdinazioniInCorso());
		
		Ordinazione ord1 = ristorante.addOrdinazione(t1, LocalDateTime.now().minusHours(1), cameriere1);
		Ordinazione ord2 = ristorante.addOrdinazione(t2, LocalDateTime.now().minusHours(2), cameriere2);
		Ordinazione ord3 = ristorante.addOrdinazione(t5, LocalDateTime.now().minusMinutes(35), cameriere2);
		Ordinazione ord4 = ristorante.addOrdinazione(t6, LocalDateTime.now(), cameriere3);
		
		// Non aggiungibile
		Ordinazione ord5 = ristorante.addOrdinazione(t6, LocalDateTime.now().minusMinutes(3), cameriere3); 
		
		System.out.println(ristorante.getListaOrdinazioni().size());
		
		System.out.println("Tavoli Liberi "+ristorante.calcolaTavoliLiberi());
		System.out.println("Ordinazioni In Corso "+ristorante.calcolaOrdinazioniInCorso());
		
		ristorante.archiviaOrdinazione(ord3);
		
		System.out.println("Tavoli Liberi "+ristorante.calcolaTavoliLiberi());
		System.out.println("Ordinazioni In Corso "+ristorante.calcolaOrdinazioniInCorso());
		
		System.out.println("Tavoli Disp in area A11 "+ristorante.getTavoliLiberiInArea(a11));
		System.out.println("Tavoli Disp in area A1 "+ristorante.getTavoliLiberiInArea(a1));
		
		System.out.println("Rendimento Tavoli Normali "+ristorante.getRendimentoTavoliNormali());
		System.out.println("Rendimento Tavoli VIP "+ristorante.getRendimentoTavoliVIP());
		
		System.out.println(ristorante.getPreferenzaTavoliVIPSettimanaPassata());
		

		

		

	}

}
