import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bbva.capx.dto.googlemaps.Data;
import com.bbva.capx.dto.googlemaps.Distance;
import com.bbva.capx.dto.googlemaps.Duration;
import com.bbva.capx.dto.googlemaps.Leg;
import com.bbva.capx.dto.googlemaps.Route;

import junit.framework.Assert;

public class LegTest {
	
	Leg data = new Leg();
	Distance distance = new Distance();
	Duration duration = new Duration();
	
	@Before
	public void Starting(){
		distance.setText("5 hour 17 min");
		distance.setValue(19024.0);
		duration.setText("307 km");
		duration.setValue(307325.0);
		data.setDistance(distance);
		data.setDuration(duration);
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals(data.toString(), "Leg [distance=" + distance + ", duration=" + duration + "]");
	}
	
	@Test
	public void testToStringFail() {
		Assert.assertNotSame(data.toString(), "com.bbva.capx.dto.googlemaps.Route@1d56ce6a");
	}
	@Test
	public void testHashCode() {
		int hashCode = data.hashCode();
		Assert.assertEquals(data.hashCode(), hashCode);
	}

	@Test
	public void testHashCodeFail() {
		Assert.assertNotSame(data.hashCode(), 20000);
	}

	@Test
	public void testHashCodeNull() {
		Leg base2 = new Leg();
		int hashCode = base2.hashCode();
		Assert.assertEquals(base2.hashCode(), hashCode);
	}

	@Test
	public void testEquals() {
		Assert.assertEquals(data.equals(data), true);
		Assert.assertEquals(data.equals(null), false);
		Assert.assertEquals(data.equals(123), false);
		Leg valor2 = new Leg();
		Assert.assertEquals(valor2.equals(data), false);
		Assert.assertEquals(data.equals(valor2), false);
		valor2.setDistance(null);
		valor2.setDuration(null);
		data.setDistance(null);
		data.setDuration(null);
		Assert.assertEquals(valor2.equals(data), true);
	}

}
