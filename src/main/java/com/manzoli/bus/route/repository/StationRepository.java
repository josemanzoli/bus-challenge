package com.manzoli.bus.route.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.manzoli.bus.route.domain.Station;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT 
 * Basic repository for the Station entity
 *
 */
@Repository
public interface StationRepository extends GraphRepository<Station>{
	
	public Station findById(Long id);
}
