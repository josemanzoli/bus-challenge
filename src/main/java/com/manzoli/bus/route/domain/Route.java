package com.manzoli.bus.route.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT 
 * Node Entity for the representation of a Route
 *
 */
@NodeEntity
public class Route {

	@GraphId
	private Long id;
	
	@Relationship(type = DirectRoute.TYPE, direction="BOTH")
	private Set<DirectRoute> stations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<DirectRoute> getStations() {
		return stations;
	}

	public void setStations(Set<DirectRoute> stations) {
		this.stations = stations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stations == null) ? 0 : stations.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stations == null) {
			if (other.stations != null)
				return false;
		} else if (!stations.equals(other.stations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", stations=" + stations + "]";
	}

}
