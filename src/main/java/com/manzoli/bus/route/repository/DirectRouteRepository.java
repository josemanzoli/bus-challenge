package com.manzoli.bus.route.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.manzoli.bus.route.domain.DirectRoute;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT 
 * Repository for DirectRoute entity that will implement the methods to find 
 * the relationship between Route and Station
 *
 */
@Repository
public interface DirectRouteRepository extends GraphRepository<DirectRoute>{


}
