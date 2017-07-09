package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.Test;

import controller.CalcolaOrdinazioniInCorso;
import model.Area;
import model.Cameriere;
import model.Contatore;
import model.Ordinazione;
import model.Ristorante;
import model.Stanza;
import model.TavoloNormale;
import model.TavoloVIP;

public class CalcolaOrdinazioniInCorsoTest {

	@Test
	public void test() throws Exception {
		
		Contatore count = new Contatore();
		CalcolaOrdinazioniInCorso op = new CalcolaOrdinazioniInCorso(count);
		
		Ordinazione o1 = new Ordinazione(1, null, null, null);
		Ordinazione o2 = new Ordinazione(1, null, null, null);
		Ordinazione o3 = new Ordinazione(1, null, null, null);
		Ordinazione o4 = new Ordinazione(1, null, null, null);
		Ordinazione o5 = new Ordinazione(1, null, null, null);
		
		o2.archiviaOrdinazione();
		o3.archiviaOrdinazione();
		
		o1.getStatoOrdinazione().eseguiOperazione(op);
		o2.getStatoOrdinazione().eseguiOperazione(op);
		o3.getStatoOrdinazione().eseguiOperazione(op);
		o4.getStatoOrdinazione().eseguiOperazione(op);
		o5.getStatoOrdinazione().eseguiOperazione(op);
		
		assertEquals(3, count.getValoreContatore());
		
	}

}
