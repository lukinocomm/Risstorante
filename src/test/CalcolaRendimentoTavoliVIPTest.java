package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.CalcolaRendimentoTavoliVIP;
import model.Contatore;
import model.TavoloNormale;
import model.TavoloVIP;

public class CalcolaRendimentoTavoliVIPTest {

	@Test
	public void test() {
		Contatore tavoliVIP = new Contatore();
		CalcolaRendimentoTavoliVIP op = new CalcolaRendimentoTavoliVIP(tavoliVIP);
		
		TavoloNormale tN1 = new TavoloNormale(1);
		TavoloNormale tN2 = new TavoloNormale(2);
		TavoloNormale tN3 = new TavoloNormale(3);
		TavoloVIP tv1 = new TavoloVIP(100);
		TavoloVIP tv2 = new TavoloVIP(101);
		
		tN1.eseguiOperazione(op);
		tN2.eseguiOperazione(op);
		tN3.eseguiOperazione(op);
		tv1.eseguiOperazione(op);
		tv2.eseguiOperazione(op);
		
		assertEquals(4, tavoliVIP.getValoreContatore());
		
	}

}
