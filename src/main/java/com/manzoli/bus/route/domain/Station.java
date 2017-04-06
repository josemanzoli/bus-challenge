package com.manzoli.bus.route.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT 
 * Node Entity for the representation of a Station
 *
 */
@NodeEntity
public class Station {

	@GraphId 
	private Long id;
	
	public Station(){
		
	}
	
	public Station(Long id){
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
