import org.junit.Before;
import org.junit.Test;

import com.bbva.capx.dto.googlemaps.DataIn;

import junit.framework.Assert;

public class DataInTest {
	
	DataIn data = new DataIn();
	
	@Before
	public void Starting(){
		data.setOrigin("Funza");
		data.setDestination("Bogota");
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals(data.toString(), "DataIn [origin=Funza, destination=Bogota]");
	}
	
	@Test
	public void testToStringFail() {
		Assert.assertNotSame(data.toString(), "com.bbva.capx.dto.googlemaps.Route@1d56ce6a");
	}
	@Test
	public void testHashCode() {
		int hashCode1 = data.getOrigin().hashCode();
		int hashCode2 = data.getDestination().hashCode();
		Assert.assertEquals(data.getOrigin().hashCode(), hashCode1);
		Assert.assertEquals(data.getDestination().hashCode(), hashCode2);
	}

	@Test
	public void testHashCodeFail() {
		Assert.assertNotSame(data.getOrigin().hashCode(), 20000);
		Assert.assertNotSame(data.getDestination().hashCode(), 30000);
	}

	@Test
	public void testHashCodeNull() {
		DataIn base2 = new DataIn();
		base2.setOrigin("Bogota");
		base2.setDestination("Ibague");
		int hashCode = base2.hashCode();
		int hashCode2 = base2.getOrigin().hashCode();
		int hashCode3 = base2.getDestination().hashCode();
		Assert.assertEquals(base2.hashCode(), hashCode);
		Assert.assertEquals(base2.getOrigin().hashCode(), hashCode2);
		Assert.assertEquals(base2.getDestination().hashCode(), hashCode3);
	}

	@Test
	public void testEquals() {
	    Assert.assertEquals(data.equals(data), true);
	    Assert.assertEquals(data.equals(null), false);
	    Assert.assertEquals(data.equals(123), false);
	    DataIn valor2 = new DataIn();
	    Assert.assertEquals(valor2.equals(data), false);
	    Assert.assertEquals(data.equals(valor2), false);
	    valor2.setOrigin(null);
	    valor2.setDestination(null);
	    data.setOrigin(null);
	    data.setDestination(null);
	    Assert.assertEquals(valor2.equals(data), true);
	    valor2.setOrigin("D");
	    Assert.assertEquals(data.equals(valor2), false);
	    Assert.assertEquals(valor2.equals(data), false);
  	}

}
