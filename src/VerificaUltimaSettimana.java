import java.time.LocalDateTime;

public class VerificaUltimaSettimana implements IStrategiaOrdinazione {

	@Override
	public boolean eseguiVerificaData(LocalDateTime data) {
		return (data.isAfter(LocalDateTime.now().minusDays(1).minusWeeks(1)) && 
				data.isBefore(LocalDateTime.now().plusDays(1)));
	}

}
