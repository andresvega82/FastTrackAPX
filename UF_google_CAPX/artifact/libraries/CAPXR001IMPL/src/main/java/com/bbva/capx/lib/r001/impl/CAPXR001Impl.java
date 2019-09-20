package com.bbva.capx.lib.r001.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.capx.dto.googlemaps.Data;
import com.bbva.capx.dto.googlemaps.DataOut;
import com.bbva.capx.dto.googlemaps.Distance;
import com.bbva.capx.dto.googlemaps.Duration;
import com.bbva.capx.lib.r001.CAPXR001;
import com.bbva.capx.lib.r003.CAPXR003;
import com.google.gson.Gson;

public class CAPXR001Impl extends CAPXR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CAPXR001.class);
	
	private CAPXR003 CAPXR003;
	

	public void setCAPXR003(CAPXR003 CAPXR003) {
		this.CAPXR003 = CAPXR003;
	}

	/**
	 * Return best route from any origin to any destination with google maps
	 * api.
	 * 
	 * @param String
	 *            origin
	 * @param String
	 *            destination
	 */
	@Override
	public DataOut executeValidateTravel(String origin, String destination) {

		String resp = CAPXR003.execute(origin, destination).getBody();
		Gson g = new Gson();
		Data p = g.fromJson(resp, Data.class);

		DataOut dataOut = new DataOut();
		Distance distance = new Distance();
		Duration duration = new Duration();

		distance.setText(p.getRoutes().get(0).getLegs().get(0).getDistance().getText());
		distance.setValue(p.getRoutes().get(0).getLegs().get(0).getDistance().getValue());

		duration.setText(p.getRoutes().get(0).getLegs().get(0).getDuration().getText());
		duration.setValue(p.getRoutes().get(0).getLegs().get(0).getDuration().getValue());

		if (p.getRoutes().get(0).getLegs().get(0).getDuration().getValue() != new Double(0)) {
			dataOut.setCost(new Double(distance.getValue() / duration.getValue()));
		} else {
			dataOut.setCost(distance.getValue());
		}

		dataOut.setDistance(distance);
		dataOut.setDuration(duration);
		dataOut.setCurrency("USD");

		return dataOut;

	}

}
