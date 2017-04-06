package com.manzoli.bus.route.repository;

import java.util.stream.Stream;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.manzoli.bus.route.domain.DirectRoute;
import com.manzoli.bus.route.domain.Route;
import com.manzoli.bus.route.domain.Station;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT Repository for DirectRoute entity that will implement the
 *        methods to find the relationship between Route and Station
 *
 */
@Repository
public interface DirectRouteRepository extends GraphRepository<DirectRoute> {

	public DirectRoute findById(Long id);

	public Stream<DirectRoute> findAllByFrom(Route from);

	public Stream<DirectRoute> findAllByTo(Station to);
}
