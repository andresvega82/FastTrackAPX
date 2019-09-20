import org.junit.Before;
import org.junit.Test;

import com.bbva.capx.dto.googlemaps.DataIn;
import com.bbva.capx.dto.googlemaps.DataOut;
import com.bbva.capx.dto.googlemaps.Distance;
import com.bbva.capx.dto.googlemaps.Duration;

import junit.framework.Assert;

public class DataOutTest {

	DataOut data = new DataOut();
	Distance distance = new Distance();
	Duration duration = new Duration();

	@Before
	public void Starting() {
		distance.setText("5 hour 17 min");
		distance.setValue(19024.0);
		duration.setText("307 km");
		duration.setValue(307325.0);
		data.setDistance(distance);
		data.setDuration(duration);
		data.setCost(3.500);
		data.setCurrency("COP");
	}

	@Test
	public void testToString() {
		Assert.assertEquals(data.toString(),
				"DataOut [distance=Distance [text=5 hour 17 min, value=19024.0], duration=Duration [text=307 km, value=307325.0], cost=3.5, currency=COP]");
	}

	@Test
	public void testToStringFail() {
		Assert.assertNotSame(data.toString(), "com.bbva.capx.dto.googlemaps.Route@1d56ce6a");
	}

	@Test
	public void testHashCode() {
		int hashCode1 = data.getCurrency().hashCode();
		int hashCode2 = data.getDistance().hashCode();
		int hashCode3 = data.getDuration().hashCode();
		Assert.assertEquals(data.getCurrency().hashCode(), hashCode1);
		Assert.assertEquals(data.getDistance().hashCode(), hashCode2);
		Assert.assertEquals(data.getDuration().hashCode(), hashCode3);
	}

	@Test
	public void testHashCodeFail() {
		Assert.assertNotSame(data.getDistance().hashCode(), 20000);
		Assert.assertNotSame(data.getDuration().hashCode(), 30000);
		Assert.assertNotSame(data.getCost().hashCode(), 40000);
	}

	@Test
	public void testHashCodeNull() {
		DataOut base2 = new DataOut();
		base2.setCost(3.900);
		base2.setCurrency("USD");
		base2.setDistance(distance);
		base2.setDuration(duration);
		int hashCode = base2.hashCode();
		int hashCode2 = base2.getCost().hashCode();
		int hashCode3 = base2.getCurrency().hashCode();
		int hashCode4 = base2.getDistance().hashCode();
		int hashCode5 = base2.getDuration().hashCode();
		Assert.assertEquals(base2.hashCode(), hashCode);
		Assert.assertEquals(base2.getCost().hashCode(), hashCode2);
		Assert.assertEquals(base2.getCurrency().hashCode(), hashCode3);
		Assert.assertEquals(base2.getDistance().hashCode(), hashCode4);
		Assert.assertEquals(base2.getDuration().hashCode(), hashCode5);
	}

	@Test
	public void testEquals() {
		Assert.assertEquals(data.equals(data), true);
		Assert.assertEquals(data.equals(null), false);
		Assert.assertEquals(data.equals(123), false);
		DataOut valor2 = new DataOut();
		Assert.assertEquals(valor2.equals(data), false);
		Assert.assertEquals(data.equals(valor2), false);
		valor2.setCost(null);
		valor2.setCurrency(null);
		valor2.setDistance(null);
		valor2.setDuration(null);
		data.setCost(null);
		data.setCurrency(null);
		data.setDistance(null);
		data.setDuration(null);
		Assert.assertEquals(valor2.equals(data), true);
		valor2.setCost(6.900);
		valor2.setCurrency("COP");
		valor2.setDistance(distance);
		valor2.setDuration(duration);
		Assert.assertEquals(data.equals(valor2), false);
		Assert.assertEquals(valor2.equals(data), false);
	}

}
