package com.manzoli.bus.route.domain;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

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

	@Fetch
	@RelatedToVia(type = "DIRECT", direction = Direction.BOTH)
	private Set<DirectRoute> directRouteStations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<DirectRoute> getDirectRouteStations() {
		return directRouteStations;
	}

	public void setDirectRouteStations(Set<DirectRoute> directRouteStations) {
		this.directRouteStations = directRouteStations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((directRouteStations == null) ? 0 : directRouteStations.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (directRouteStations == null) {
			if (other.directRouteStations != null)
				return false;
		} else if (!directRouteStations.equals(other.directRouteStations))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", directRouteStations=" + directRouteStations + "]";
	}
}
