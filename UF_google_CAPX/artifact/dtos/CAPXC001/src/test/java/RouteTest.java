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

public class RouteTest {
	
	Route route = new Route();
	List<Leg> data = new ArrayList<>();
	Leg leg = new Leg();
	Distance distance = new Distance();
	Duration duration = new Duration();
	
	@Before
	public void Starting(){
		
		distance.setText("5 hour 17 min");
		distance.setValue(19024.0);
		duration.setText("307 km");
		duration.setValue(307325.0);
		leg.setDistance(distance);
		leg.setDuration(duration);
		data.add(leg);
		route.setLegs(data);
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals(route.toString(), "Route [legs=" + route.getLegs() + "]");
	}
	
	@Test
	public void testToStringFail() {
		Assert.assertNotSame(route.toString(), "com.bbva.capx.dto.googlemaps.Route@1d56ce6a");
	}
	@Test
	public void testHashCode() {
		int hashCode = route.hashCode();
		Assert.assertEquals(route.hashCode(), hashCode);
	}

	@Test
	public void testHashCodeFail() {
		Assert.assertNotSame(route.hashCode(), 20000);
	}

	@Test
	public void testHashCodeNull() {
		Route base2 = new Route();
		int hashCode = base2.hashCode();
		Assert.assertEquals(base2.hashCode(), hashCode);
	}

	@Test
	public void testEquals() {
		Assert.assertEquals(route.equals(route), true);
		Assert.assertEquals(route.equals(null), false);
		Assert.assertEquals(route.equals(123), false);
		Route valor2 = new Route();
		Assert.assertEquals(valor2.equals(route), false);
		Assert.assertEquals(route.equals(valor2), false);
		
	}

}
