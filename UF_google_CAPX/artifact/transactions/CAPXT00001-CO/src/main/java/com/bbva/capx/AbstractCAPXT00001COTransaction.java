package com.bbva.capx;

import java.util.List;
import com.bbva.capx.dto.googlemaps.DataIn;
import com.bbva.capx.dto.googlemaps.DataOut;

import com.bbva.elara.transaction.AbstractTransaction;

public abstract class AbstractCAPXT00001COTransaction extends AbstractTransaction {

	public AbstractCAPXT00001COTransaction(){
	}
	
	

	/**
	 * Return value for input parameter travelInfo
	 */
	protected DataIn getTravelinfo(){
		return (DataIn)getParameter("travelInfo");
	}
	
	
	

	/**
	 * Set value for output parameter EntityList
	 */
	protected void setEntitylist(final List<DataOut> field){
		this.addParameter("EntityList", field);
	}			
	
}
