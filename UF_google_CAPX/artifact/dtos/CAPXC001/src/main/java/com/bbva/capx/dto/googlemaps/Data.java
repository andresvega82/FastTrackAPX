package com.bbva.capx.dto.googlemaps;

import java.util.List;

import com.bbva.apx.dto.AbstractDTO;

public class Data extends AbstractDTO {

	private static final long serialVersionUID = 1777602927703017783L;
	
	private List<Route> routes;

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoute(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routes == null) ? 0 : routes.hashCode());
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
		Data other = (Data) obj;
		if (routes == null) {
			if (other.routes != null)
				return false;
		} else if (!routes.equals(other.routes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data [routes=" + routes + "]";
	}

	public Data() {
		super();
	}
	

}