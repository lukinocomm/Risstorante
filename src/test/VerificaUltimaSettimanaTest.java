package test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Test;

import model.VerificaUltimaSettimana;

public class VerificaUltimaSettimanaTest {
	

	@Test
	public void testEseguiVerificaData() {
		VerificaUltimaSettimana ver = new VerificaUltimaSettimana();
		assertEquals(true, ver.eseguiVerificaData(LocalDateTime.now().minusDays(5)));
		assertEquals(false, ver.eseguiVerificaData(LocalDateTime.now().minusDays(8)));
	}

}
