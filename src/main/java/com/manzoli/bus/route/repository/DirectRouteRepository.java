package com.manzoli.bus.route.repository;

import java.util.Set;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.domain.Route;
import com.manzoli.bus.route.domain.Station;

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

	/**
	 * 
	 * @param {@link Route} from
	 * @return A Set of {@link DirectRoute} that represents all the connections
	 * between Route and Station
	 */
	public Set<DirectRoute> findAllByFrom(Route from);
	
	/**
	 * 
	 * @param {@link Station} to
	 * @return A Set of {@link DirectRoute} that represents all the connections
	 * between Station and Route
	 */
	public Set<DirectRoute> findAllByTo(Station to);
}
