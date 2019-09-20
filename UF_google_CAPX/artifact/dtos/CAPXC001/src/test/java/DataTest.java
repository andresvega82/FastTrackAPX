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

public class DataTest {
	
	Data data = new Data();
	Route routes = new Route();
	List<Route> route = new ArrayList<>();
	Leg legs = new Leg();
	List<Leg> leg = new ArrayList<>();
	Distance distance = new Distance();
	Duration duration = new Duration();
	
	@Before
	public void Starting(){
		distance.setText("5 hour 17 min");
		distance.setValue(19024.0);
		duration.setText("307 km");
		duration.setValue(307325.0);
		legs.setDistance(distance);
		legs.setDuration(duration);
		leg.add(legs);
		routes.setLegs(leg);
		route.add(routes);
		data.setRoute(route);
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals(data.toString(), "Data [routes=" + data.getRoutes().toString() + "]");
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
		Data base2 = new Data();
		int hashCode = base2.hashCode();
		Assert.assertEquals(base2.hashCode(), hashCode);
	}

	@Test
	public void testEquals() {
		Assert.assertEquals(data.equals(data), true);
		Assert.assertEquals(data.equals(null), false);
		Assert.assertEquals(data.equals(123), false);
		Data valor2 = new Data();
		Assert.assertEquals(valor2.equals(data), false);
		Assert.assertEquals(data.equals(valor2), false);
		valor2.setRoute(null);
		data.setRoute(new ArrayList<>());
		Assert.assertEquals(valor2.equals(data), false);
		valor2.setRoute(new ArrayList<>());
		Assert.assertEquals(valor2.equals(data), true);
	}

}
