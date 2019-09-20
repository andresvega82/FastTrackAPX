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

public class DistanceTest {
	
	Distance data = new Distance();
	
	@Before
	public void Starting(){
		data.setText("5 hour 17 min");
		data.setValue(19024.0);
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals(data.toString(), "Distance [text=" + data.getText() + ", value=" + data.getValue() + "]");
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
		Distance valor2 = new Distance();
		Assert.assertEquals(valor2.equals(data), false);
		Assert.assertEquals(data.equals(valor2), false);
		valor2.setText(null);
		valor2.setValue(null);
		data.setText("5 hour 17 min");
		data.setValue(19024.0);
		Assert.assertEquals(valor2.equals(data), false);
		valor2.setText("5 hour 17 min");
		valor2.setValue(19024.0);
		Assert.assertEquals(valor2.equals(data), true);
	}

}
