package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.CalcolaTavoliDisponibiliInArea;
import model.Area;
import model.Contatore;
import model.Ordinazione;
import model.Stanza;
import model.TavoloNormale;
import model.TavoloVIP;

public class CalcolaTavoliDisponibiliInAreaTest {

	@Test
	public void test() {

		Area a1 = new Area("A1");
		Stanza s1 = new Stanza("S1");
		a1.addAreaOStanza(s1);
		
		TavoloNormale tN1 = new TavoloNormale(1);
		TavoloNormale tN2 = new TavoloNormale(2);
		TavoloVIP tV1 = new TavoloVIP(3);
		
		s1.addTavolo(tV1);
		s1.addTavolo(tN2);
		s1.addTavolo(tN1);
		
		Contatore contatore = new Contatore();
		CalcolaTavoliDisponibiliInArea op = new CalcolaTavoliDisponibiliInArea(contatore);
		
		a1.eseguiOperazione(op);
		
		assertEquals(3, contatore.getValoreContatore());

		
	}

}
