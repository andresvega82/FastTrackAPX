package com.bbva.capx;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.capx.dto.googlemaps.DataIn;
import com.bbva.capx.dto.googlemaps.DataOut;
import com.bbva.capx.lib.r001.CAPXR001;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;

/**
 * qwerty
 * Implementacion de logica de negocio.
 * @author bbva
 *
 */
public class CAPXT00001COTransaction extends AbstractCAPXT00001COTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CAPXT00001COTransaction.class);
	
	
	/**
	 * Calculate best route with to params, origin and destination
	 */
	@Override
	public void execute() {
		
		
		DataIn travelInfo = this.getTravelinfo();			
		
		CAPXR001 capxR001 = (CAPXR001)getServiceLibrary(CAPXR001.class);
		
		DataOut data = capxR001.executeValidateTravel(travelInfo.getOrigin(), travelInfo.getDestination());		
		List<DataOut> response = new ArrayList<>();		
		response.add(data);				
		
		this.setContentLocation(getURIPath());
		this.setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
		
		
		
		
		setEntitylist(response);
		
	}

}
