package com.bbva.capx.dto.googlemaps;


import java.util.List;

import com.bbva.apx.dto.AbstractDTO;

public class Route extends AbstractDTO {

	private static final long serialVersionUID = -8251516279524294699L;
	
	private List<Leg> legs;

	public List<Leg> getLegs() {
		return legs;
	}

	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((legs == null) ? 0 : legs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (legs == null) {
			if (other.legs != null)
				return false;
		} else if (!legs.equals(other.legs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Route [legs=" + legs + "]";
	}

	public Route() {
		super();
	}

}